package com.yordles.musiclist.services.repositories;

import org.springframework.data.repository.CrudRepository;

import com.yordles.musiclist.models.PlayListHasSong;
import com.yordles.musiclist.models.EmbeddedKeys.PlayListHasSongId;

public interface PlayListHasSongRepository extends CrudRepository<PlayListHasSong, PlayListHasSongId>{
    
}
