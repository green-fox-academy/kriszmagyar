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
            TodoModel todo = todoService.FindById(id);
            if (todo == null)
            {
                return NotFound();
            }
            return todo;
        }

        [HttpPost]
        public void Post([FromBody] TodoModel todo)
        {
            todoService.Add(todo);
        }

        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
