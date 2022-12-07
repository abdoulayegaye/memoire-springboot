package dev.local.springjwt.services;

import dev.local.springjwt.dao.SujetDao;
import dev.local.springjwt.domain.SujetDto;
import dev.local.springjwt.exception.RequestException;
import dev.local.springjwt.mapping.SujetMapper;
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
public class SujetService {
    SujetDao sujetDao;
    MessageSource messageSource;
    SujetMapper sujetMapper;

    @Transactional(readOnly = true)
    public List<SujetDto> getSujets() {
        return StreamSupport.stream(sujetDao.findAll().spliterator(), false)
                .map(sujetMapper::toSujet)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public SujetDto getSujet(Long id) {
        return sujetMapper.toSujet(sujetDao.findById(id).get());
    }

    @Transactional
    public SujetDto createSujet(SujetDto sujetDto) {
        return sujetMapper.toSujet(sujetDao.save(sujetMapper.fromSujet(sujetDto)));
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
