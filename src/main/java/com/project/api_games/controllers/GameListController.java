package com.project.api_games.controllers;

import com.project.api_games.dtos.GameListDTO;
import com.project.api_games.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/games-list")
public class GameListController {
  @Autowired
  private GameListService gameListService;

  @GetMapping()
  public ResponseEntity<List<GameListDTO>> findAll() {
    List<GameListDTO> response = this.gameListService.findAll();

    return ResponseEntity.ok().body(response);
  }
}
