package com.project.api_games.services;

import com.project.api_games.dtos.GameMinDTO;
import com.project.api_games.entities.Game;
import com.project.api_games.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {
  @Autowired
  private GameRepository gameRepository;


  public List<GameMinDTO> findAll() {
    List<Game> response = this.gameRepository.findAll();

    return response.stream().map(GameMinDTO::new).toList();
  }
}
