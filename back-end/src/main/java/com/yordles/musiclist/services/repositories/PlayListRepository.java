package com.yordles.musiclist.services.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yordles.musiclist.models.PlayList;

@Repository
public interface PlayListRepository extends CrudRepository<PlayList, Long> {

}
