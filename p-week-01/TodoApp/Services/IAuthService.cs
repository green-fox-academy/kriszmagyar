using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TodoApp.Models.User;

namespace TodoApp.Services
{
    public interface IAuthService
    {
        UserModel Create(UserReq userReq);
        UserDto Authenticate(UserReq userReq);
    }
}
