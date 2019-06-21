using Newtonsoft.Json;
using System;

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
