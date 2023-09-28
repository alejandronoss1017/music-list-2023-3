package com.yordles.musiclist.models;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "song", uniqueConstraints = {
        @UniqueConstraint(name = "name_artist_album_UNIQUE", columnNames = { "name", "artist", "album" })
})
@Data
@NoArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;

    @Column(name = "artist", nullable = false)
    @NonNull
    private String artist;

    @Column(name = "album", nullable = false)
    @NonNull
    private String album;

    @Column(name = "duration", nullable = false)
    @NonNull
    private Double duration;

    @Column(name = "release_date", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NonNull
    private Date releaseDate = new Date();

    @Column(name = "likes", nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer likes = 0;

    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL)
    private Set<SongHasUserLike> songHasUserLikes;

    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL)
    private Set<PlayListHasSong> playListHasSongs;

}
