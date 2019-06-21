﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
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
        public IActionResult Login([FromBody] UserModel userParam)
        {
            var user = authService.Authenticate(userParam.Username, userParam.Password);
            if (user == null)
            {
                return BadRequest(new { message = "Username or password is incorrect" });
            }
            return Ok(user);
        }

        [HttpPost("register")]
        public IActionResult Register([FromBody] UserModel userParam)
        {
            var user = authService.Create(userParam, userParam.Password);
            if (user == null)
            {
                return BadRequest(new { message = "Username is already in use" });
            }
            return Ok(user);
        }
    }
}