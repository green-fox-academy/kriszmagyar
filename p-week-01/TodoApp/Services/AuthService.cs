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
using TodoApp.Models.User;

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

        public UserModel Create(UserReq userReq)
        {
            if (userService.Exists(userReq.Username))
            {
                throw new ArgumentException($"Username ({userReq.Username}) is already in use!");
            }

            CreatePasswordHash(userReq.Password, out byte[] passwordHash, out byte[] passwordSalt);
            return userService.Add(new UserModel()
            {
                Username = userReq.Username,
                PasswordHash = passwordHash,
                PasswordSalt = passwordSalt,
                Role = Role.User
            });
        }

        private void CreatePasswordHash(string password, out byte[] passwordHash, out byte[] passwordSalt)
        {
            using (var hmac = new System.Security.Cryptography.HMACSHA512())
            {
                passwordSalt = hmac.Key;
                passwordHash = hmac.ComputeHash(Encoding.UTF8.GetBytes(password));
            }
        }

        public UserDto Authenticate(UserReq userReq)
        {
            var user = GetValidUser(userReq);
            return new UserDto() { Id = user.Id, Username = user.Username, Role = user.Role, Token = GetUserToken(user) };
        }

        private UserModel GetValidUser(UserReq userReq)
        {
            var user = userService.FindByUsername(userReq.Username);
            if (!VerifyPasswordHash(userReq.Password, user.PasswordHash, user.PasswordSalt))
            {
                throw new ArgumentException($"Password for {user.Username} is incorrect!");
            }
            return user;
        }

        private static bool VerifyPasswordHash(string password, byte[] storedHash, byte[] storedSalt)
        {
            if (storedHash.Length != 64) throw new ArgumentException("Invalid length of password hash (64 bytes expected).", "passwordHash");
            if (storedSalt.Length != 128) throw new ArgumentException("Invalid length of password salt (128 bytes expected).", "passwordHash");

            using (var hmac = new System.Security.Cryptography.HMACSHA512(storedSalt))
            {
                var computedHash = hmac.ComputeHash(Encoding.UTF8.GetBytes(password));
                return IsEquals(computedHash, storedHash);
            }
        }

        private static bool IsEquals(byte[] arr1, byte[] arr2)
        {
            for (int i = 0; i < arr1.Length; i++)
            {
                if (arr1[i] != arr2[i])
                {
                    return false;
                }
            }
            return true;
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
