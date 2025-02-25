package com.example.demo.services;

import com.example.demo.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> findAll();
    Universite findById(Long id);
    Universite save(Universite universite);
    Universite update(Universite universite);
}
