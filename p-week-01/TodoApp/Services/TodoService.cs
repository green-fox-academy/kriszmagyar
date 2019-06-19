using Microsoft.EntityFrameworkCore;
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

        public List<TodoModel> FindAll()
        {
            return context.Todos.ToList();
        }

        public TodoModel FindById(long id)
        {
            return context.Todos.Find(id);
        }

        public TodoModel Add(TodoModel todo)
        {
            context.Add(todo);
            context.SaveChanges();
            return todo;
        }

        public void Update(TodoModel todo)
        {
            context.Entry(todo).State = EntityState.Modified;
            context.SaveChanges();
        }

        public void Delete(TodoModel todo)
        {
            context.Remove(todo);
            context.SaveChanges();
        }
    }
}
