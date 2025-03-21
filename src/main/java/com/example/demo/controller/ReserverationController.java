package com.example.demo.controller;

import com.example.demo.entities.Reservation;
import com.example.demo.services.IReservationService;
import com.example.demo.services.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReserverationController {
    @Autowired
    IReservationService reservationService;


    @GetMapping("/dispaly-reservations")
    public List<Reservation> displayreservation(){
        return reservationService.getAllReservations();
    }

    @PutMapping("/update-reservation")
    public Reservation updatereservation(Reservation r){
        return reservationService.updateReservation(r);
    }
    @GetMapping("/dispaly-reservationbyid/{id}")
    public Reservation displayreservationbyid(@PathVariable("id") String idReservation){
        return reservationService.getReservationById(idReservation);
    }
    @GetMapping("/reservations/{anneeUniversitaire}/{nomUniversite}")
    public List<Reservation> getReservationsParAnneeUniversitaire(@PathVariable Date anneeUniversitaire, @PathVariable String nomUniversite) {
        return reservationService.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversitaire, nomUniversite);
    }
    //otla
    @PostMapping("/ajouter/{idBloc}/{cinEtudiant}")
    public ResponseEntity<Reservation> ajouterReservation(@PathVariable long idBloc, @PathVariable long cinEtudiant) {
        Reservation reservation = reservationService.ajouterReservation(idBloc, cinEtudiant);
        return ResponseEntity.ok(reservation);
    }

    @DeleteMapping("/annuler/{cinEtudiant}")
    public ResponseEntity<Reservation> annulerReservation(@PathVariable long cinEtudiant) {
        Reservation reservation = reservationService.annulerReservation(cinEtudiant);
        return ResponseEntity.ok(reservation);
    }
}