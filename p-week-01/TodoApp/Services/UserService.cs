using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TodoApp.Models;
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
            throw new NotImplementedException();
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

        public void Update(UserModel todo)
        {
            throw new NotImplementedException();
        }

        public void Delete(UserModel id)
        {
            throw new NotImplementedException();
        }
    }
}
