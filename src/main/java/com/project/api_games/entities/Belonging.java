package com.project.api_games.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name = "belonging")
@Table(name = "belonging")
public class Belonging {
  @EmbeddedId
  private BelongingPK id = new BelongingPK();
  private Integer position;

  public Belonging() {}

  public Belonging(Game game, GameList gameList, Integer position) {
    this.id.setGame(game);
    this.id.setGameList(gameList);
    this.position = position;
  }

  public BelongingPK getId() {
    return id;
  }

  public void setId(BelongingPK id) {
    this.id = id;
  }

  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }


}
