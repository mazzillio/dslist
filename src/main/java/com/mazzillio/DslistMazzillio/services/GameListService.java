package com.mazzillio.DslistMazzillio.services;

import com.mazzillio.DslistMazzillio.dto.GameListDTO;
import com.mazzillio.DslistMazzillio.entities.GameList;
import com.mazzillio.DslistMazzillio.projections.GameMinProjection;
import com.mazzillio.DslistMazzillio.repositotiries.GameListRepository;
import com.mazzillio.DslistMazzillio.repositotiries.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> listAllLists() {
        List<GameList> games = gameListRepository.findAll();
        return games.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection objRemoved = list.remove(sourceIndex);
        list.add(destinationIndex, objRemoved);
        int minIndex = Math.min(sourceIndex, destinationIndex);
        int maxIndex = Math.max(sourceIndex, destinationIndex);
        System.out.println("Minimo" + minIndex);
        System.out.println("Maximo" + maxIndex);
        for (int i = minIndex; i <= maxIndex; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }


}
