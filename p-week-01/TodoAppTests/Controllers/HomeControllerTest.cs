using System;
using System.Collections.Generic;
using System.Text;
using Microsoft.AspNetCore.Mvc;
using Moq;
using TodoApp.Controllers;
using TodoApp.Models;
using TodoApp.Services;
using Xunit;

namespace TodoAppTests.Controllers
{
    public class TodoControllerTest
    {
        [Fact]
        public void Get_WhenCalled_ReturnsListOfTodos()
        {
            var mockService = new Mock<ITodoService>();
            mockService.Setup(s => s.FindAll()).Returns(GenerateTodoList());
            var controller = new TodoController(mockService.Object);

            var result = controller.Get();

            var actionResult = Assert.IsType<ActionResult<List<TodoModel>>>(result);
            Assert.Equal(4, actionResult.Value.Count);
            Assert.Equal("Todo Three", actionResult.Value[2].Title);
        }

        [Fact]
        public void Get_WhenCalled_ReturnsEmptyList()
        {
            var mockService = new Mock<ITodoService>();
            mockService.Setup(s => s.FindAll()).Returns(new List<TodoModel>());
            var controller = new TodoController(mockService.Object);

            Assert.Empty(controller.Get().Value);
        }

        private List<TodoModel> GenerateTodoList()
        {
            return new List<TodoModel> {
                new TodoModel { Title = "Todo One" },
                new TodoModel { Title = "Todo Two" },
                new TodoModel { Title = "Todo Three" },
                new TodoModel { Title = "Todo Four" }
            };
        }
    }
}
