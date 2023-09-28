package com.yordles.musiclist.services.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yordles.musiclist.models.Genre;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {
    
    Genre findByName(String name);

}
