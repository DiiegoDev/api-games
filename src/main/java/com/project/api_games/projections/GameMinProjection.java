package com.project.api_games.projections;

import java.util.UUID;

public interface GameMinProjection {
  UUID getGameId();
  String getTitle();
  Integer getYear();
  String getImgUrl();
  String getShortDescription();
  Integer getPosition();
}
