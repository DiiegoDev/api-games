package com.project.api_games.services;

import com.project.api_games.dtos.GameListDTO;
import com.project.api_games.dtos.GameMinDTO;
import com.project.api_games.entities.GameList;
import com.project.api_games.exceptions.GameListNotFound;
import com.project.api_games.projections.GameMinProjection;
import com.project.api_games.repositories.GameListRepository;
import com.project.api_games.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameListService {
  @Autowired
  private GameListRepository gameListRepository;

  @Autowired
  private GameRepository gameRepository;

  @Transactional(readOnly = true)
  public List<GameListDTO> findAll() {
    List<GameList> response = this.gameListRepository.findAll();

    return response.stream().map(GameListDTO::new).toList();
  }

  @Transactional(readOnly = true)
  public List<GameMinDTO> findOneList(UUID id) {
    Optional<GameList> gameListExisted = this.findListById(id);

    if(gameListExisted.isEmpty()) throw new GameListNotFound();

    List<GameMinProjection> response = this.gameRepository.searchByList(id.toString());

    return response.stream().map(GameMinDTO::new).toList();
  }

  @Transactional(readOnly = true)
  public Optional<GameList> findListById(UUID id) {
    Optional<GameList> response = this.gameListRepository.findById(id.toString());

    return response;
  }

  @Transactional(readOnly = true)
  public void UpdatePosition(UUID listId, int sourceIndex, int destinationIndex) {
    List<GameMinProjection> list = this.gameRepository.searchByList(listId.toString());

    GameMinProjection obj = list.remove(sourceIndex);
    list.add(destinationIndex, obj);

    int min = Math.min(sourceIndex, destinationIndex);
    int max = Math.max(sourceIndex, destinationIndex);

    for(int i = min; i <= max; i++) {
      this.gameListRepository.updateBelongingPosition(listId.toString(), list.get(i).getId(), i);
    }
  }
}
