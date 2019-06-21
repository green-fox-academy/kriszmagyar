using Microsoft.EntityFrameworkCore;
using TodoApp.Models.Todo;
using TodoApp.Models.User;

namespace TodoApp.Repositories
{
    public class ApplicationContext : DbContext
    {
        public DbSet<TodoModel> Todos { get; set; }
        public DbSet<UserModel> Users { get; set; }

        public ApplicationContext(DbContextOptions<ApplicationContext> options) : base(options)
        {
        }
    }
}
