using AutoMapper;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
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
        private readonly IMapper mapper;

        public TodoController(ITodoService todoService, IUserService userService, IMapper mapper)
        {
            this.todoService = todoService;
            this.userService = userService;
            this.mapper = mapper;
        }

        [HttpGet]
        public ActionResult<List<TodoDto>> Get()
        {
            var user = GetCurrentUser();
            var todos = user.Role == Role.Admin
                ? todoService.FindAll()
                : todoService.FindAllByUserId(user.Id);

            return mapper.Map<List<TodoDto>>(todos);
        }

        [HttpGet("{id}")]
        public IActionResult Get(long id)
        {
            var todo = GetTodoWithAuthorization(id);
            var todoDto = mapper.Map<TodoDto>(todo);
            return Ok(todoDto);
        }

        [HttpPost]
        public IActionResult Post([FromBody] TodoReq todoReq)
        {
            var todo = mapper.Map<TodoModel>(todoReq);
            todo.User = GetCurrentUser();
            todoService.Add(todo);
            var todoDto = mapper.Map<TodoDto>(todo);
            return CreatedAtAction(nameof(Get), new { id = todo.Id }, todoDto);
        }

        [HttpPut("{id}")]
        public IActionResult Put(long id, [FromBody] TodoReq todoReq)
        {
            var todo = GetTodoWithAuthorization(id);
            todo = mapper.Map(todoReq, todo);
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
            if (user.Id != todo.User.Id && user.Role != Role.Admin)
            {
                throw new AccessDeniedException("You can not access this item!");
            }
        }
    }
}
