package com.example.demo.services;

import com.example.demo.entities.Universite;
import com.example.demo.repositories.IUniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversiteService implements IUniversiteService {

    @Autowired
    IUniversiteRepository universiteRepository;
    @Override
    public List<Universite> findAll() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite findById(Long id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public Universite save(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite update(Universite universite) {
        return universiteRepository.save(universite);
    }

}
