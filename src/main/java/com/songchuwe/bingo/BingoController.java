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

    @MessageMapping("/ready")
    public void setReady() throws Exception {
        System.out.println("Message Received : Ready");
    }

    @MessageMapping("/select-item")
    @SendTo("/topic/bingo")
    public BingoItem selectItem(BingoItem item) throws Exception {
        System.out.println("Message Received : "+ item.toString());
        return item;
    }

    @MessageMapping("/shout-bingo")
    public void shoutBingo() throws Exception {
        System.out.println("Message Received : Bingo");
    }

    @GetMapping("/item-choices")
    @ResponseBody
    public List<BingoItem> getBingoItemChoices() {
        return List.of(choices);
    }
}
