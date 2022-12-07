package dev.local.springjwt.mapping;

import dev.local.springjwt.domain.SujetDto;
import dev.local.springjwt.model.Sujet;
import org.mapstruct.Mapper;

@Mapper
public interface SujetMapper {
    SujetDto toSujet(Sujet sujet);
    Sujet fromSujet(SujetDto dto);
}
