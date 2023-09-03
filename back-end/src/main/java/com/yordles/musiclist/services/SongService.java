package com.yordles.musiclist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yordles.musiclist.models.Song;
import com.yordles.musiclist.services.repositories.SongRepository;

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

    public Song updateSong(Long id, Song song) {
        Song songToUpdate = findSongById(id);

        songToUpdate.setName(song.getName());
        songToUpdate.setArtist(song.getArtist());
        songToUpdate.setAlbum(song.getAlbum());
        songToUpdate.setGenres(song.getGenres());
        songToUpdate.setReleaseDate(song.getReleaseDate());
        songToUpdate.setDuration(song.getDuration());

        return songRepository.save(song);
    }
}
