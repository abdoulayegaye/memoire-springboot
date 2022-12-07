package dev.local.springjwt.mapping;

import dev.local.springjwt.domain.ChefDepartementDto;
import dev.local.springjwt.model.ChefDepartement;
import org.mapstruct.Mapper;

@Mapper
public interface ChefDepartementMapper {
    ChefDepartementDto toChefDepartement(ChefDepartement chefDepartement);
    ChefDepartement fromChefDepartement(ChefDepartementDto chefDepartementDto);
}
