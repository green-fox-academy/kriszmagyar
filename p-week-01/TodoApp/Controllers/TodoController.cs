using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using TodoApp.Models;
using TodoApp.Services;

namespace TodoApp.Controllers
{
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
        public ActionResult<IEnumerable<TodoModel>> Get()
        {
            return todoService.FindAll();
        }

        [HttpGet("{id}")]
        public ActionResult<TodoModel> Get(long id)
        {
            var todo = todoService.FindById(id);
            if (todo == null)
            {
                return NotFound();
            }
            return todo;
        }

        [HttpPost]
        public ActionResult<TodoModel> Post([FromBody] TodoModel todo)
        {
            todoService.Add(todo);
            return CreatedAtAction(nameof(Get), new { id = todo.Id }, todo);
        }

        [HttpPut("{id}")]
        public IActionResult Put(long id, [FromBody] TodoModel todo)
        {
            if (id != todo.Id)
            {
                return BadRequest();
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
                return NotFound();
            }

            todoService.Delete(todo);
            return NoContent();
        }
    }
}
