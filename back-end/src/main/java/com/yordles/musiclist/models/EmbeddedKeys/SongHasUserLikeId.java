package com.yordles.musiclist.models.EmbeddedKeys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Embeddable
public class SongHasUserLikeId implements Serializable{

    @Column(name = "song_id")
    @NonNull
    private Long songId;

    @Column(name = "user_id")
    @NonNull
    private Long userId;
}
