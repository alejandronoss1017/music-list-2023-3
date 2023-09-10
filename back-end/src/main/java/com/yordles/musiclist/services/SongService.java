package com.yordles.musiclist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yordles.musiclist.models.Song;
import com.yordles.musiclist.services.repositories.SongRepository;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    @Transactional
    public Iterable<Song> findAllSongs() {
        return songRepository.findAll();
    }

    @Transactional
    public Song findSongById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Transactional
    public Song saveSong(Song song) {
        return songRepository.save(song);
    }

    @Transactional
    public Iterable<Song> saveManySongs(Iterable<Song> songs) {
        return songRepository.saveAll(songs);
    }

    @Transactional
    public Song updateSong(Long id, Song songRequest) {
        Song songToUpdate = findSongById(id);
        songToUpdate.setAlbum(songRequest.getAlbum());  
        songToUpdate.setArtist(songRequest.getArtist());
        songToUpdate.setDuration(songRequest.getDuration());
        songToUpdate.setLikes(songRequest.getLikes());
        songToUpdate.setName(songRequest.getName());
        songToUpdate.setReleaseDate(songRequest.getReleaseDate());
           
        return songRepository.save(songToUpdate);
    }

    @Transactional
    public void deleteSongById(Long id) {
        songRepository.deleteById(id);
    }

    @Transactional
    public void deleteSong(Song song) {
        songRepository.delete(song);
    }

}
