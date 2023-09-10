package com.yordles.musiclist.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yordles.musiclist.models.Admin;
import com.yordles.musiclist.services.repositories.AdminRepository;

import jakarta.transaction.Transactional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Transactional
    public Iterable<Admin> findAllAdmins() {
        return adminRepository.findAll();
    }

    @Transactional
    public Admin findAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }


    @Transactional
    public Set<Admin> findAdminByIds(Set<Long> ids) {
        Set<Admin> adminSet = new HashSet<>();
        adminRepository.findAllById(ids).forEach(adminSet::add);
        return adminSet;
    }

    @Transactional
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Transactional
    public Iterable<Admin> saveManyadmins(Iterable<Admin> admins) {
        return adminRepository.saveAll(admins);
    }


    @Transactional
    public Admin updateadmin(Long id, Admin admin) {
        Admin adminToUpdate = findAdminById(id);

        adminToUpdate.setEmail(admin.getEmail());
        adminToUpdate.setPassword(admin.getPassword());
        adminToUpdate.setUsername(admin.getUsername());;

        return adminRepository.save(adminToUpdate);
    }

    @Transactional
    public void deleteAdminById(Long id) {
        adminRepository.deleteById(id);
    }
    
}
