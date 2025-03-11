package com.example.demo.controller;

import com.example.demo.entities.Bloc;
import com.example.demo.services.IBlocService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocController {
    @Autowired
    IBlocService blocService;

    @PostMapping("/add-bloc")
    public Bloc addbloc(@RequestBody Bloc bloc){
        return blocService.createBloc(bloc);
    }
    @PutMapping("/update-bloc")
    public Bloc updatebloc(@RequestBody Bloc bloc){
        return blocService.updateBloc(bloc);
    }

    @GetMapping("/display-bloc")
    public List<Bloc> displaybloc() {
        return blocService.getAllBlocs();
    }

    @GetMapping("/display-blocbyid/{id}")
    public Bloc displayblocbyid(@PathVariable("id") long idBloc) {
        return blocService.getBlocById(idBloc);
    }

    @DeleteMapping("/delete-bloc/{id}")
    public void deletebloc(@PathVariable("id") long idBloc) {
        blocService.deleteBloc(idBloc);
    }
    @PostMapping("/affecterChambres/{idBloc}")
    public ResponseEntity<Bloc> affecterChambresABloc(@RequestBody List<Long> numChambres, @PathVariable long idBloc) {
        Bloc bloc = blocService.affecterChambresABloc(numChambres, idBloc);
        return ResponseEntity.ok(bloc);
    }
}