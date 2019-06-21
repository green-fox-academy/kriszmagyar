using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TodoApp.Models.Todo;
using TodoApp.Models.User;

namespace TodoApp.Repositories
{
    public class ApplicationContext : DbContext
    {
        public ApplicationContext(DbContextOptions<ApplicationContext> options) : base(options)
        {
        }

        public DbSet<TodoModel> Todos { get; set; }
        public DbSet<UserModel> Users { get; set; }
    } 
}
