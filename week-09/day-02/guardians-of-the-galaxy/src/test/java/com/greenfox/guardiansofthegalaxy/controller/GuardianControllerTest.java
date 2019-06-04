package com.greenfox.guardiansofthegalaxy.controller;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.greenfox.guardiansofthegalaxy.utils.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(GuardianController.class)
public class GuardianControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void groot_withParams() throws Exception {
    mockMvc.perform(get("/groot?message=hello")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(TestUtils.APP_JSON))
        .andExpect(jsonPath("$.received", is("hello")))
        .andExpect(jsonPath("$.translated", is("I am Groot!")));
  }

  @Test
  public void groot_missingParam() throws Exception {
    mockMvc.perform(get("/groot")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(TestUtils.APP_JSON))
        .andExpect(jsonPath("$.error", is("I am Groot!")));
  }

  @Test
  public void yondu_withParams() throws Exception {
    mockMvc.perform(get("/yondu?distance=100.0&time=10.0")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(TestUtils.APP_JSON))
        .andExpect(jsonPath("$.distance", is(100.0)))
        .andExpect(jsonPath("$.time", is(10.0)))
        .andExpect(jsonPath("$.speed", is(10.0)));
  }

  @Test
  public void yondu_withoutParams() throws Exception {
    mockMvc.perform(get("/yondu")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(TestUtils.APP_JSON))
        .andExpect(jsonPath("$.error", is("Invalid parameters!")));
  }

  @Test
  public void getCargo_returnsEmptyCargo() throws Exception {
    mockMvc.perform(get("/rocket")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(TestUtils.APP_JSON))
        .andExpect(jsonPath("$.caliber25", is(0)))
        .andExpect(jsonPath("$.caliber30", is(0)))
        .andExpect(jsonPath("$.caliber50", is(0)))
        .andExpect(jsonPath("$.shipStatus", is("empty")))
        .andExpect(jsonPath("$.ready", is(false)));
  }

  @Test
  public void fillCargo_missingParams() throws Exception {
    mockMvc.perform(get("/rocket/fill")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(TestUtils.APP_JSON))
        .andExpect(jsonPath("$.error", is("Invalid parameters!")));
  }

  @Test
  public void fillCargo_validParams() throws Exception {
    mockMvc.perform(get("/rocket/fill?caliber=.50&amount=5000")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(TestUtils.APP_JSON))
        .andExpect(jsonPath("$.received", is(".50")))
        .andExpect(jsonPath("$.amount", is(5000)))
        .andExpect(jsonPath("$.shipStatus", is("40%")))
        .andExpect(jsonPath("$.ready", is(false)));
  }

  @Test
  public void fillCargo_fillTo100() throws Exception {
    mockMvc.perform(get("/rocket/fill?caliber=.50&amount=5000")
        .contentType(MediaType.APPLICATION_JSON));
    mockMvc.perform(get("/rocket/fill?caliber=.30&amount=5000")
        .contentType(MediaType.APPLICATION_JSON));
    mockMvc.perform(get("/rocket/fill?caliber=.25&amount=2500")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(TestUtils.APP_JSON))
        .andExpect(jsonPath("$.received", is(".25")))
        .andExpect(jsonPath("$.amount", is(2500)))
        .andExpect(jsonPath("$.shipStatus", is("full")))
        .andExpect(jsonPath("$.ready", is(true)));
  }

}