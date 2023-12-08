package com.songchuwe.bingo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.songchuwe.bingo.model.Player;
import com.songchuwe.bingo.model.PlayerRegisterRequest;
import com.songchuwe.bingo.model.PlayerUnregisterRequest;

public class PlayerServiceTest {
    
    PlayerService playerService = new PlayerService();

    @Test
    void test_registerPlayer() {
        // given
        PlayerRegisterRequest request = new PlayerRegisterRequest("00000", "홍길동");

        // when
        playerService.registerPlayer(request);
        List<Player> result = playerService.getPlayers();

        // then
        assertEquals(1, result.size());
        assertEquals(Player.of(request), result.get(0));
    }

    @Test
    void test_unregisterPlayer() {
        // given
        PlayerRegisterRequest request1 = new PlayerRegisterRequest("00001", "홍길동");
        PlayerRegisterRequest request2 = new PlayerRegisterRequest("00002", "홍길동");
        playerService.registerPlayer(request1);
        playerService.registerPlayer(request2);
        PlayerUnregisterRequest request = new PlayerUnregisterRequest("00001", "홍길동");

        // when
        playerService.unregisterPlayer(request);
        List<Player> result = playerService.getPlayers();

        // then
        assertEquals(1, result.size());
        assertEquals(Player.of(request2), result.get(0));
    }
}
