package com.yordles.musiclist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yordles.musiclist.models.Genre;
import com.yordles.musiclist.services.repositories.GenreRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class GenreService {

    /**
     * A service class that will handle the business logic related to genres.
     * This class will typically interact with the repository to save the song to
     * the database.
     */

    @Autowired
    private GenreRepository genreRepository;

    public Iterable<Genre> findAllGenres() {
        return genreRepository.findAll();
    }

    public Genre findGenreById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    public Genre findGenreByName(String name) {
        return genreRepository.findByName(name);
    }

    public Set<Genre> findGenreByIds(Set<Long> ids) {
        Set<Genre> genreSet = new HashSet<>();
        genreRepository.findAllById(ids).forEach(genreSet::add);
        return genreSet;
    }

    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Iterable<Genre> saveManyGenres(Iterable<Genre> genres) {
        return genreRepository.saveAll(genres);
    }

    public Genre patchGenre(Long id, Genre genre) {
        Genre genreToPatch = findGenreById(id);

        if (genre.getName() != null) {
            genreToPatch.setName(genre.getName());
        }

        if (genre.getDescription() != null) {
            genreToPatch.setDescription(genre.getDescription());
        }

        return genreRepository.save(genreToPatch);
    }

    public Genre updateGenre(Long id, Genre genre) {
        Genre genreToUpdate = findGenreById(id);

        genreToUpdate.setName(genre.getName());
        genreToUpdate.setDescription(genre.getDescription());

        return genreRepository.save(genreToUpdate);
    }

    public void deleteGenreById(Long id) {
        genreRepository.deleteById(id);
    }

    public void deleteGenre(Genre genre) {
        genreRepository.delete(genre);
    }

}
