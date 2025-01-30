package com.project.api_games.entities;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity(name = "game_list")
@Table(name = "game_list")
public class GameList {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String name;

  public GameList() {}

  public GameList(UUID id, String name) {
    this.id = id;
    this.name = name;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GameList gameList = (GameList) o;
    return Objects.equals(id, gameList.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
