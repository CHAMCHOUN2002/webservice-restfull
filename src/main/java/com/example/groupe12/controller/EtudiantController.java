package com.example.groupe12.controller;

import com.example.groupe12.entity.Etudiant;
import com.example.groupe12.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @PostMapping
    public Etudiant ajouterEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.ajouterEtudiant(etudiant);
    }

    @DeleteMapping("/{id}")
    public void supprimerEtudiant(@PathVariable Long id) {
        etudiantService.supprimerEtudiant(id);
    }

    @GetMapping
    public List<Etudiant> obtenirTousLesEtudiants() {
        return etudiantService.obtenirTousLesEtudiants();
    }

    @GetMapping("/{id}")
    public Etudiant obtenirEtudiantParId(@PathVariable Long id) {
        return etudiantService.obtenirEtudiantParId(id);
    }

    @PutMapping("/{id}")
    public Etudiant modifierEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        return etudiantService.modifierEtudiant(id, etudiant);
    }
}