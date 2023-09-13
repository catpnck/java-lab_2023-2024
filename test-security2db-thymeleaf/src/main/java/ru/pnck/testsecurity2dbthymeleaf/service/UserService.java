package ru.pnck.testsecurity2dbthymeleaf.service;

import ru.pnck.testsecurity2dbthymeleaf.dto.UserDto;
import ru.pnck.testsecurity2dbthymeleaf.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
