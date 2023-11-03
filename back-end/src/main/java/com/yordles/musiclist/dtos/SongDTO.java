package com.yordles.musiclist.dtos;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SongDTO {

    private String name;

    private String artist;

    private String album;

    private Double duration;

    private Date releaseDate = new Date();

    private Long genreId;
}
