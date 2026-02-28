package com.madhuri.downtimetracker.controller;

import com.madhuri.downtimetracker.entity.SystemEntity;
import com.madhuri.downtimetracker.service.SystemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/systems")
@CrossOrigin
public class SystemController {

    private final SystemService systemService;

    public SystemController(SystemService systemService) {
        this.systemService = systemService;
    }

    // ✅ GET ALL
    @GetMapping
    public List<SystemEntity> getAllSystems() {
        return systemService.getAllSystems();
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    public SystemEntity getSystemById(@PathVariable Long id) {
        return systemService.getSystemById(id);
    }

    // ✅ CREATE
    @PostMapping
    public SystemEntity createSystem(@RequestBody SystemEntity system) {
        return systemService.saveSystem(system);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public SystemEntity updateSystem(@PathVariable Long id,
                                     @RequestBody SystemEntity updatedSystem) {

        SystemEntity existing = systemService.getSystemById(id);

        existing.setEnvironment(updatedSystem.getEnvironment());
        existing.setOwner(updatedSystem.getOwner());
        existing.setSystemName(updatedSystem.getSystemName());

        return systemService.saveSystem(existing);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public void deleteSystem(@PathVariable Long id) {
        systemService.deleteSystem(id);
    }
}