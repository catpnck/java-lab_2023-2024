package ru.pnck.testsecurity2dbthymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.pnck.testsecurity2dbthymeleaf.dto.UserDto;
import ru.pnck.testsecurity2dbthymeleaf.entity.Role;
import ru.pnck.testsecurity2dbthymeleaf.entity.User;
import ru.pnck.testsecurity2dbthymeleaf.repository.RoleRepository;
import ru.pnck.testsecurity2dbthymeleaf.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        var user = new User();
        user.setName(userDto.getName() + " " + userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        var role = roleRepository.findByName("ROLE_ADMIN");
        if (role == null) {
            role = createAdminRole();
        }
        user.setRoles(List.of(role));
        userRepository.save(user);
    }

    private Role createAdminRole() {
        var role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user) {
        var userDto = new UserDto();
        var str = user.getName().split(" ");
        userDto.setName(str[0]);
        userDto.setSurname(str[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
