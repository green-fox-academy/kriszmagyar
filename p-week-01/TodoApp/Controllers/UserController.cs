using Microsoft.AspNetCore.Mvc;
using TodoApp.Models.User;
using TodoApp.Services;

namespace TodoApp.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {
        private readonly IAuthService authService;
        private readonly IUserService userService;

        public UserController(IAuthService authService, IUserService userService)
        {
            this.authService = authService;
            this.userService = userService;
        }

        [HttpPost("login")]
        public IActionResult Login([FromBody] UserReq userReq)
        {
            var userDto = authService.Authenticate(userReq);
            return Ok(userDto);
        }

        [HttpPost("register")]
        public IActionResult Register([FromBody] UserReq userReq)
        {
            var user = authService.Create(userReq);
            return Ok(new UserDto() { Id = user.Id, Username = user.Username, Role = user.Role });
        }
    }
}