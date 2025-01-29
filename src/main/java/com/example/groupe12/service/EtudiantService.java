package com.example.groupe12.service;

import com.example.groupe12.entity.Etudiant;
import com.example.groupe12.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public void supprimerEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    public List<Etudiant> obtenirTousLesEtudiants() {
        return etudiantRepository.findAll();
    }

    
    public Etudiant obtenirEtudiantParId(Long id) {
        Optional<Etudiant> etudiant = etudiantRepository.findById(id);
        return etudiant.orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));
    }

    public Etudiant modifierEtudiant(Long id, Etudiant etudiant) {
        Etudiant existingEtudiant = obtenirEtudiantParId(id);
        existingEtudiant.setNom(etudiant.getNom());
        existingEtudiant.setDateNaissance(etudiant.getDateNaissance());
        existingEtudiant.setSexe(etudiant.getSexe());
   
        return etudiantRepository.save(existingEtudiant);
    }
}