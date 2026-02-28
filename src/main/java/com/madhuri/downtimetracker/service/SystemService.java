package com.madhuri.downtimetracker.service;

import com.madhuri.downtimetracker.entity.SystemEntity;
import com.madhuri.downtimetracker.repository.SystemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemService {

    private final SystemRepository systemRepository;

    public SystemService(SystemRepository systemRepository) {
        this.systemRepository = systemRepository;
    }

    public List<SystemEntity> getAllSystems() {
        return systemRepository.findAll();
    }

    public SystemEntity saveSystem(SystemEntity system) {
        return systemRepository.save(system);
    }

    // ✅ ADD THIS METHOD
    public SystemEntity getSystemById(Long id) {
        return systemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("System not found with id " + id));
    }

    // ✅ ADD THIS METHOD
    public void deleteSystem(Long id) {
        systemRepository.deleteById(id);
    }
}