package com.example.demo.repositories;

import com.example.demo.entities.Bloc;
import com.example.demo.entities.Chambre;
import com.example.demo.entities.Reservation;
import com.example.demo.entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IChambreRepository extends JpaRepository<Chambre, Long> {

    @Query("SELECT c FROM Chambre c WHERE c.bloc.foyer.universite.nomUniversite = :nomUniversite AND c.typeC = :type AND c.reservations IS EMPTY")
    List<Chambre> findChambresNonReservees(String nomUniversite, TypeChambre type);

    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeC = :typeC")
    List<Chambre> findChambresParBlocEtTypeJPQL(long idBloc, TypeChambre typeC);

    List<Chambre> findByBlocIdBlocAndTypeC(long idBloc, TypeChambre typeC);

    @Query("SELECT c FROM Chambre c WHERE c.bloc = :bloc AND SIZE(c.reservations) < c.capacite ORDER BY c.idChambre ASC")
    Optional<Chambre> findFirstByBlocAndCapaciteNotFull(@Param("bloc") Bloc bloc);

    Optional<Chambre> findFirstByBlocAndReservationsIsEmpty(Bloc bloc);
    Optional<Chambre> findByReservationsContaining(Reservation reservation);
}
