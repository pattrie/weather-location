package com.pattrie.weatherlocation.common.handler;

import static org.springframework.http.HttpStatus.BAD_GATEWAY;

import com.pattrie.weatherlocation.common.exception.UnexpectedResultException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
  @ExceptionHandler(UnexpectedResultException.class)
  protected ResponseEntity<RestError> handleUnexpectedResultException(
      final UnexpectedResultException exception, final HttpServletRequest request) {
    return ResponseEntity.status(BAD_GATEWAY)
        .body(RestError.build(HttpStatus.valueOf(exception.getMessage()), request));
  }
}
