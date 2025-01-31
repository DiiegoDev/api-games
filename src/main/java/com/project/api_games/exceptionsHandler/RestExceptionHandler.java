package com.project.api_games.exceptionsHandler;

import com.project.api_games.exceptions.GameListNotFound;
import com.project.api_games.exceptions.GameNotFound;
import com.project.api_games.exceptions.RestErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(GameNotFound.class)
  private ResponseEntity<RestErrorMessage> gameNotFoundHandler(GameNotFound exception) {
    RestErrorMessage errorResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
  }

  @ExceptionHandler(GameListNotFound.class)
  private ResponseEntity<RestErrorMessage> gameListNotFoundHandler(GameListNotFound exception) {
    RestErrorMessage errorResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
  }
}
