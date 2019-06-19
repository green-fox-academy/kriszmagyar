using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using TodoApp.Models;
using TodoApp.Services;

namespace TodoApp.Controllers
{
    [Authorize]
    [ApiController]
    [Route("api/[controller]")]
    public class TodoController : ControllerBase
    {
        private readonly ITodoService todoService;

        public TodoController(ITodoService todoService)
        {
            this.todoService = todoService;
        }

        [HttpGet]
        public ActionResult<List<TodoModel>> Get()
        {
            // long userId = long.Parse(User.Identity.Name);
            return todoService.FindAll();
        }

        [HttpGet("{id}")]
        public ActionResult<TodoModel> Get(long id)
        {
            var todo = todoService.FindById(id);
            if (todo == null)
            {
                return NotFound($"Todo item with id {id} is not found.");
            }
            return todo;
        }

        [HttpPost]
        public ActionResult<TodoModel> Post([FromBody] TodoModel todo)
        {
            if (todo.Id != 0)
            {
                return BadRequest("You cannot add todo with id, as it is generated.");
            }
            todoService.Add(todo);
            return CreatedAtAction(nameof(Get), new { id = todo.Id }, todo);
        }

        [HttpPut("{id}")]
        public IActionResult Put(long id, [FromBody] TodoModel todo)
        {
            if (id != todo.Id)
            {
                return BadRequest("The given ids do not match.");
            }
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

            todoService.Delete(todo);
            return NoContent();
        }
    }
}
