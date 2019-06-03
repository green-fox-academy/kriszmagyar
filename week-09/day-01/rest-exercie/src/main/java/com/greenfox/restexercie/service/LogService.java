package com.greenfox.restexercie.service;

import com.greenfox.restexercie.model.Log;
import com.greenfox.restexercie.model.LogEntries;
import com.greenfox.restexercie.repository.LogRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {

  @Autowired
  private LogRepository logRepository;

  public void save(Log log) {
    logRepository.save(log);
  }

  public LogEntries findAllLogs() {
    List<Log> logs = new ArrayList<>();
    logRepository.findAll().forEach(logs::add);
    return new LogEntries(logs);
  }

}
