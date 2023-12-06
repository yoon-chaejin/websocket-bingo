package com.songchuwe.bingo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetReadyRequest {
    private String empNo;
    private String name;
}
