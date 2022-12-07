package dev.local.springjwt.mapping;

import dev.local.springjwt.domain.UsersDto;
import dev.local.springjwt.model.Users;
import org.mapstruct.Mapper;

@Mapper
public interface UsersMapper {
    UsersDto toUsers(Users userEntity);
    Users fromUsers(UsersDto usersDto);
}
