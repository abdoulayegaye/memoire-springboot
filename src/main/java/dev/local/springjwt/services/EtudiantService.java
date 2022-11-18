package dev.local.springjwt.services;

import dev.local.springjwt.dao.EtudiantDao;
import dev.local.springjwt.model.Etudiant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantService {
    EtudiantDao etudiantDao;

    public List<Etudiant> getEtudiants() {
        return etudiantDao.findAll();
    }

    public Etudiant getEtudiant(String matricule) {
        return etudiantDao.findByMatriculeET(matricule);
    }

    public Etudiant createEtudiant(Etudiant etudiant) {
        return etudiantDao.save(etudiant);
    }

    public Etudiant updateEtudiant(String matricule, Etudiant etudiant) {
        etudiant.setMatriculeET(matricule);
        return etudiantDao.save(etudiant);
    }

    public void deleteEtudiant(Long id) {
        etudiantDao.deleteById(id);
    }
}
