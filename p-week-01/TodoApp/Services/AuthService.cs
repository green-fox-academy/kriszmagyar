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
            if (!username.Equals("Admin") || !password.Equals("password"))
            {
                return null;
            }

            var key = Encoding.ASCII.GetBytes(tokenSettings.Secret);
            var tokenDescriptor = new SecurityTokenDescriptor
            {
                Subject = new ClaimsIdentity(new Claim[]
                {
                    new Claim(ClaimTypes.Name, username)
                }),
                Expires = DateTime.UtcNow.AddDays(tokenSettings.AccessExpiration),
                SigningCredentials = new SigningCredentials(new SymmetricSecurityKey(key), SecurityAlgorithms.HmacSha256Signature)
            };
            var tokenHandler = new JwtSecurityTokenHandler();
            var token = tokenHandler.CreateToken(tokenDescriptor);
            var userToken = tokenHandler.WriteToken(token);

            return new UserModel() { Username = username, Token = userToken };
        }
    }
}
