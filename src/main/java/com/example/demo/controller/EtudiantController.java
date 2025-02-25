package com.example.demo.controller;


import com.example.demo.entities.Etudiant;
import com.example.demo.services.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
    @Autowired
    IEtudiantService etudiantService;

    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.save(etudiant);
    }
    @GetMapping("/getall")
    public List<Etudiant> getAllEtudiant() {
        return etudiantService.findAll();
    }
    @GetMapping("/getbyid/{id}")
    public Etudiant getEtudiantById(@PathVariable int id) {
        return etudiantService.findById(id);
    }
}
