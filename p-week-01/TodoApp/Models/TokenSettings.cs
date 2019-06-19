using Newtonsoft.Json;

namespace TodoApp.Models
{
    public class TokenSettings
    {
        [JsonProperty("secret")]
        public string Secret { get; set; }

        [JsonProperty("accessExpiration")]
        public int AccessExpiration { get; set; }

        [JsonProperty("refreshExpiration")]
        public int RefreshExpiration { get; set; }
    }
}
