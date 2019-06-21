using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TodoApp.Models.User;
using TodoApp.Repositories;

namespace TodoApp.Services
{
    public class UserService : IUserService
    {
        private readonly ApplicationContext context;

        public UserService(ApplicationContext context)
        {
            this.context = context;
        }

        public List<UserModel> FindAll()
        {
            return context.Users.ToList();
        }

        public UserModel FindById(long id)
        {
            return context.Users.Find(id);
        }

        public UserModel FindByUsername(string username)
        {
            return context.Users.SingleOrDefault(u => u.Username.Equals(username));
        }

        public UserModel Add(UserModel user)
        {
            context.Add(user);
            context.SaveChanges();
            return user;
        }

        public void Update(UserModel user)
        {
            context.Entry(user).State = EntityState.Modified;
            context.SaveChanges();
        }

        public void Delete(UserModel user)
        {
            context.Remove(user);
            context.SaveChanges();
        }

        public bool Exists(string username)
        {
            return context.Users.Any(u => u.Username == username);
        }
    }
}
