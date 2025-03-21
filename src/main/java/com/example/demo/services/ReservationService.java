package com.example.demo.services;

import com.example.demo.entities.Bloc;
import com.example.demo.entities.Chambre;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Reservation;
import com.example.demo.repositories.IBlocRepository;
import com.example.demo.repositories.IChambreRepository;
import com.example.demo.repositories.IEtudiantRepository;
import com.example.demo.repositories.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ReservationService implements IReservationService {

    @Autowired
    IReservationRepository reservationRepository;

    @Autowired
    private IChambreRepository chambreRepository;

    @Autowired
    private IEtudiantRepository etudiantRepository;

    @Autowired
    private IBlocRepository blocRepository;


    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(String name) {
        return reservationRepository.getReferenceById(name);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);

    }
    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite) {
        return reservationRepository.findReservationsByAnneeUniversitaire(anneeUniversitaire);
    }

    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        // Récupérer l'étudiant
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant)
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable"));

        // Récupérer le bloc
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc introuvable"));

        // Trouver une chambre disponible
        Chambre chambreDisponible = chambreRepository.findFirstByBlocAndCapaciteNotFull(bloc)
                .orElseThrow(() -> new RuntimeException("Aucune chambre disponible"));

        // Générer l'ID de réservation
        String idReservation = chambreDisponible.getIdChambre() + "-" + bloc.getNomBloc() + "-" + LocalDate.now().getYear();

        // Créer la réservation
        Reservation reservation = new Reservation();
        reservation.setIdReservation(idReservation);
        reservation.setAnneUniversitaire(new Date());
        reservation.setEstValide(true);
        reservation.setEtudiants(Collections.singleton(etudiant));

        // Sauvegarder la réservation
        return reservationRepository.save(reservation);
    }

    public Reservation annulerReservation(long cinEtudiant) {
        // Trouver l'étudiant
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant)
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable"));

        // Trouver la réservation de l'étudiant
        Reservation reservation = reservationRepository.findByEtudiantsContaining(etudiant)
                .orElseThrow(() -> new RuntimeException("Aucune réservation trouvée pour cet étudiant"));

        // Mettre à jour l'état de la réservation
        reservation.setEstValide(false);

        // Désaffecter l'étudiant
        reservation.getEtudiants().remove(etudiant);

        // Mettre à jour la capacité de la chambre associée
        Chambre chambre = chambreRepository.findByReservationsContaining(reservation)
                .orElseThrow(() -> new RuntimeException("Chambre associée non trouvée"));
        chambre.decrementerCapacite();
        chambreRepository.save(chambre);

        // Sauvegarder la réservation mise à jour
        return reservationRepository.save(reservation);
    }
}
