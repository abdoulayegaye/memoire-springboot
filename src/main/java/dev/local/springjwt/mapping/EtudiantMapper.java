package dev.local.springjwt.mapping;

import dev.local.springjwt.domain.EtudiantDto;
import dev.local.springjwt.model.Etudiant;
import org.mapstruct.Mapper;

@Mapper
public interface EtudiantMapper {
    EtudiantDto toEtudiant(Etudiant etudiant);
    Etudiant fromEtudiant(EtudiantDto etudiantDto);
}
