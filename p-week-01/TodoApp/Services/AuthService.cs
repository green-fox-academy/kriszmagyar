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
        private readonly IUserService userService;

        public AuthService(IOptions<TokenSettings> tokenSettings, IUserService userService)
        {
            this.tokenSettings = tokenSettings.Value;
            this.userService = userService;
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
            var user = userService.FindByUsername(username);
            if (user == null || !user.Password.Equals(password))
            {
                return null;
            }
            return user;
        }

        private string GetUserToken(UserModel user)
        {
            var key = Encoding.ASCII.GetBytes(tokenSettings.Secret);
            var tokenDescriptor = new SecurityTokenDescriptor
            {
                Subject = new ClaimsIdentity(new Claim[]
                {
                    new Claim(ClaimTypes.Name, user.Id.ToString()),
                    new Claim(ClaimTypes.Role, user.Role)
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
