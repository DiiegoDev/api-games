package com.project.api_games.controllers;

import com.project.api_games.dtos.GameDTO;
import com.project.api_games.dtos.GameMinDTO;
import com.project.api_games.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/games")
public class GameController {
  @Autowired
  private GameService gameService;

  @GetMapping()
  public ResponseEntity<List<GameMinDTO>> findAll() {
    List<GameMinDTO> response = this.gameService.findAll();

    return ResponseEntity.ok().body(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<GameDTO> findById(@PathVariable UUID id) {
    GameDTO response = this.gameService.findById(id);

    return ResponseEntity.ok(response);
  }
}
