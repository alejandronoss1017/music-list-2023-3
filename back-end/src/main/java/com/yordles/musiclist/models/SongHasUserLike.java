package com.yordles.musiclist.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity()
@Table(name = "song_has_user_like", indexes = {
        @Index(name = "fk_song_has_user_like_song_id_idx", columnList = "song_id"),
        @Index(name = "fk_song_has_user_like_user_id_idx", columnList = "user_id")
})
@Data
@NoArgsConstructor
public class SongHasUserLike {

    @Id
    @ManyToOne
    @JoinColumn(name = "song_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_song_has_user_like_song_id"))
    private Song song;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_song_has_user_like_user_id"))
    private User user;

}
