package com.yordles.musiclist.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yordles.musiclist.models.Admin;
import com.yordles.musiclist.services.repositories.AdminRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

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
        admin.setPassword(encodePassword(admin.getPassword()));
        return adminRepository.save(admin);
    }

    @Transactional
    public Iterable<Admin> saveManyAdmins(Iterable<Admin> admins) {
        admins.forEach(admin -> admin.setPassword(encodePassword(admin.getPassword())));
        return adminRepository.saveAll(admins);
    }

    @Transactional
    public Admin updateAdmin(Long id, Admin admin) {
        Admin adminToUpdate = findAdminById(id);

        adminToUpdate.setEmail(admin.getEmail());
        adminToUpdate.setPassword(encodePassword(admin.getPassword()));
        adminToUpdate.setUsername(admin.getUsername());
        ;

        return adminRepository.save(adminToUpdate);
    }

    @Transactional
    public void deleteAdminById(Long id) {
        adminRepository.deleteById(id);
    }

    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
