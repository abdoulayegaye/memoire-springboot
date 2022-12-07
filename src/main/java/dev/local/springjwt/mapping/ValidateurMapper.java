package dev.local.springjwt.mapping;

import dev.local.springjwt.domain.ValidateurDto;
import dev.local.springjwt.model.Sujet;
import dev.local.springjwt.model.Validateur;
import org.mapstruct.Mapper;

@Mapper
public interface ValidateurMapper {
    ValidateurDto toValidateur(Validateur validateur);
    Validateur fromValidateur(ValidateurDto validateurDto);
}
