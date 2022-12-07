package dev.local.springjwt.mapping;

import dev.local.springjwt.domain.DirecteurEtudesDto;
import dev.local.springjwt.model.DirecteurEtudes;
import org.mapstruct.Mapper;

@Mapper
public interface DirecteurEtudesMapper {
    DirecteurEtudesDto toDirecteurEtudes(DirecteurEtudes directeurEtudes);
    DirecteurEtudes fromDirecteurEtudes(DirecteurEtudesDto directeurEtudesDto);
}
