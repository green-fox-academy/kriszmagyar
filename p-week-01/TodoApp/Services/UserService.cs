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

        public UserModel Add(UserModel user)
        {
            context.Add(user);
            context.SaveChanges();
            return user;
        }

        public void Delete(UserModel id)
        {
            throw new NotImplementedException();
        }

        public List<UserModel> FindAll()
        {
            throw new NotImplementedException();
        }

        public UserModel FindById(long id)
        {
            throw new NotImplementedException();
        }

        public void Update(UserModel todo)
        {
            throw new NotImplementedException();
        }
    }
}
