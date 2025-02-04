package com.project.api_games.controllers;

import com.project.api_games.dtos.GameListDTO;
import com.project.api_games.dtos.GameMinDTO;
import com.project.api_games.dtos.ReplacementDTO;
import com.project.api_games.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/lists")
public class GameListController {
  @Autowired
  private GameListService gameListService;

  @GetMapping()
  public ResponseEntity<List<GameListDTO>> findAll() {
    List<GameListDTO> response = this.gameListService.findAll();

    return ResponseEntity.ok().body(response);
  }

  @GetMapping("/{id}/games")
  public ResponseEntity<List<GameMinDTO>> findOneList(@PathVariable UUID id) {
    List<GameMinDTO> response = this.gameListService.findOneList(id);

    return ResponseEntity.ok().body(response);
  }

  @PostMapping("/{listId}/replacement")
  public  ResponseEntity<Void> updatePosition(@PathVariable UUID listId, @RequestBody ReplacementDTO body) {
    this.gameListService.UpdatePosition(listId, body.getSourceIndex(), body.getDestinationIndex());
    return ResponseEntity.ok().build();
  }

}
