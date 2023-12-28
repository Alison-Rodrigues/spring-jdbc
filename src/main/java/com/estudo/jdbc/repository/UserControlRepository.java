package com.estudo.jdbc.repository;

import com.estudo.jdbc.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@Repository
public class UserControlRepository {

    private final JdbcTemplate jdbcTemplate;

    public void save(UserDto userDto) {

        String sql = "INSERT INTO jdbc_data.user (first_name, last_name) VALUES (?,?)";

        int rows = jdbcTemplate.update(sql, userDto.getFirstName(), userDto.getLastName());

        System.out.println(rows + "linha(s) afetada(s)");
    }

    public List<UserDto> findAll() {

        String sql = "SELECT * FROM jdbc_data.user";

        RowMapper<UserDto> mapper = new RowMapper<UserDto>() {
            @Override
            public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserDto userDto = new UserDto();

                userDto.setFirstName(rs.getString("first_name"));
                userDto.setLastName(rs.getString("last_name"));

                return userDto;
            }
        };

        List<UserDto> userDtoList = jdbcTemplate.query(sql, mapper);

        return userDtoList;
    }
}
