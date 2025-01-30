package com.project.api_games.services;

import com.project.api_games.dtos.GameListDTO;
import com.project.api_games.entities.GameList;
import com.project.api_games.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
  @Autowired
  private GameListRepository gameListRepository;

  @Transactional(readOnly = true)
  public List<GameListDTO> findAll() {
    List<GameList> response = this.gameListRepository.findAll();

    return response.stream().map(GameListDTO::new).toList();
  }
}
