using AutoMapper;

namespace TodoApp.Models.Todo
{
    public class TodoProfile : Profile
    {
        public TodoProfile()
        {
            CreateMap<TodoModel, TodoDto>();
            CreateMap<TodoReq, TodoModel>();
        }
    }
}
