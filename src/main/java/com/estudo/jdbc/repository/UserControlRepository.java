package com.estudo.jdbc.repository;

import com.estudo.jdbc.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
@AllArgsConstructor
@Slf4j
public class UserControlRepository {

    private final JdbcTemplate jdbcTemplate;

    public void save(UserDto userDto) throws SQLException {

        String sql = "INSERT INTO jdbc_data.user (first_name, last_name) VALUES (?,?)";

        int rows = jdbcTemplate.update(sql,
                userDto.getFirstName(),
                userDto.getLastName()
        );

        log.info(String.format("%s row(s) affected.", rows));

    }

    public List<UserDto> findAll() throws SQLException{
        String sql = "SELECT * FROM jdbc_data.user";

        return jdbcTemplate.query(sql,
                (rs, i) -> new UserDto(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name")
                ));
    }

    public void delete(Integer id) throws SQLException{
        String sql = "DELETE FROM jdbc_data.user WHERE id = ?";

        int rows = jdbcTemplate.update(sql, id);

        log.info(String.format("%s row(s) deleted.", rows));
    }
}