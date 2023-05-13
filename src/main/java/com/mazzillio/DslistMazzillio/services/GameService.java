package com.mazzillio.DslistMazzillio.services;

import com.mazzillio.DslistMazzillio.dto.GameDTO;
import com.mazzillio.DslistMazzillio.dto.GameMinDTO;
import com.mazzillio.DslistMazzillio.entities.Game;
import com.mazzillio.DslistMazzillio.projections.GameMinProjection;
import com.mazzillio.DslistMazzillio.repositotiries.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    @Transactional(readOnly = true)
    public List<GameMinDTO> listAllGames() {
        List<Game> games = gameRepository.findAll();
        return games.stream().map(GameMinDTO::new).toList();
    }
    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game game = gameRepository.findById(id).get();
        return new GameDTO(game);
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> listByList(Long listId) {
        List<GameMinProjection> games = gameRepository.searchByList(listId);
        return games.stream().map(GameMinDTO::new).toList();
    }

}
