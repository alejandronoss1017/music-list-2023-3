package com.yordles.musiclist.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_song")
    private Long id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "artist")
    @NonNull
    private String artist;

    @Column(name = "album")
    @NonNull
    private String album;

    @Column(name = "duration")
    @NonNull
    private Long duration;

    @Column(name = "release")
    @NonNull
    private Date release;

    @ManyToMany
    @JoinTable(name = "song_has_genre", joinColumns = @JoinColumn(name = "song_id_song"), inverseJoinColumns = @JoinColumn(name = "genre_id_genre"))
    private Set<Genre> genres = new HashSet<>();
}
