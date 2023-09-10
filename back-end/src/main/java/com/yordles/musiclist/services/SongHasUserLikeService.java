package com.yordles.musiclist.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.yordles.musiclist.models.EmbeddedKeys.SongHasUserLikeId;
import com.yordles.musiclist.services.repositories.SongHasUserLikeRepository;

import jakarta.transaction.Transactional;

@Service
public class SongHasUserLikeService {
    
    @Autowired
    private SongHasUserLikeRepository songHasUserLikeRepository;

    @Transactional
    public void deleteUserById(SongHasUserLikeId id) {
        songHasUserLikeRepository.deleteById(id);
    }
}
