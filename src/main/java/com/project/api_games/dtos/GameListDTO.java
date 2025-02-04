package com.project.api_games.dtos;

import com.project.api_games.entities.GameList;

public class GameListDTO {
  private String id;
  private String name;

  public GameListDTO(GameList entity) {
    id = entity.getId();
    name = entity.getName();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
