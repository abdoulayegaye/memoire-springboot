package dev.local.springjwt.services;

import dev.local.springjwt.dao.ProfilDao;
import dev.local.springjwt.domain.ProfilDto;
import dev.local.springjwt.exception.RequestException;
import dev.local.springjwt.mapping.ProfilMapper;
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
public class ProfilService {
    ProfilDao profilDao;
    MessageSource messageSource;
    ProfilMapper profilMapper;

    @Transactional(readOnly = true)
    public List<ProfilDto> getProfils() {
        return StreamSupport.stream(profilDao.findAll().spliterator(), false)
                .map(profilMapper::toProfil)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProfilDto getProfil(Long id) {
        return profilMapper.toProfil(profilDao.findById(id).get());
    }

    @Transactional
    public ProfilDto createProfil(ProfilDto profilDto) {
        return profilMapper.toProfil(profilDao.save(profilMapper.fromProfil(profilDto)));
    }

    @Transactional
    public ProfilDto updateProfil(Long id, ProfilDto profilDto) {
        profilDto.setId(id);
        return profilMapper.toProfil(profilDao.save(profilMapper.fromProfil(profilDto)));
    }

    @Transactional
    public void deleteProfil(Long id) {
        try {
            profilDao.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("user.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
