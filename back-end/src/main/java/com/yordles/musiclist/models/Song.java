package com.yordles.musiclist.models;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_song")
    private Long id;

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;

    @Column(name = "artist", nullable = false)
    @NonNull
    private String artist;

    @Column(name = "album", nullable = false)
    @NonNull
    private String album;

    @Column(name = "duration", nullable = false)
    @NonNull
    private Long duration;

    @Column(name = "release_date", nullable = false)
    @NonNull
    private Date releaseDate;

    @ManyToMany(mappedBy = "song")
    private Set<PlayListHasSong> songInPlaylist;

}
