package com.yordles.musiclist.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "genre")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genre")
    private Long id;

    @Column(name = "name")
    @NonNull
    private String name;

    @ManyToMany(mappedBy = "genres", cascade = { CascadeType.ALL })
    private Set<Song> songs = new HashSet<>();
}
