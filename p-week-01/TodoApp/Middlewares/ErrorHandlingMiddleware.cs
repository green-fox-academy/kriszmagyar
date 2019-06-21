using Microsoft.AspNetCore.Http;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Threading.Tasks;
using TodoApp.Models;

namespace TodoApp.Middlewares
{
    public class ErrorHandlingMiddleware
    {
        private readonly RequestDelegate next;

        public ErrorHandlingMiddleware(RequestDelegate next)
        {
            this.next = next;
        }

        public async Task Invoke(HttpContext context)
        {
            try
            {
                await next(context);
            }
            catch (Exception ex)
            {
                await HandleExceptionAsync(context, ex);
            }
        }

        private static Task HandleExceptionAsync(HttpContext context, Exception ex)
        {
            context.Response.ContentType = "application/json";
            context.Response.StatusCode = (int)GetStatusCode(ex);
            return context.Response.WriteAsync(new MessageResponse(ex).ToString());
        }

        private static HttpStatusCode GetStatusCode(Exception ex)
        {
            if (ex is ArgumentException)
            {
                return HttpStatusCode.BadRequest;
            }
            if (ex is KeyNotFoundException)
            {
                return HttpStatusCode.NotFound;
            }
            return HttpStatusCode.InternalServerError;
        }
    }
}
