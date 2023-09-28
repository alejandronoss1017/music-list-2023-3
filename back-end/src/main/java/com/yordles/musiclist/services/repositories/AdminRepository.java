package com.yordles.musiclist.services.repositories;

import org.springframework.data.repository.CrudRepository;

import com.yordles.musiclist.models.Admin;

public interface AdminRepository extends CrudRepository<Admin, Long> {
    
}
