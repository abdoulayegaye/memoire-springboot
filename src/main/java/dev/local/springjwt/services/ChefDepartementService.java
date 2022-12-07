package dev.local.springjwt.services;

import dev.local.springjwt.dao.ChefDepartementDao;
import dev.local.springjwt.domain.ChefDepartementDto;
import dev.local.springjwt.exception.RequestException;
import dev.local.springjwt.mapping.ChefDepartementMapper;
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
public class ChefDepartementService {
    ChefDepartementDao chefDepartementDao;
    MessageSource messageSource;
    ChefDepartementMapper chefDepartementMapper;

    @Transactional(readOnly = true)
    public List<ChefDepartementDto> getChefDepartements() {
        return StreamSupport.stream(chefDepartementDao.findAll().spliterator(), false)
                .map(chefDepartementMapper::toChefDepartement)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ChefDepartementDto getChefDepartement(Long id) {
        return chefDepartementMapper.toChefDepartement(chefDepartementDao.findById(id).get());
    }

    @Transactional
    public ChefDepartementDto createChefDepartement(ChefDepartementDto chefDepartementDto) {
        return chefDepartementMapper.toChefDepartement(chefDepartementDao.save(chefDepartementMapper.fromChefDepartement(chefDepartementDto)));
    }

    @Transactional
    public ChefDepartementDto updateChefDepartement(Long id, ChefDepartementDto chefDepartementDto) {
        chefDepartementDto.setId(id);
        return chefDepartementMapper.toChefDepartement(chefDepartementDao.save(chefDepartementMapper.fromChefDepartement(chefDepartementDto)));
    }

    @Transactional
    public void deleteChefDepartement(Long id) {
        try {
            chefDepartementDao.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("user.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

}
