using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using TodoApp.Exceptions;
using TodoApp.Models.Todo;
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
            var todo = GetTodoWithAuthorization(id);
            return Ok(todo);
        }

        [HttpPost]
        public ActionResult<TodoModel> Post([FromBody] TodoReq todoReq)
        {
            var user = GetCurrentUser();
            var todo = new TodoModel() { Title = todoReq.Title, IsComplete = todoReq.IsComplete, UserId = user.Id };
            todoService.Add(todo);
            return CreatedAtAction(nameof(Get), new { id = todo.Id }, todo);
        }

        [HttpPut("{id}")]
        public IActionResult Put(long id, [FromBody] TodoReq todoReq)
        {
            var todo = GetTodoWithAuthorization(id);
            todo.Title = todoReq.Title;
            todo.IsComplete = todoReq.IsComplete;
            todoService.Update(todo);
            return NoContent();
        }

        [HttpDelete("{id}")]
        public IActionResult Delete(long id)
        {
            var todo = GetTodoWithAuthorization(id);
            todoService.Delete(todo);
            return NoContent();
        }

        private TodoModel GetTodoWithAuthorization(long todoId)
        {
            var todo = todoService.FindById(todoId);
            var user = GetCurrentUser();
            ThrowIfForbidden(todo, user);
            return todo;
        }

        private UserModel GetCurrentUser()
        {
            long userId = long.Parse(User.Identity.Name);
            return userService.FindById(userId);
        }

        private void ThrowIfForbidden(TodoModel todo, UserModel user)
        {
            if (user.Id != todo.UserId && user.Role != Role.Admin)
            {
                throw new AccessDeniedException("You can not access this item!");
            }
        }
    }
}
