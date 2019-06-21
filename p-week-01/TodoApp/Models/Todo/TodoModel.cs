using TodoApp.Models.User;

namespace TodoApp.Models.Todo
{
    public class TodoModel
    {
        public long Id { get; set; }
        public string Title { get; set; }
        public bool IsComplete { get; set; }
        public UserModel User { get; set; }
    }
}
