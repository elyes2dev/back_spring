package com.example.demo.services;

import com.example.demo.entities.Chambre;
import com.example.demo.entities.TypeChambre;

import java.util.List;

public interface IChambreService {
    public List<Chambre> findAll();
    public Chambre save(Chambre chambre);
    public void deleteById(Long id);
    public Chambre update(Chambre chambre);

    List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type);

    List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);
}
