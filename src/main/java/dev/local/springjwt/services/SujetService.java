package dev.local.springjwt.services;

import dev.local.springjwt.config.security.JwtTokenUtil;
import dev.local.springjwt.dao.EtudiantDao;
import dev.local.springjwt.dao.SujetDao;
import dev.local.springjwt.domain.SujetDto;
import dev.local.springjwt.exception.RequestException;
import dev.local.springjwt.mapping.SujetMapper;
import dev.local.springjwt.model.Etudiant;
import dev.local.springjwt.model.Professeur;
import dev.local.springjwt.model.Sujet;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class SujetService {
    SujetDao sujetDao;
    EtudiantDao etudiantDao;
    MessageSource messageSource;
    SujetMapper sujetMapper;
    final JwtTokenUtil jwt;

    @Transactional(readOnly = true)
    public List<SujetDto> getSujets() {
        return StreamSupport.stream(sujetDao.findAll().spliterator(), false)
                .map(sujetMapper::toSujet)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Sujet> getSujets2() {
        return sujetDao.findAll();
    }

    @Transactional(readOnly = true)
    public Sujet getSujet(Long id) {
        return sujetDao.findById(id).orElse(null);
    }

    public Sujet choisirSujet(Long id, HttpServletRequest req) {
        Sujet sujet = sujetDao.findById(id).orElse(null);
        List<Sujet> sujets = new ArrayList<>();
        sujets.add(sujet);
        List<Etudiant> etudiants = etudiantDao.findBySujetsIn(sujets);
        if(etudiants.size() == 0){
            etudiants = new ArrayList<>();
        }
        Etudiant etudiant = etudiantDao.findById(jwt.getUserAuthenticate(req).getId()).orElse(null);
        Etudiant etudiantExist = etudiants.stream().filter(etudiant1 -> etudiant.getId() == etudiant1.getId()).findFirst().orElse(null);
        if (etudiantExist == null){
            etudiants.add(etudiant);
            sujet.setEtudiants(etudiants);
        }
        return sujetDao.save(sujet);
    }

    @Transactional
    public Sujet createSujet(Sujet sujet, HttpServletRequest req) {
        Professeur professeur = (Professeur) jwt.getUserAuthenticate(req);
        sujet.setProfesseur(professeur);
        return sujetDao.save(sujet);
    }

    @Transactional
    public SujetDto updateSujet(Long id, SujetDto sujetDto) {
        sujetDto.setId(id);
        return sujetMapper.toSujet(sujetDao.save(sujetMapper.fromSujet(sujetDto)));
    }

    @Transactional
    public void deleteSujet(Long id) {
        try {
            sujetDao.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("user.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
