package com.felo.clientes.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.felo.clientes.model.entities.Client;
import com.felo.clientes.model.repositories.ClientRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void run(String... args) throws Exception {

		Client u1 = new Client(null, "Maria Brown", "00000000000", LocalDate.now());
		
		clientRepository.saveAll(Arrays.asList(u1));
		
	}
	
}
