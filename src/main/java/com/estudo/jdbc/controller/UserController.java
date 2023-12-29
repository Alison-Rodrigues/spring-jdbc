package com.estudo.jdbc.controller;

import com.estudo.jdbc.dto.UserDto;
import com.estudo.jdbc.repository.UserControlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class UserController {

    @Autowired
    private UserControlRepository userControlRepository;

    @GetMapping("/user")
    public List<UserDto> findAll() throws SQLException{
        return userControlRepository.findAll();
    }

    @PostMapping("/user")
    public void save(@RequestBody UserDto userDto) throws SQLException {
        userControlRepository.save(userDto);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable(value = "id") Integer id) throws SQLException{
        userControlRepository.delete(id);
    }


}
