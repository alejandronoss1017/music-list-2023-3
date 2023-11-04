package com.yordles.musiclist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yordles.musiclist.dtos.SongDTO;
import com.yordles.musiclist.dtos.interfaces.SongMapper;
import com.yordles.musiclist.models.Genre;
import com.yordles.musiclist.models.Song;
import com.yordles.musiclist.services.repositories.SongRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private GenreService genreService;

    @Transactional
    public Iterable<Song> findAllSongs() {
        return songRepository.findAll();
    }

    @Transactional
    public Iterable<Song> findAllSongsByGenreId(Long genreId) {
        Genre genre = genreService.findGenreById(genreId);

        return songRepository.findByGenre(genre);
    }

    @Transactional
    public Song findSongById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Transactional
    public Iterable<Song> findAllSongsByPartialName(String partialName) {
        return songRepository.findByNameContainingIgnoreCase(partialName);
    }

    @Transactional
    public Song saveSong(SongDTO songRequest) {

        Song songToSave = SongMapper.INSTANCE.songDTOToSong(songRequest);

        songToSave.setGenre(genreService.findGenreById(songToSave.getGenre().getId()));

        return songRepository.save(songToSave);
    }

    @Transactional
    public Iterable<Song> saveManySongs(Iterable<SongDTO> songs) {

        List<Song> songsToSave = mapIterable(songs);

        return songRepository.saveAll(songsToSave);
    }

    @Transactional
    public Song updateSong(Long id, SongDTO songRequest) {

        Song songToUpdate = SongMapper.INSTANCE.songDTOToSong(songRequest);

        songToUpdate = findSongById(id);
        songToUpdate.setAlbum(songRequest.getAlbum());
        songToUpdate.setArtist(songRequest.getArtist());
        songToUpdate.setDuration(songRequest.getDuration());
        songToUpdate.setName(songRequest.getName());
        songToUpdate.setReleaseDate(songRequest.getReleaseDate());
        songToUpdate.setGenre(genreService.findGenreById(songRequest.getGenreId()));

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

        List<Song> destinationList = new ArrayList<>();

        for (SongDTO songDTO : songsToMap) {

            Song song = SongMapper.INSTANCE.songDTOToSong(songDTO);

            song.setGenre(genreService.findGenreById(song.getGenre().getId()));

            destinationList.add(song);

        }
        return destinationList;

    }

}
