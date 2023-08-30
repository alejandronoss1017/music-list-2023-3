package com.yordles.musiclist.services.repositories;

import org.springframework.data.repository.CrudRepository;

import com.yordles.musiclist.models.Song;

public interface SongRepository extends CrudRepository<Song, Long> {
    
}
