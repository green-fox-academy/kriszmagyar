package com.greenfox.guardiansofthegalaxy.controller;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.greenfox.guardiansofthegalaxy.model.Cargo;
import com.greenfox.guardiansofthegalaxy.model.FoodDTO;
import com.greenfox.guardiansofthegalaxy.service.DraxService;
import com.greenfox.guardiansofthegalaxy.service.GuardianService;
import com.greenfox.guardiansofthegalaxy.utils.TestUtils;
import java.util.Arrays;
import org.junit.BeforeClass;
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
  private DraxService draxService;

  @Test
  public void getFoods_shouldReturnFoods() throws Exception {
    FoodDTO food1 = new FoodDTO("Hamburger", 10, 2000);
    FoodDTO food2 = new FoodDTO("Pizza", 5, 800);

    when(draxService.getFoods()).thenReturn(Arrays.asList(food1, food2));

    mockMvc.perform(get("/drax/foods")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(TestUtils.APP_JSON))
        .andExpect(jsonPath("$[1].id", is(2)))
        .andExpect(jsonPath("$[1].name", is("Pizza")))
        .andExpect(jsonPath("$[1].amount", is(5)))
        .andExpect(jsonPath("$[1].calorie", is(800)));
  }
}