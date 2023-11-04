package com.yordles.musiclist.services.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yordles.musiclist.models.Genre;
import com.yordles.musiclist.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
    Iterable<Song> findByGenre(Genre genre);
    Iterable<Song> findByNameContainingIgnoreCase(String partialName);
}
