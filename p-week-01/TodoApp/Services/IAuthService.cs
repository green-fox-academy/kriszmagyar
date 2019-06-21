using TodoApp.Models.User;

namespace TodoApp.Services
{
    public interface IAuthService
    {
        UserModel Create(UserReq userReq);
        UserDto Authenticate(UserReq userReq);
    }
}
