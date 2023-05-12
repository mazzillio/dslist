package com.mazzillio.DslistMazzillio.controllers;

import com.mazzillio.DslistMazzillio.dto.GameMinDTO;
import com.mazzillio.DslistMazzillio.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "games")
public class GameController {
    @Autowired
    private GameService gameService;
    @GetMapping
    public List<GameMinDTO> ListGames(){
        return gameService.listAllGames();
    }
}
