using AutoMapper;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

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
