package com.yordles.musiclist.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddLikeSongUserDTO {
    private Long songId;
    private String username;
}
