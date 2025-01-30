package com.project.api_games.exceptions;

public class GameNotFound extends RuntimeException {
  public GameNotFound() {
    super("Não foi possível encontrar este jogo em nossa base de dados");
  }

  public GameNotFound(String message) {
    super(message);
  }
}
