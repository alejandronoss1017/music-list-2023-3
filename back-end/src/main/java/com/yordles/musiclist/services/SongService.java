package com.yordles.musiclist.services;

import com.yordles.musiclist.models.DTO.SongRequest;
import com.yordles.musiclist.models.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yordles.musiclist.models.Song;
import com.yordles.musiclist.services.repositories.SongRepository;

import java.util.Set;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public Iterable<Song> findAllSongs() {
        return songRepository.findAll();
    }

    public Song findSongById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    public Song saveSong(Song song) {
        return songRepository.save(song);
    }

    public void deleteSongById(Long id) {
        songRepository.deleteById(id);
    }

    public void deleteSong(Song song) {
        songRepository.delete(song);
    }

    public Song updateSong(Long id, SongRequest songRequest, Set<Genre> genres) {
        Song songToUpdate = findSongById(id);

        songToUpdate.setName(songRequest.getName());
        songToUpdate.setArtist(songRequest.getArtist());
        songToUpdate.setAlbum(songRequest.getAlbum());
        songToUpdate.getGenres().clear();
        songToUpdate.getGenres().addAll(genres);
        songToUpdate.setReleaseDate(songRequest.getReleaseDate());
        songToUpdate.setDuration(songRequest.getDuration());

        return songRepository.save(songToUpdate);
    }
}
