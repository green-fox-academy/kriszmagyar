using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Linq;
using TodoApp.Models.Todo;
using TodoApp.Repositories;

namespace TodoApp.Services
{
    public class TodoService : ITodoService
    {
        private readonly ApplicationContext context;

        public TodoService(ApplicationContext context)
        {
            this.context = context;
        }

        public List<TodoModel> FindAll()
        {
            return context.Todos.ToList();
        }

        public TodoModel FindById(long id)
        {
            var todo = context.Todos.Find(id);
            if (todo == null)
            {
                throw new KeyNotFoundException($"Todo with id {todo.Id} is not found!");
            }
            return todo;
        }

        public List<TodoModel> FindAllByUserId(long userId)
        {
            return context.Todos.Where(t => t.UserId == userId).ToList();
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
