package com.example.demo.controller;
import com.example.demo.entities.Reservation;
import com.example.demo.entities.Universite;
import com.example.demo.services.IReservationService;
import com.example.demo.services.IUniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/universitie")
public class UniversiteController {

    @Autowired
    IUniversiteService universiteService;
    @PostMapping("/add-universitie")
    public Universite adduniversitie(@RequestBody Universite u){
        return universiteService.save(u);
    }

    @PutMapping("/update-universitie")
    public Universite updateuniversitie(@RequestBody Universite u){
        return universiteService.update(u);
    }

    @GetMapping("/display-universitie")
    public List<Universite> displayuniversities(){
        return universiteService.findAll();
    }

    @GetMapping("/display-universitiebyid/{id}")
    public Universite displayuniversitiebyid(@PathVariable("id") long idUniversite){
        return universiteService.findById(idUniversite);
    }

    @PutMapping("/affecter-foyer/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(@PathVariable long idFoyer, @PathVariable String nomUniversite) {
        return universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }

    @PostMapping("/desaffecter/{idUniversite}")
    public ResponseEntity<Universite> desaffecterFoyerAUniversite(@PathVariable long idUniversite) {
        Universite universite = universiteService.desaffecterFoyerAUniversite(idUniversite);
        return ResponseEntity.ok(universite);
    }


}
