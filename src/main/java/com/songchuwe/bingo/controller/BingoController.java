package com.songchuwe.bingo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.songchuwe.bingo.model.BingoItem;
import com.songchuwe.bingo.model.Player;
import com.songchuwe.bingo.model.PlayerRegisterRequest;
import com.songchuwe.bingo.model.SetReadyRequest;
import com.songchuwe.bingo.service.PlayerService;

@Controller
public class BingoController {

    private PlayerService playerService;

    public BingoController(PlayerService playerService) {
        this.playerService = playerService;
    }
    @MessageMapping("/register-player")
    public void registerPlayer(PlayerRegisterRequest request) throws Exception {
        System.out.println("Message Received : Register Player" + request.toString());
        playerService.registerPlayer(request);
    }

    @MessageMapping("/set-ready")
    @SendTo("/topic/set-ready")
    public boolean setReady(SetReadyRequest request) throws Exception {
        System.out.println("Message Received : Ready " + request.toString());

        Player player = playerService.findPlayer(request);

        player.setReady(true);

        return playerService.isAllPlayersReady();
    }

    @MessageMapping("/select-item")
    @SendTo("/topic/select-item")
    public BingoItem selectItem(BingoItem item) throws Exception {
        System.out.println("Message Received : " + item.toString());
        return item;
    }

    @MessageMapping("/shout-bingo")
    @SendTo("/topic/shout-bingo")
    public String shoutBingo(String name) throws Exception {
        System.out.println("Message Received : Bingo" + name);
        return name;
    }
}
