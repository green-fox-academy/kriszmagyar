using Microsoft.Extensions.Options;
using Microsoft.IdentityModel.Tokens;
using System.Security.Claims;
using System;
using System.Collections.Generic;
using System.IdentityModel.Tokens.Jwt;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TodoApp.Models;

namespace TodoApp.Services
{
    public class AuthService : IAuthService
    {
        private readonly TokenSettings tokenSettings;

        public AuthService(IOptions<TokenSettings> tokenSettings)
        {
            this.tokenSettings = tokenSettings.Value;
        }

        public UserModel Authenticate(string username, string password)
        {
            var user = GetValidUser(username, password);
            if (user == null)
            {
                return null;
            }
            user.Token = GetUserToken(user);
            return user;
        }

        private UserModel GetValidUser(string username, string password)
        {
            if (IsValidUser(username, password))
            {
                return null;
            }
            return new UserModel() { Username = username };
        }

        private bool IsValidUser(string username, string password)
        {
            return !username.Equals("Admin") || !password.Equals("password");
        }

        private string GetUserToken(UserModel user)
        {
            var key = Encoding.ASCII.GetBytes(tokenSettings.Secret);
            var tokenDescriptor = new SecurityTokenDescriptor
            {
                Subject = new ClaimsIdentity(new Claim[]
                {
                    new Claim(ClaimTypes.NameIdentifier, user.Id.ToString())
                }),
                Expires = DateTime.UtcNow.AddDays(tokenSettings.AccessExpiration),
                SigningCredentials = new SigningCredentials(new SymmetricSecurityKey(key), SecurityAlgorithms.HmacSha256Signature)
            };
            var tokenHandler = new JwtSecurityTokenHandler();
            var token = tokenHandler.CreateToken(tokenDescriptor);
            return tokenHandler.WriteToken(token);
        }
    }
}
