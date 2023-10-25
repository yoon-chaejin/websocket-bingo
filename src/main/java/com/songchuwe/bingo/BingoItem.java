package com.songchuwe.bingo;

import lombok.Data;
import lombok.NonNull;

@Data
public class BingoItem {
    @NonNull
    private String empNo;
    @NonNull
    private String name;
}
