package com.example.restapimongodb;

import com.example.restapimongodb.controllers.ProductController;
import com.example.restapimongodb.controllers.CategoryController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiMongodbApplication.class, args);
	}
}
