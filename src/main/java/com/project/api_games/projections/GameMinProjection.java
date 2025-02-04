package com.project.api_games.projections;

public interface GameMinProjection {
  String getId();
  String getTitle();
  Integer getYear();
  String getImgUrl();
  String getShortDescription();
  Integer getPosition();
}
