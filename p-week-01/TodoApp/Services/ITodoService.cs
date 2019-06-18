using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TodoApp.Models;

namespace TodoApp.Services
{
    public interface ITodoService
    {
        TodoModel[] FindAll();
        TodoModel FindById(long id);
        TodoModel Add(TodoModel todo);
        void Update(TodoModel todo);
    }
}
