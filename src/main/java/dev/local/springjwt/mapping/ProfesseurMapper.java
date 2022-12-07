package dev.local.springjwt.mapping;

import dev.local.springjwt.domain.ProfesseurDto;
import dev.local.springjwt.model.Professeur;
import org.mapstruct.Mapper;

@Mapper
public interface ProfesseurMapper {
    ProfesseurDto toProfesseur(Professeur professeur);
    Professeur fromProfesseur(ProfesseurDto professeurDto);
}
