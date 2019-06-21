using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.IdentityModel.Tokens;
using System;
using System.Text;
using System.Threading.Tasks;
using TodoApp.Exceptions;
using TodoApp.Models;
using TodoApp.Services;

namespace TodoApp.Configs
{
    public static class ServiceCollectionExtensions
    {
        public static IServiceCollection AddConfiguredAuthentication(this IServiceCollection services, IConfiguration configuration)
        {
            var tokenSettingsSection = configuration.GetSection("TokenSettings");
            var tokenSettings = tokenSettingsSection.Get<TokenSettings>();
            var key = Encoding.ASCII.GetBytes(tokenSettings.Secret);

            services.Configure<TokenSettings>(tokenSettingsSection);
            services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme)
                .AddJwtBearer(opt =>
                {
                    opt.Events = new JwtBearerEvents { OnTokenValidated = OnTokenValidatedHandler };
                    opt.TokenValidationParameters = GenerateTokenValidationParameters(key);
                });

            return services;
        }

        private static readonly Func<TokenValidatedContext, Task> OnTokenValidatedHandler = context =>
        {
            var userService = context.HttpContext.RequestServices.GetRequiredService<IUserService>();
            var userId = long.Parse(context.Principal.Identity.Name);
            if (!userService.Exists(userId))
            {
                throw new UnauthorizedException("User not exist!");
            }
            return Task.CompletedTask;
        };

        private static TokenValidationParameters GenerateTokenValidationParameters(byte[] key)
        {
            return new TokenValidationParameters
            {
                ValidateIssuerSigningKey = true,
                IssuerSigningKey = new SymmetricSecurityKey(key),
                ValidateIssuer = false,
                ValidateAudience = false
            };
        }
    }
}
