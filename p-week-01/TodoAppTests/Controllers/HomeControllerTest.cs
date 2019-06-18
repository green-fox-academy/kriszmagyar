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

        private List<TodoModel> GenerateTodoList()
        {
            return new List<TodoModel> {
                new TodoModel { Title = "Todo One" },
                new TodoModel { Title = "Todo Two" },
                new TodoModel { Title = "Todo Three" },
                new TodoModel { Title = "Todo Four" }
            };
        }

        [Fact]
        public void Get_WhenCalled_ReturnsEmptyList()
        {
            var mockService = new Mock<ITodoService>();
            mockService.Setup(s => s.FindAll()).Returns(new List<TodoModel>());
            var controller = new TodoController(mockService.Object);

            Assert.Empty(controller.Get().Value);
        }

        [Fact]
        public void Get_WhenCalledWithNonExistingId_ReturnsNotFound()
        {
            var mockService = new Mock<ITodoService>();
            var controller = new TodoController(mockService.Object);

            Assert.IsType<NotFoundObjectResult>(controller.Get(1).Result);
        }

        [Fact]
        public void Get_WhenCalledWithValidId_ReturnsTodo()
        {
            var mockService = new Mock<ITodoService>();
            mockService.Setup(s => s.FindById(1))
                .Returns(new TodoModel() { Id = 1, Title = "Todo One" });
            var controller = new TodoController(mockService.Object);

            var todo = controller.Get(1).Value;

            Assert.Equal(1, todo.Id);
            Assert.Equal("Todo One", todo.Title);
        }

        [Fact]
        public void Post_WhenCalledWithValidTodo_ReturnsCreatedAtAction()
        {
            var todo = new TodoModel() { Title = "Todo One" };
            var mockService = new Mock<ITodoService>();
            mockService.Setup(s => s.Add(todo))
                .Returns(new TodoModel() { Id = 1, Title = "Todod One" });
            var controller = new TodoController(mockService.Object);

            var result = controller.Post(todo);

            Assert.IsType<CreatedAtActionResult>(result.Result);
        }

        [Fact]
        public void Post_WhenCalledWithInvalidTodo_ReturnsBadRequest()
        {
            var mockService = new Mock<ITodoService>();
            var controller = new TodoController(mockService.Object);

            var result = controller.Post(new TodoModel() { Id = 1 });

            Assert.IsType<BadRequestObjectResult>(result.Result);
        }
    }
}
