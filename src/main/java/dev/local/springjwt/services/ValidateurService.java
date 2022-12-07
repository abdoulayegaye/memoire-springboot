package dev.local.springjwt.services;

import dev.local.springjwt.dao.ValidateurDao;
import dev.local.springjwt.domain.ValidateurDto;
import dev.local.springjwt.exception.RequestException;
import dev.local.springjwt.mapping.ValidateurMapper;
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
public class ValidateurService {
    ValidateurDao validateurDao;
    MessageSource messageSource;
    ValidateurMapper validateurMapper;

    @Transactional(readOnly = true)
    public List<ValidateurDto> getValidateurs() {
        return StreamSupport.stream(validateurDao.findAll().spliterator(), false)
                .map(validateurMapper::toValidateur)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ValidateurDto getValidateur(Long id) {
        return validateurMapper.toValidateur(validateurDao.findById(id).get());
    }

    @Transactional
    public ValidateurDto createValidateur(ValidateurDto validateurDto) {
        return validateurMapper.toValidateur(validateurDao.save(validateurMapper.fromValidateur(validateurDto)));
    }

    @Transactional
    public ValidateurDto updateValidateur(Long id, ValidateurDto validateurDto) {
        validateurDto.setId(id);
        return validateurMapper.toValidateur(validateurDao.save(validateurMapper.fromValidateur(validateurDto)));
    }

    @Transactional
    public void deleteValidateur(Long id) {
        try {
            validateurDao.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("user.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
