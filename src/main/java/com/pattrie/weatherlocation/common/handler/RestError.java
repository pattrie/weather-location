package com.pattrie.weatherlocation.common.handler;

import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class RestError {
  private final LocalDateTime timestamp;
  private final int status;
  private final String path;
  private final String error;

  public static RestError build(final HttpStatus status, final HttpServletRequest request) {
    return new RestError(
        LocalDateTime.now(), status.value(), request.getServletPath(), status.getReasonPhrase());
  }
}
