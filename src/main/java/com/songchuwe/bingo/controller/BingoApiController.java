package com.songchuwe.bingo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.songchuwe.bingo.model.BingoItem;
import com.songchuwe.bingo.service.BingoService;

@RestController
public class BingoApiController {

    private BingoService bingoService;

    public BingoApiController(BingoService bingoService) {
        this.bingoService = bingoService;
    }

    @CrossOrigin
    @GetMapping("/item-choices")
    public List<BingoItem> getBingoItemChoices() {
        return bingoService.getBingoItemChoices();
    }

    @PostMapping("/item-choices")
    public ResponseEntity<?> setBingoItemChoices(@RequestBody List<BingoItem> choices) {
        bingoService.setBingoItemChoices(choices);

        return ResponseEntity.ok().build();
    }
}
