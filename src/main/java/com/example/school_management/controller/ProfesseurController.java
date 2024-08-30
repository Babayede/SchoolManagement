package com.example.school_management.controller;

import com.example.school_management.model.Professeur;
import com.example.school_management.service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/professeurs")

public class ProfesseurController {

    @Autowired
    private ProfesseurService professeurService;

    @GetMapping
    public ResponseEntity<Page<Professeur>> getAllProfesseurs(Pageable pageable) {
        return new ResponseEntity<>(professeurService.getAllProfesseurs(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professeur> getProfesseurById(@PathVariable Long id) {
        Professeur professeur = professeurService.getProfesseurById(id);
        if (professeur != null) {
            return new ResponseEntity<>(professeur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Professeur> createProfesseur(@RequestBody Professeur professeur) {
        return new ResponseEntity<>(professeurService.createOrUpdateProfesseur(professeur), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professeur> updateProfesseur(@PathVariable Long id, @RequestBody Professeur professeur) {
        Professeur existingProfesseur = professeurService.getProfesseurById(id);
        if (existingProfesseur != null) {
            professeur.setId(id);
            return new ResponseEntity<>(professeurService.createOrUpdateProfesseur(professeur), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfesseur(@PathVariable Long id) {
        professeurService.deleteProfesseur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
