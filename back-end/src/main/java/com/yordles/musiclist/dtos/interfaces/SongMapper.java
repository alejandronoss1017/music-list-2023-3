package com.yordles.musiclist.dtos.interfaces;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.yordles.musiclist.dtos.SongDTO;
import com.yordles.musiclist.models.Song;

@Mapper
public interface SongMapper {

    SongMapper INSTANCE = Mappers.getMapper(SongMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "artist", target = "artist")
    @Mapping(source = "album", target = "album")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "releaseDate", target = "releaseDate")
    @Mapping(source = "genre.id", target = "genreId")
    SongDTO songToSongDTO(Song song);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "artist", target = "artist")
    @Mapping(source = "album", target = "album")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "releaseDate", target = "releaseDate")
    @Mapping(source = "genreId", target = "genre.id")
    Song songDTOToSong(SongDTO songDTO);
}
