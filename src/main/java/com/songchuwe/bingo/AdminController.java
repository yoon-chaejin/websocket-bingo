package com.songchuwe.bingo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class AdminController {

    private BingoService bingoService;

    public AdminController(BingoService bingoService) {
        this.bingoService = bingoService;
    }

    @GetMapping("/")
    public String home() {
        return "admin-main.html";
    }
    
    @PostMapping("/item-choices")
    @ResponseBody()
    public ResponseEntity<?> setBingoItemChoices(@RequestBody List<BingoItem> choices) {
        bingoService.setBingoItemChoices(choices);
        
        return ResponseEntity.ok().build();
    }
}
