package com.mazzillio.DslistMazzillio.services;

import com.mazzillio.DslistMazzillio.dto.GameListDTO;
import com.mazzillio.DslistMazzillio.entities.GameList;
import com.mazzillio.DslistMazzillio.repositotiries.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameRepository;
    @Transactional(readOnly = true)
    public List<GameListDTO> listAllLists() {
        List<GameList> games = gameRepository.findAll();
        return games.stream().map(GameListDTO::new).toList();
    }

}
