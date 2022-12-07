package dev.local.springjwt.services;

import dev.local.springjwt.dao.DirecteurEtudesDao;
import dev.local.springjwt.domain.DirecteurEtudesDto;
import dev.local.springjwt.exception.RequestException;
import dev.local.springjwt.mapping.DirecteurEtudesMapper;
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
public class DirecteurEtudesService {
    DirecteurEtudesDao directeurEtudesDao;
    MessageSource messageSource;
    DirecteurEtudesMapper directeurEtudesMapper;

    @Transactional(readOnly = true)
    public List<DirecteurEtudesDto> getAllDirecteurEtudes() {
        return StreamSupport.stream(directeurEtudesDao.findAll().spliterator(), false)
                .map(directeurEtudesMapper::toDirecteurEtudes)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DirecteurEtudesDto getDirecteurEtudes(Long id) {
        return directeurEtudesMapper.toDirecteurEtudes(directeurEtudesDao.findById(id).get());
    }

    @Transactional
    public DirecteurEtudesDto createDirecteurEtudes(DirecteurEtudesDto DirecteurEtudesDto) {
        return directeurEtudesMapper.toDirecteurEtudes(directeurEtudesDao.save(directeurEtudesMapper.fromDirecteurEtudes(DirecteurEtudesDto)));
    }

    @Transactional
    public DirecteurEtudesDto updateDirecteurEtudes(Long id, DirecteurEtudesDto DirecteurEtudesDto) {
        DirecteurEtudesDto.setId(id);
        return directeurEtudesMapper.toDirecteurEtudes(directeurEtudesDao.save(directeurEtudesMapper.fromDirecteurEtudes(DirecteurEtudesDto)));
    }

    @Transactional
    public void deleteDirecteurEtudes(Long id) {
        try {
            directeurEtudesDao.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("user.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
