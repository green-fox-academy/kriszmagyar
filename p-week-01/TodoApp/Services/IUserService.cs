using System.Collections.Generic;
using TodoApp.Models.User;

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
        bool Exists(long id);
        bool Exists(string username);
    }
}
