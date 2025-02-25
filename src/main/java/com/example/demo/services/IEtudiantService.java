package com.example.demo.services;

import com.example.demo.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    public List<Etudiant> findAll();
    public Etudiant findById(int id);
    public Etudiant save(Etudiant etudiant);
    public void deleteById(int id);
    public Etudiant update(Etudiant etudiant);
}
