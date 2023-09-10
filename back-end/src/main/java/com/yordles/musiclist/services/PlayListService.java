package com.yordles.musiclist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yordles.musiclist.models.PlayList;
import com.yordles.musiclist.services.repositories.PlayListRepository;

@Service
public class PlayListService {
    
    @Autowired
    private PlayListRepository playListRepository;

    @Transactional
    public Iterable<PlayList> findAllPlayLists() {
        return playListRepository.findAll();
    }

    @Transactional
    public PlayList findPlayListById(Long id) {
        return playListRepository.findById(id).orElse(null);
    }

    @Transactional
    public PlayList savePlayList(PlayList playList) {
        return playListRepository.save(playList);
    }

    @Transactional
    public Iterable<PlayList> saveManyPlayLists(Iterable<PlayList> playLists) {
        return playListRepository.saveAll(playLists);
    }

    @Transactional
    public void deletePlayListById(Long id) {
        playListRepository.deleteById(id);
    }

    @Transactional
    public void deletePlayList(PlayList playList) {
        playListRepository.delete(playList);
    }

}
