package com.yordles.musiclist.models.EmbeddedKeys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Embeddable
public class PlayListHasSongId implements Serializable{

    @Column(name = "playlist_id")
    @NonNull
    private Long playListId;

    @Column(name = "song_id")
    @NonNull
    private Long songId;
}
