package com.yordles.musiclist.dtos.interfaces;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.yordles.musiclist.dtos.GenreDTO;
import com.yordles.musiclist.models.Genre;

@Mapper
public interface GenreMapper {
        GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

        @Mapping(source = "name", target = "name")
        @Mapping(source = "description", target = "description")
        GenreDTO genreToDto(Genre genre);

        @Mapping(source = "name", target = "name")
        @Mapping(source = "description", target = "description")
        Genre GenreDtoToGenre(GenreDTO genreDto);
}
