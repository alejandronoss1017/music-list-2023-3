package com.yordles.musiclist.models;

import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "playlist", indexes = { @Index(name = "fk_playlist_genre_idx", columnList = "genre_id") })
@Data
@NoArgsConstructor
public class PlayList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;

    @ManyToOne()
    @JoinColumn(name = "genre_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_playlist_genre"), nullable = false)
    @NonNull
    private Genre genre;

    // @ManyToMany()
    // @JoinTable(
    //     name = "playlist_has_song",
    //     joinColumns = @JoinColumn(name = "song_id"),
    //     inverseJoinColumns = @JoinColumn(name = "playlist_id"),
    //     indexes = {
    //         @Index(name = "fk_playlist_has_song_song1_idx", columnList = "song_id"),
    //         @Index(name = "fk_playlist_has_song_playlist1_idx", columnList = "playlist_id")
    //     }
    // )
    // private Set<Song> songs;

    @ManyToMany(mappedBy = "playlist")
    private Set<PlayListHasSong> playlistHasSong;
}
