package com.songchuwe.bingo;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BingoService {

    private final BingoItem[] defaultChoices = {
            new BingoItem("00000", "홍길동"),
            new BingoItem("00001", "김길동"),
            new BingoItem("00002", "이길동"),
            new BingoItem("00003", "박길동"),
    };
    private List<BingoItem> choices = Arrays.asList(defaultChoices);

    public List<BingoItem> getBingoItemChoices() {
        return choices;
    }

    public void setBingoItemChoices(List<BingoItem> choices) {
        this.choices = choices;
    }
}
