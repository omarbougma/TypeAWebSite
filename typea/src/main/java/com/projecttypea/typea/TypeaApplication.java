package com.projecttypea.typea;

import com.projecttypea.typea.service.EtablissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class TypeaApplication {

	public static void main(String[] args) {

		SpringApplication.run(TypeaApplication.class, args);

	}

}
