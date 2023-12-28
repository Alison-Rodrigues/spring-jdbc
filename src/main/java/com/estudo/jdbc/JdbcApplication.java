package com.estudo.jdbc;

import com.estudo.jdbc.dto.UserDto;
import com.estudo.jdbc.repository.UserControlRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JdbcApplication.class, args);

		UserDto userDto = context.getBean(UserDto.class);
		userDto.setFirstName("Enzo");
		userDto.setLastName("Rodrigues");

		UserControlRepository userControlRepository = context.getBean(UserControlRepository.class);
		userControlRepository.save(userDto);

		System.out.println(userControlRepository.findAll());

	}

}
