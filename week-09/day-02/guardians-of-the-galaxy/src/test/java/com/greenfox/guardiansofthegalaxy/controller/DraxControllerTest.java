package com.greenfox.guardiansofthegalaxy.controller;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.greenfox.guardiansofthegalaxy.model.FoodDTO;
import com.greenfox.guardiansofthegalaxy.service.DraxService;
import com.greenfox.guardiansofthegalaxy.utils.TestUtils;
import com.sun.javaws.exceptions.InvalidArgumentException;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(DraxController.class)
public class DraxControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private DraxService draxServiceMock;

  @Test
  public void findAll_shouldReturnFoods() throws Exception {
    FoodDTO food1 = new FoodDTO("Hamburger", 10, 2000);
    FoodDTO food2 = new FoodDTO("Pizza", 5, 800);

    when(draxServiceMock.findAll()).thenReturn(Arrays.asList(food1, food2));

    mockMvc.perform(get("/drax/foods")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(TestUtils.APP_JSON))
        .andExpect(jsonPath("$[1].id", is(2)))
        .andExpect(jsonPath("$[1].name", is("Pizza")))
        .andExpect(jsonPath("$[1].amount", is(5)))
        .andExpect(jsonPath("$[1].calorie", is(800)));

    verify(draxServiceMock, times(1)).findAll();
    verifyNoMoreInteractions(draxServiceMock);
  }

  @Test
  public void findById_withValidId() throws Exception {
    FoodDTO food = new FoodDTO("Pizza", 5, 800);
    food.setId(2);

    when(draxServiceMock.findById(2)).thenReturn(food);

    mockMvc.perform(get("/drax/foods/2")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(TestUtils.APP_JSON))
        .andExpect(jsonPath("$.id", is(2)))
        .andExpect(jsonPath("$.name", is("Pizza")))
        .andExpect(jsonPath("$.amount", is(5)))
        .andExpect(jsonPath("$.calorie", is(800)));

    verify(draxServiceMock, times(1)).findById(2);
    verifyNoMoreInteractions(draxServiceMock);
  }

  @Test
  public void findById_withInvalidId() throws Exception {
    when(draxServiceMock.findById(3)).thenThrow(new InvalidArgumentException(new String[]{}));

    mockMvc.perform(get("/drax/foods/3")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());

    verify(draxServiceMock, times(1)).findById(3);
    verifyNoMoreInteractions(draxServiceMock);
  }
}