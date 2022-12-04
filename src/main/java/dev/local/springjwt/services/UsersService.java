package dev.local.springjwt.services;

import dev.local.springjwt.dao.UsersDao;
import dev.local.springjwt.domain.UsersDto;
import dev.local.springjwt.exception.RequestException;
import dev.local.springjwt.mapping.UsersMapper;
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
public class UsersService {

    UsersDao userDao;
    MessageSource messageSource;
    UsersMapper userMapper;

    @Transactional(readOnly = true)
    public List<UsersDto> getUsers() {
        return StreamSupport.stream(userDao.findAll().spliterator(), false)
                .map(userMapper::toUsers)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UsersDto getUser(String username) {
        return userMapper.toUsers(userDao.findByUsername(username));
    }

    @Transactional
    public UsersDto createUser(UsersDto user) {
        return userMapper.toUsers(userDao.save(userMapper.fromUsers(user)));
    }

    @Transactional
    public UsersDto updateUser(String username, UsersDto user) {
        user.setUsername(username);
        return userMapper.toUsers(userDao.save(userMapper.fromUsers(user)));
    }

    @Transactional
    public void deleteUser(Long id) {
        try {
            userDao.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("user.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
