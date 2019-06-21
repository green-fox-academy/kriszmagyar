using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace TodoApp.Models.User
{
    public class UserDto
    {
        public long Id { get; set; }
        public string Username { get; set; }
        public string Role { get; set; }
        public string Token { get; set; }
    }
}
