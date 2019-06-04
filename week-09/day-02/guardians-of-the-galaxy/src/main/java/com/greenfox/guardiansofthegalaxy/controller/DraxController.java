package com.greenfox.guardiansofthegalaxy.controller;

import com.greenfox.guardiansofthegalaxy.model.FoodDTO;
import com.greenfox.guardiansofthegalaxy.service.DraxService;
import com.sun.javaws.exceptions.InvalidArgumentException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drax")
public class DraxController {

  @Autowired
  private DraxService draxService;

  @GetMapping("/foods")
  public List<FoodDTO> findAll() {
    return draxService.findAll();
  }

  @GetMapping("foods/{id}")
  public ResponseEntity findById(@PathVariable long id) {
    try {
      return ResponseEntity.ok().body(draxService.findById(id));
    } catch (InvalidArgumentException e) {
      e.printStackTrace();
      return ResponseEntity.notFound().build();
    }
  }
}
