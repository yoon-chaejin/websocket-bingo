package com.songchuwe.bingo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BingoController {

    private final BingoItem[] choices = {
            new BingoItem("00000", "홍길동"),
            new BingoItem("00001", "김길동"),
            new BingoItem("00002", "이길동"),
            new BingoItem("00003", "박길동"),
    };
    private Integer readyCount = 0;

    @MessageMapping("/set-ready")
    @SendTo("/topic/set-ready")
    public boolean setReady(String name) throws Exception {
        System.out.println("Message Received : Ready" + name);
        readyCount++;
        System.out.println("Ready Count After Increment " + readyCount);
        if (readyCount >= 2) {
            return true;
        }
        else {
            return false;
        }
    }

    @MessageMapping("/select-item")
    @SendTo("/topic/select-item")
    public BingoItem selectItem(BingoItem item) throws Exception {
        System.out.println("Message Received : "+ item.toString());
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
