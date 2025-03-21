package com.example.demo.repositories;

import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, String> {
    @Query("SELECT r FROM Reservation r WHERE r.anneUniversitaire = :anneeUniversitaire AND r.estValide = true")
    List<Reservation> findReservationsByAnneeUniversitaire(Date anneeUniversitaire);
    Optional<Reservation> findByEtudiantsContaining(Etudiant etudiant);

}

