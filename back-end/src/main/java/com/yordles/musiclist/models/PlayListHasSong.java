package com.yordles.musiclist.models;

import com.yordles.musiclist.models.EmbeddedKeys.PlayListHasSongId;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity()
@Table(name = "playlist_has_song", indexes = {
        @Index(name = "fk_playlist_has_song_song_idx", columnList = "song_id"),
        @Index(name = "fk_playlist_has_song_playlist_idx", columnList = "playlist_id") })
@Data
@NonNull
@RequiredArgsConstructor
@NoArgsConstructor
public class PlayListHasSong {

    @EmbeddedId
    @NonNull
    private PlayListHasSongId id;


    @ManyToOne
    @MapsId("playListId")
    @NonNull
    @JoinColumn(name = "playlist_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_playlist_has_song_playlist_id"))
    PlayList playList;


    @ManyToOne
    @MapsId("songId")
    @NonNull
    @JoinColumn(name = "song_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_playlist_has_song_song_id"))
    Song song;
}
