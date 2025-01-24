package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        return gameRepository.findAll().stream().map( g -> new GameMinDTO(g) ).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findbyId( Long id ){
        Game result = gameRepository.findById(id).get();
        return  new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> searchByList(Long listId){
        return gameRepository.searchByList(listId).stream().map( g -> new GameMinDTO(g) ).toList();
    }

}
