package com.example.demo.services;

import com.example.demo.entities.Bloc;
import com.example.demo.repositories.IBlocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlocService implements IBlocService {
    @Autowired
    IBlocRepository blocRepository;

    @Override
    public List<Bloc> getAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc getBlocById(Long id) {
        return blocRepository.findById(id).orElse(null);
    }

    @Override
    public Bloc createBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(Long id) {
        blocRepository.deleteById(id);
    }
}
