package com.project.api_games.services;

import com.project.api_games.dtos.GameDTO;
import com.project.api_games.dtos.GameMinDTO;
import com.project.api_games.entities.Game;
import com.project.api_games.exceptions.GameNotFound;
import com.project.api_games.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameService {
  @Autowired
  private GameRepository gameRepository;

  @Transactional(readOnly = true)
  public List<GameMinDTO> findAll() {
    List<Game> response = this.gameRepository.findAll();

    return response.stream().map(GameMinDTO::new).toList();
  }

  @Transactional(readOnly = true)
  public GameDTO findById(UUID id) {
    Optional<Game> response = this.gameRepository.findById(id);

    if(response.isEmpty()) throw new GameNotFound();

    return new GameDTO(response.get());
  }
}
