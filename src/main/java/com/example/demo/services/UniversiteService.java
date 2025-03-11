package com.example.demo.services;

import com.example.demo.entities.Foyer;
import com.example.demo.entities.Universite;
import com.example.demo.repositories.IFoyerRepository;
import com.example.demo.repositories.IUniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversiteService implements IUniversiteService {

    @Autowired
    IUniversiteRepository universiteRepository;

    @Autowired
    IFoyerRepository foyerRepository;

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
    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer).get();
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);

        if (foyer == null || universite == null) {
            throw new RuntimeException("Foyer ou Université introuvable !");
        }
        universite.setFoyer(foyer);
        foyer.setUniversite(universite);

        return universiteRepository.save(universite);
    }

}
