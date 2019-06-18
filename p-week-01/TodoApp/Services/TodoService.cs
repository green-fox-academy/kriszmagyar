using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TodoApp.Models;

namespace TodoApp.Services
{
    public class TodoService : ITodoService
    {
        private readonly TodoContext context;

        public TodoService(TodoContext context)
        {
            this.context = context;
        }

        public TodoModel[] FindAll()
        {
            return context.Todos.ToArray();
        }

        public TodoModel Add(TodoModel todo)
        {
            context.Add(todo);
            context.SaveChanges();
            return todo;
        }
    }
}
