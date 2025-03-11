package com.example.demo.services;

import com.example.demo.entities.Bloc;
import com.example.demo.entities.Chambre;
import com.example.demo.repositories.IBlocRepository;
import com.example.demo.repositories.IChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlocService implements IBlocService {
    @Autowired
    IBlocRepository blocRepository;

    @Autowired
    IChambreRepository chambreRepository;


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
    @Override
    public Bloc affecterChambresABloc(List<Long> numChambres, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc non trouvé"));

        List<Chambre> chambres = chambreRepository.findAllById(numChambres);
        if (chambres.isEmpty()) {
            throw new RuntimeException("Aucune chambre trouvée avec les IDs fournis");
        }

        chambres.forEach(chambre -> chambre.setBloc(bloc));

        chambreRepository.saveAll(chambres);

        return bloc;
    }
}
