package com.yordles.musiclist.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "playlist_has_song", indexes = {
        @Index(name = "fk_playlist_has_song_song1_idx", columnList = "song_id"),
        @Index(name = "fk_playlist_has_song_playlist1_idx", columnList = "playlist_id")
})
@Data
@NoArgsConstructor
public class PlayListHasSong {

    @Id
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private PlayList playlist;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;


}
