using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using TodoApp.Models;
using TodoApp.Models.User;
using TodoApp.Services;

namespace TodoApp.Controllers
{
    [Authorize]
    [Route("api/[controller]")]
    [ApiController]
    public class TodoController : ControllerBase
    {
        private readonly ITodoService todoService;
        private readonly IUserService userService;

        public TodoController(ITodoService todoService, IUserService userService)
        {
            this.todoService = todoService;
            this.userService = userService;
        }
        
        [HttpGet]
        public ActionResult<List<TodoModel>> Get()
        {
            var user = GetCurrentUser();
            if (user.Role == Role.Admin)
            {
                return todoService.FindAll();
            } else
            {
                return todoService.FindAllByUserId(user.Id);
            }
        }

        [HttpGet("{id}")]
        public IActionResult Get(long id)
        {
            var user = GetCurrentUser();
            var todo = todoService.FindById(id);
            if (todo == null)
            {
                return NotFound($"Todo item with id {id} is not found.");
            }
            if (todo.UserId != user.Id && user.Role != Role.Admin)
            {
                return Forbid();
            }
            return Ok(todo);
        }

        [HttpPost]
        public ActionResult<TodoModel> Post([FromBody] TodoModel todo)
        {
            if (todo.Id != 0)
            {
                return BadRequest("You cannot add todo with id, as it is generated.");
            }
            var user = GetCurrentUser();
            todo.UserId = user.Id;
            todoService.Add(todo);
            return CreatedAtAction(nameof(Get), new { id = todo.Id }, todo);
        }

        [HttpPut("{id}")]
        public IActionResult Put(long id, [FromBody] TodoModel todoRequest)
        {
            var todo = todoService.FindById(id);
            if (todo == null)
            {
                return NotFound($"Todo with id {id} is not found!");
            }
            var user = GetCurrentUser();
            if (user.Id != todo.UserId && user.Role != Role.Admin)
            {
                return Forbid();
            }
            todo.Title = todoRequest.Title;
            todo.IsComplete = todoRequest.IsComplete;
            todoService.Update(todo);
            return NoContent();
        }

        [HttpDelete("{id}")]
        public IActionResult Delete(long id)
        {
            var todo = todoService.FindById(id);
            if (todo == null)
            {
                return NotFound($"Todo item with a given id {id} is not found.");
            }
            var user = GetCurrentUser();
            if (user.Id != todo.UserId && user.Role != Role.Admin)
            {
                return Forbid();
            }
            todoService.Delete(todo);
            return NoContent();
        }

        private UserModel GetCurrentUser()
        {
            long userId = long.Parse(User.Identity.Name);
            return userService.FindById(userId);
        }
    }
}
