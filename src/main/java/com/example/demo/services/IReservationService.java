package com.example.demo.services;

import com.example.demo.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {
    public List<Reservation> getAllReservations();
    public Reservation getReservationById(String name);
    public Reservation updateReservation(Reservation reservation);
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite);

}
