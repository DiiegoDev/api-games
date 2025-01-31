package com.project.api_games.exceptions;

public class GameListNotFound extends RuntimeException {
  public GameListNotFound() {
    super("Não foi possível encontrar esta lista de jogos em nossa base de dados");
  }

  public GameListNotFound(String message) {
    super(message);
  }
}
