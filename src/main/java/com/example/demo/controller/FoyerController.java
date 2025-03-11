package com.example.demo.controller;

import com.example.demo.entities.Foyer;
import com.example.demo.entities.Reservation;
import com.example.demo.services.IFoyerService;
import com.example.demo.services.IReservationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerController {

    @Autowired
    IFoyerService foyerService;

    @PostMapping("/add-foyer")
    public Foyer addfoyer(@RequestBody Foyer f){
        return foyerService.createFoyer(f);
    }

    @PutMapping("/update-foyer")
    public Foyer updatefoyer(@RequestBody Foyer f){
        return foyerService.updateFoyer(f);
    }

    @GetMapping("/display-foyer")
    public List<Foyer> displayfoyer(){
        return foyerService.getAllFoyers();
    }

    @GetMapping("/display-foyerbyid/{id}")
    public Foyer displayfoyerbyid(@PathVariable("id") long idFoyer){
        return foyerService.getFoyerById(idFoyer);
    }

    @DeleteMapping("/delete-foyer/{id}")
    public void deletefoyer(@PathVariable("id") long idFoyer){
        foyerService.deleteFoyer(idFoyer);
    }


}