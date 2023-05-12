package com.mazzillio.DslistMazzillio.services;

import com.mazzillio.DslistMazzillio.dto.GameMinDTO;
import com.mazzillio.DslistMazzillio.entities.Game;
import com.mazzillio.DslistMazzillio.repositotiries.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    public List<GameMinDTO> listAllGames() {
        List<Game> games = gameRepository.findAll();
        return games.stream().map(GameMinDTO::new).toList();
    }
}
