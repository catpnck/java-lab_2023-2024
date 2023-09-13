package ru.pnck.testsecurity2dbthymeleaf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private  String surname;

    @NotEmpty(message = "email should not be empty")
    @Email
    private String email;

    @NotEmpty(message = "password should not be empty")
    private String password;
}
