package com.songchuwe.bingo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AdminController {
    @GetMapping("/")
    public String home() {
        return "admin-main.html";
    }

    @GetMapping("/status-board")
    public String statusBoard() {
        return "status-board.html";
    }
}
