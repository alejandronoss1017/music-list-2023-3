package com.yordles.musiclist.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yordles.musiclist.dtos.SongDTO;
import com.yordles.musiclist.models.Song;
import com.yordles.musiclist.services.repositories.SongRepository;

import org.modelmapper.TypeToken;
import java.lang.reflect.Type;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private GenreService genreService;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public Iterable<Song> findAllSongs() {
        return songRepository.findAll();
    }

    @Transactional
    public Song findSongById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Transactional
    public Song saveSong(SongDTO songRequest) {

        Song songToSave = modelMapper.map(songRequest, Song.class);

        songToSave.setGenre(genreService.findGenreById(songRequest.getGenreId()));

        return songRepository.save(songToSave);
    }

    @Transactional
    public Iterable<Song> saveManySongs(Iterable<SongDTO> songs) {

        List<Song> songsToSave = mapIterable(songs);

        return songRepository.saveAll(songsToSave);
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

    private List<Song> mapIterable(Iterable<SongDTO> songsToMap) {
        Type listType = new TypeToken<List<Song>>() {
        }.getType();
        List<Song> destinationList = modelMapper.map(songsToMap, listType);

        return destinationList;
    }

}
