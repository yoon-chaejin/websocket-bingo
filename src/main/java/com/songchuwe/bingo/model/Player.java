package com.songchuwe.bingo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private String empNo;
    private String name;
    private boolean isReady;

    public static Player of(PlayerRegisterRequest request) {
        return new Player(request.getEmpNo(), request.getName(), false);        
    }
}
