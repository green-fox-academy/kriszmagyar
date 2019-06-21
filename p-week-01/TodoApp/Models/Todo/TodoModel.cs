using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace TodoApp.Models.Todo
{
    public class TodoModel
    {
        public long Id { get; set; }
        public string Title { get; set; }
        public bool IsComplete { get; set; }
        public long UserId { get; set; }
    }
}
