package com.yordles.musiclist.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity()
@Table(name = "playlist_has_song", indexes = {
        @Index(name = "fk_playlist_has_song_song1_idx", columnList = "song_id"),
        @Index(name = "fk_playlist_has_song_playlist1_idx", columnList = "playlist_id") })
@Data
@NoArgsConstructor
public class PlayListHasSong {
    @Id
    @ManyToOne
    @JoinColumn(name = "playlist_id")
    PlayList playList;

    @Id
    @ManyToOne
    @JoinColumn(name = "song_id")
    Song song;
}
