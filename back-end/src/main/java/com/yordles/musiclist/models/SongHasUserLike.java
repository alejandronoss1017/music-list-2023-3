package com.yordles.musiclist.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import com.yordles.musiclist.models.EmbeddedKeys.SongHasUserLikeId;

@Entity()
@Table(name = "song_has_user_like", indexes = {
        @Index(name = "fk_song_has_user_like_song_id_idx", columnList = "song_id"),
        @Index(name = "fk_song_has_user_like_user_id_idx", columnList = "user_id")
})
@Data
@NonNull
@RequiredArgsConstructor
@NoArgsConstructor
public class SongHasUserLike {

    @EmbeddedId
    @NonNull
    private SongHasUserLikeId id;

    @ManyToOne
    @MapsId("songId")
    @NonNull
    @JoinColumn(name = "song_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_song_has_user_like_song_id"))
    private Song song;

    @ManyToOne
    @MapsId("userId")
    @NonNull
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_song_has_user_like_user_id"))
    private User user;

}
