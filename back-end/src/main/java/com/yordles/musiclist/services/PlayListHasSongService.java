package com.yordles.musiclist.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.yordles.musiclist.models.PlayList;
import com.yordles.musiclist.models.PlayListHasSong;
import com.yordles.musiclist.models.Song;
import com.yordles.musiclist.models.EmbeddedKeys.PlayListHasSongId;
import com.yordles.musiclist.services.repositories.PlayListHasSongRepository;

import jakarta.transaction.Transactional;

@Service
public class PlayListHasSongService {

    @Autowired
    private PlayListHasSongRepository playListHasSongRepository;

    @Transactional
    public Iterable<PlayListHasSong> findAllPlayListHasSongs() {
        return playListHasSongRepository.findAll();
    }

    @Transactional
    public PlayListHasSong findPlayListHasSongById(PlayListHasSongId id) {
        return playListHasSongRepository.findById(id).orElse(null);
    }

    @Transactional
    public PlayListHasSong savePlayListHasSong(PlayList playList, Song song) {
        PlayListHasSongId id = new PlayListHasSongId(playList.getId(), song.getId());
        PlayListHasSong PlayListHasSong = new PlayListHasSong(id, playList, song);

        return playListHasSongRepository.save(PlayListHasSong);
    }

    @Transactional
    public void deletePlayListHasSongById(PlayList playList, Song song) {
        PlayListHasSongId id = new PlayListHasSongId(playList.getId(), song.getId());
        playListHasSongRepository.deleteById(id);
    }
}
