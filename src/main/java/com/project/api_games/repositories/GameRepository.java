package com.project.api_games.repositories;

import com.project.api_games.entities.Game;
import com.project.api_games.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface GameRepository extends JpaRepository<Game, UUID> {
  @Query(nativeQuery = true, value = """
		SELECT game.id, game.title, game.game_year AS `year`, game.img_url AS imgUrl,
		game.short_description AS shortDescription, belonging.position
		FROM game
		INNER JOIN belonging ON game.id = belonging.game_id
		WHERE belonging.game_list_id = :listId
		ORDER BY belonging.position
			""")
	List<GameMinProjection> searchByList(UUID listId);
}
