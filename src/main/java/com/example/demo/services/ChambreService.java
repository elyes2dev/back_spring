package com.example.demo.services;

import com.example.demo.entities.Chambre;
import com.example.demo.repositories.IChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreService implements IChambreService {
    @Autowired
    IChambreRepository chambreRepository;
    @Override
    public List<Chambre> findAll() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre save(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteById(Long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public Chambre update(Chambre chambre) {
        return chambreRepository.save(chambre);
    }
}
