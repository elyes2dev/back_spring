package com.example.demo.services;

import com.example.demo.entities.Bloc;

import java.util.List;

public interface IBlocService {
    public List<Bloc> getAllBlocs();
    public Bloc getBlocById(Long id);
    public Bloc createBloc(Bloc bloc);
    public Bloc updateBloc(Bloc bloc);
    public void deleteBloc(Long id);
}
