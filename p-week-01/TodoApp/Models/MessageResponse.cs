using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace TodoApp.Models
{
    public class MessageResponse
    {
        [JsonProperty("message")]
        public string Message { get; set; }

        public MessageResponse(Exception ex)
        {
            Message = ex.Message;
        }

        public override string ToString()
        {
            return JsonConvert.SerializeObject(this);
        }
    }
}
