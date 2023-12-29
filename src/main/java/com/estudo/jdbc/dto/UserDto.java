package com.estudo.jdbc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {

    private Integer id;
    private String firstName;
    private String lastName;

}
