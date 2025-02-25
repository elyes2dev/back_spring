package com.example.demo.services;

import com.example.demo.entities.Etudiant;
import com.example.demo.repositories.IEtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService implements IEtudiantService {
    @Autowired
    IEtudiantRepository etudiantRepository;

    @Override
    public List<Etudiant> findAll() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant findById(int id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public Etudiant save(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void deleteById(int id) {
        etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant update(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }
}
