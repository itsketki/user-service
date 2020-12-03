package com.demo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
* <h1>User Service Application</h1>
* The class represents Spring Boot Application layer for UserDetails operations.
* <p>
*
* @author  Ketki Gupta
* @version 1.0
* @since   2020-12-03
*/

@SpringBootApplication
@ComponentScan(basePackages = {"com.demo.user*"})
@EntityScan("com.demo.user.model")
@EnableJpaRepositories("com.demo.user.repository")
public class UserServiceApplication{

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
