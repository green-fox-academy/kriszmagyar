using AutoMapper;

namespace TodoApp.Models.User
{
    public class UserProfile : Profile
    {
        public UserProfile()
        {
            CreateMap<UserModel, UserDto>();
        }
    }
}
