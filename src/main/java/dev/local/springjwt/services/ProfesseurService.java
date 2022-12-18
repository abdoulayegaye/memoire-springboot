package dev.local.springjwt.services;

import dev.local.springjwt.dao.ProfesseurDao;
import dev.local.springjwt.domain.ProfesseurDto;
import dev.local.springjwt.exception.RequestException;
import dev.local.springjwt.mapping.ProfesseurMapper;
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
public class ProfesseurService {
    ProfesseurDao professeurDao;
    MessageSource messageSource;
    ProfesseurMapper professeurMapper;

    @Transactional(readOnly = true)
    public List<ProfesseurDto> getProfesseurs() {
        return StreamSupport.stream(professeurDao.findAll().spliterator(), false)
                .map(professeurMapper::toProfesseur)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProfesseurDto getProfesseur(Long id) {
        return professeurMapper.toProfesseur(professeurDao.findById(id).get());
    }

    @Transactional
    public ProfesseurDto createProfesseur(ProfesseurDto ProfesseurDto) {
        return professeurMapper.toProfesseur(professeurDao.save(professeurMapper.fromProfesseur(ProfesseurDto)));
    }

    @Transactional
    public ProfesseurDto updateProfesseur(Long id, ProfesseurDto professeurDto) {
        professeurDto.setId(id);
        return professeurMapper.toProfesseur(professeurDao.save(professeurMapper.fromProfesseur(professeurDto)));
    }

    @Transactional
    public void deleteProfesseur(Long id) {
        try {
            professeurDao.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("user.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
