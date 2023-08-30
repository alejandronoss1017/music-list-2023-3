package com.yordles.musiclist.services.repositories;

import org.springframework.data.repository.CrudRepository;

import com.yordles.musiclist.models.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {

}
