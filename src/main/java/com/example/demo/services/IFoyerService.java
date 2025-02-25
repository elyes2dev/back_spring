package com.example.demo.services;

import com.example.demo.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    public Foyer createFoyer(Foyer foyer);
    public Foyer updateFoyer(Foyer foyer);
    public Foyer getFoyerById(Long id);
    public List<Foyer> getAllFoyers();
    public void deleteFoyer(Long id);

}
