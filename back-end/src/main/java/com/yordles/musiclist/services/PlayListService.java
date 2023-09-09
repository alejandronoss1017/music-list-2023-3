package com.yordles.musiclist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yordles.musiclist.models.PlayList;
import com.yordles.musiclist.services.repositories.PlayListRepository;

@Service
public class PlayListService {
    @Autowired
    private PlayListRepository playListRepository;

    public Iterable<PlayList> findAllPlayLists() {
        return playListRepository.findAll();
    }

    public PlayList findPlayListById(Long id) {
        return playListRepository.findById(id).orElse(null);
    }

    public PlayList savePlayList(PlayList playList) {
        return playListRepository.save(playList);
    }

    public Iterable<PlayList> saveManyPlayLists(Iterable<PlayList> playLists) {
        return playListRepository.saveAll(playLists);
    }

    public void deletePlayListById(Long id) {
        playListRepository.deleteById(id);
    }

    public void deletePlayList(PlayList playList) {
        playListRepository.delete(playList);
    }

}
