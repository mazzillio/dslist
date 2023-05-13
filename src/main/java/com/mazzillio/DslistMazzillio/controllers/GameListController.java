package com.mazzillio.DslistMazzillio.controllers;

import com.mazzillio.DslistMazzillio.dto.GameListDTO;
import com.mazzillio.DslistMazzillio.dto.GameMinDTO;
import com.mazzillio.DslistMazzillio.services.GameListService;
import com.mazzillio.DslistMazzillio.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> ListGames() {
        return gameListService.listAllLists();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> ListByList(@PathVariable Long listId) {
        return gameService.listByList(listId);
    }


}
