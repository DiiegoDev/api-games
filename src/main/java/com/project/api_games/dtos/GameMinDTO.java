package com.project.api_games.dtos;

import com.project.api_games.entities.Game;
import com.project.api_games.projections.GameMinProjection;

import java.util.UUID;

public class GameMinDTO {
  private UUID id;
  private String title;
  private Integer year;
  private String imgUrl;
  private String shortDescription;

  public GameMinDTO() {}

  public GameMinDTO(Game entity) {
    id = entity.getId();
    title = entity.getTitle();
    year = entity.getYear();
    imgUrl = entity.getImgUrl();
    shortDescription = entity.getShortDescription();
  }

  public GameMinDTO(GameMinProjection projection) {
    id = projection.getGameId();
    title = projection.getTitle();
    year = projection.getYear();
    imgUrl = projection.getImgUrl();
    shortDescription = projection.getShortDescription();
  }

  public UUID getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public Integer getYear() {
    return year;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public String getShortDescription() {
    return shortDescription;
  }
}
