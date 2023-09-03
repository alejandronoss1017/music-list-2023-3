package com.yordles.musiclist.models.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class SongRequest {
    private String name;
    private String artist;
    private String album;
    private Long duration;
    private Date releaseDate;
    private Set<Long> genres = new HashSet<>();
}
