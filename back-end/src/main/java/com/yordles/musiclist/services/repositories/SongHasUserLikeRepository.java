package com.yordles.musiclist.services.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yordles.musiclist.models.SongHasUserLike;
import com.yordles.musiclist.models.EmbeddedKeys.SongHasUserLikeId;

public interface SongHasUserLikeRepository extends CrudRepository<SongHasUserLike, SongHasUserLikeId>{
    List<SongHasUserLike> findByUserUsername(String username);
    
}
