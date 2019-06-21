using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace TodoApp.Models.Todo
{
    public class TodoReq
    {
        [Required]
        [StringLength(100, MinimumLength = 3)]
        public string Title { get; set; }
        public bool IsComplete { get; set; }
    }
}
