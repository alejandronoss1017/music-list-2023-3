package com.yordles.musiclist.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.yordles.musiclist.models.Song;
import com.yordles.musiclist.models.SongHasUserLike;
import com.yordles.musiclist.models.User;
import com.yordles.musiclist.models.EmbeddedKeys.SongHasUserLikeId;
import com.yordles.musiclist.services.repositories.SongHasUserLikeRepository;

import jakarta.transaction.Transactional;

@Service
public class SongHasUserLikeService {
    
    @Autowired
    private SongHasUserLikeRepository songHasUserLikeRepository;

    @Transactional
    public Iterable<SongHasUserLike> findAllSongHasUserLikes() {
        return songHasUserLikeRepository.findAll();
    }

    @Transactional
    public SongHasUserLike findSongHasUserLikeById(SongHasUserLikeId id) {
        return songHasUserLikeRepository.findById(id).orElse(null);
    }

    @Transactional
    public SongHasUserLike saveSongHasUserLike(SongHasUserLike id) {
        return songHasUserLikeRepository.save(id);
    }

    @Transactional
    public SongHasUserLike saveSongHasUserLike(Song song, User user) {
        SongHasUserLikeId id = new SongHasUserLikeId(song.getId(), user.getId());
        SongHasUserLike songHasUserLike = new SongHasUserLike(id, song, user);

        return songHasUserLikeRepository.save(songHasUserLike);
    }

    @Transactional
    public void deleteSongHasUserLikeById(Song song, User user) {
        SongHasUserLikeId id = new SongHasUserLikeId(song.getId(), user.getId());
        songHasUserLikeRepository.deleteById(id);
    }
}
