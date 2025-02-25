package com.example.demo.services;

import com.example.demo.entities.Foyer;
import com.example.demo.repositories.IFoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoyerService implements IFoyerService {
    @Autowired
    IFoyerRepository foyerRepository;


    @Override
    public Foyer createFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer getFoyerById(Long id) {
        return foyerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Foyer> getAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public void deleteFoyer(Long id) {
        foyerRepository.deleteById(id);
    }
}
