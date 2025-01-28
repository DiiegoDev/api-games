package com.project.api_games.controllers;

import com.project.api_games.dtos.GameMinDTO;
import com.project.api_games.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
