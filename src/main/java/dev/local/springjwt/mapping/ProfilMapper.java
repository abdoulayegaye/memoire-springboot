package dev.local.springjwt.mapping;

import dev.local.springjwt.domain.ProfilDto;
import dev.local.springjwt.model.Profil;
import org.mapstruct.Mapper;

@Mapper
public interface ProfilMapper {
    ProfilDto toProfil(Profil profil);
    Profil fromProfil(ProfilDto profilDto);
}
