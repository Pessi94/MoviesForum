package com.pessi.moviesforum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

@SpringBootApplication
public class MoviesforumApplication extends WebMvcAutoConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(MoviesforumApplication.class, args);
	}

}
