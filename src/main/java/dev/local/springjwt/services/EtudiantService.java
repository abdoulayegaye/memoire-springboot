package dev.local.springjwt.services;

import dev.local.springjwt.dao.EtudiantDao;
import dev.local.springjwt.domain.EtudiantDto;
import dev.local.springjwt.exception.RequestException;
import dev.local.springjwt.mapping.EtudiantMapper;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class EtudiantService {
    EtudiantDao etudiantDao;
    MessageSource messageSource;
    EtudiantMapper etudiantMapper;

    @Transactional(readOnly = true)
    public List<EtudiantDto> getEtudiants() {
        return StreamSupport.stream(etudiantDao.findAll().spliterator(), false)
                .map(etudiantMapper::toEtudiant)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EtudiantDto getEtudiant(Long id) {
        return etudiantMapper.toEtudiant(etudiantDao.findById(id).get());
    }

    @Transactional
    public EtudiantDto createEtudiant(EtudiantDto etudiantDto) {
        return etudiantMapper.toEtudiant(etudiantDao.save(etudiantMapper.fromEtudiant(etudiantDto)));
    }

    @Transactional
    public EtudiantDto updateEtudiant(Long id, EtudiantDto etudiantDto) {
        etudiantDto.setId(id);
        return etudiantMapper.toEtudiant(etudiantDao.save(etudiantMapper.fromEtudiant(etudiantDto)));
    }

    @Transactional
    public void deleteEtudiant(Long id) {
        try {
            etudiantDao.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("user.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
