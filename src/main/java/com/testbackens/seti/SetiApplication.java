package com.testbackens.seti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.testbackens.seti.models")
public class SetiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SetiApplication.class, args);
	}

}
