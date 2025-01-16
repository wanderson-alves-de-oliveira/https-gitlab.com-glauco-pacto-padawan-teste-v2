package com.padwan.test;

import com.padwan.test.model.Jedi;
import com.padwan.test.model.enums.StatusJediEnum;
import com.padwan.test.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
@SpringBootApplication
public class PadwanTestApplication implements CommandLineRunner {

	@Autowired
	private JediRepository jediRepository;

	public static void main(String[] args) {
		SpringApplication.run(PadwanTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Jedi j1 = new Jedi("Silvio Franco", StatusJediEnum.JEDI, "Yoda", 9500);
		Jedi j2 = new Jedi("Luke Skywalker", StatusJediEnum.JEDI, "Yoda", 10000);
		Jedi j3 = new Jedi("Darth Vader", StatusJediEnum.JEDI, "Darth Sidious", 10000);
		Jedi j4 = new Jedi("Leia Organa", StatusJediEnum.JEDI, "Yoda", 1000);

		jediRepository.saveAll(Arrays.asList(j1, j2, j3, j4));
	}
}
