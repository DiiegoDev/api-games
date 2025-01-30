package com.project.api_games.dtos;

import com.project.api_games.entities.GameList;

import java.util.UUID;

public class GameListDTO {
  private UUID id;
  private String name;

  public GameListDTO(GameList entity) {
    id = entity.getId();
    name = entity.getName();
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
