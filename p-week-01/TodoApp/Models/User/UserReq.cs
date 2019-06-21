using System.ComponentModel.DataAnnotations;

namespace TodoApp.Models.User
{
    public class UserReq
    {
        [Required]
        public string Username { get; set; }
        [Required]
        [StringLength(30, MinimumLength = 5)]
        public string Password { get; set; }
    }
}
