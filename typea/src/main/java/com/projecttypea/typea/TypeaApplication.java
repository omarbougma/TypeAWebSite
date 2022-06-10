package com.projecttypea.typea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class TypeaApplication {

	public static void main(String[] args) {
System.out.print(LocalDate.now().plusDays(1).getYear());
		SpringApplication.run(TypeaApplication.class, args);
	}

}
