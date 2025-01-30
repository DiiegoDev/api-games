package com.project.api_games.repositories;

import com.project.api_games.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameListRepository extends JpaRepository<GameList, UUID> {
}
