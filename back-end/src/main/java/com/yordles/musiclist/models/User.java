package com.yordles.musiclist.models;

import java.sql.Timestamp;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(name = "email_UNIQUE", columnNames = { "email" }),
        @UniqueConstraint(name = "username_UNIQUE", columnNames = { "username" })
})
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NonNull
    private Long id;

    @Column(name = "email", nullable = false)
    @NonNull
    private String email;

    @Column(name = "username", nullable = false)
    @NonNull
    private String username;

    @Column(name = "password", nullable = false)
    @NonNull
    private String password;

    @Column(name = "create_time", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @NonNull
    private Timestamp createTime = new Timestamp(System.currentTimeMillis());

    @Column(name = "verified", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean verified = false;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<SongHasUserLike> songHasUserLikes;

}
