package com.project.api_games.exceptions;

import org.springframework.http.HttpStatus;

public class RestErrorMessage {
  HttpStatus status;
  String message;

  public RestErrorMessage(HttpStatus status, String message) {
    this.status = status;
    this.message = message;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
