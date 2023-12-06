package com.songchuwe.bingo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.songchuwe.bingo.model.Player;
import com.songchuwe.bingo.model.PlayerRegisterRequest;
import com.songchuwe.bingo.model.SetReadyRequest;

@Service
public class PlayerService {

    private List<Player> players = new ArrayList<>();

    public void registerPlayer(PlayerRegisterRequest request) {
        players.add(Player.of(request));
    }

    public Player findPlayer(SetReadyRequest request) {
        return players.stream().filter(item -> item.getEmpNo().equals(request.getEmpNo())
                && item.getName().equals(request.getName()) && item.isReady() == false).findFirst().orElse(new Player());
    }

    public boolean isAllPlayersReady() {
        return players.stream().filter(item -> item.isReady() == false).collect(Collectors.toList()).size() == 0;
    }
}
