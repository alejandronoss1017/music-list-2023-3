package com.yordles.musiclist.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

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

    @Column(name = "release_date")
    @NonNull
    private Date releaseDate;

    @JsonManagedReference
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "song_has_genre", joinColumns = @JoinColumn(name = "song_id_song"), inverseJoinColumns = @JoinColumn(name = "genre_id_genre"))
    @NonNull
    private Set<Genre> genres = new HashSet<>();

    public void addGenre(Genre genre) {
        genres.add(genre);
        genre.getSongs().add(this);
    }

    public void removeGenre(Genre genre) {
        genres.remove(genre);
        genre.getSongs().remove(this);
    }
}
