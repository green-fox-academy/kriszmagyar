package com.greenfox.restexercie.repository;

import com.greenfox.restexercie.model.Log;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<Log, Long> {
}
