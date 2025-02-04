package com.project.api_games.repositories;

import com.project.api_games.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface GameListRepository extends JpaRepository<GameList, String> {
  @Modifying
  @Query(nativeQuery = true, value = """
      UPDATE belonging SET position = :newPosition 
      WHERE belonging.game_list_id = :listId AND game_id = :gameId
  """)
  void updateBelongingPosition(String listId, String gameId, int newPosition);
}
