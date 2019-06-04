package com.greenfox.guardiansofthegalaxy.service;

import com.greenfox.guardiansofthegalaxy.model.Cargo;
import org.springframework.stereotype.Service;

@Service
public class GuardianService {

  private Cargo cargo = new Cargo();

  public Cargo getCargo() {
    return cargo;
  }
}
