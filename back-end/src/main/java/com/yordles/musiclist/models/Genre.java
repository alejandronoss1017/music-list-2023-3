package com.yordles.musiclist.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "genre", indexes = { 
@Index(name = "name_UNIQUE", columnList = "name", unique = true) })
@Data
@NoArgsConstructor
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;

    @Column(name = "description", nullable = false)
    @NonNull
    private String description;

}
