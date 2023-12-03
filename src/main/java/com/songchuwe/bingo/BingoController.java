package com.songchuwe.bingo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BingoController {

    private List<Player> players = new ArrayList<>();

    private final BingoItem[] choices = {
            new BingoItem("00000", "홍길동"),
            new BingoItem("00001", "김길동"),
            new BingoItem("00002", "이길동"),
            new BingoItem("00003", "박길동"),
    };

    @MessageMapping("/register-player")
    public void registerPlayer(PlayerRegisterRequest request) throws Exception {
        System.out.println("Message Received : Register Player" + request.toString());
        players.add(Player.of(request));
    }

    @MessageMapping("/set-ready")
    @SendTo("/topic/set-ready")
    public boolean setReady(SetReadyRequest request) throws Exception {
        System.out.println("Message Received : Ready " + request.toString());

        Player player = players.stream().filter(item -> item.getEmpNo().equals(request.getEmpNo())
                && item.getName().equals(request.getName()) && item.isReady() == false).findFirst().orElse(new Player());

        player.setReady(true);

        return players.stream().filter(item -> item.isReady() == false).collect(Collectors.toList()).size() == 0;
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

    @GetMapping("/item-choices")
    @ResponseBody
    public List<BingoItem> getBingoItemChoices() {
        return List.of(choices);
    }
}
