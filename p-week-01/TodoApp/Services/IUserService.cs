using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using TodoApp.Models;

namespace TodoApp.Services
{
    public interface IUserService
    {
        List<UserModel> FindAll();
        UserModel FindById(long id);
        UserModel FindByUsername(string username);
        UserModel Add(UserModel user);
        void Update(UserModel user);
        void Delete(UserModel user);
    }
}
