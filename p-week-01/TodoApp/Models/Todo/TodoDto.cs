namespace TodoApp.Models.Todo
{
    public class TodoDto
    {
        public long Id { get; set; }
        public string Title { get; set; }
        public bool IsComplete { get; set; }
        public long UserId { get; set; }
    }
}
