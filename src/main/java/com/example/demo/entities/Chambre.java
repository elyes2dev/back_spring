package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;
    private long numeroChambre;
    private TypeChambre typeC;
    @ManyToOne
    private Bloc bloc;
    @OneToMany
    private Set<Reservation> reservations;


    public void decrementerCapacite() {
        if (this.reservations != null && !this.reservations.isEmpty()) {
            this.reservations.remove(this.reservations.iterator().next());
        }
    }
}
