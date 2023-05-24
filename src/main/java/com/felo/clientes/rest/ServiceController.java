package com.felo.clientes.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.felo.clientes.model.entities.Client;
import com.felo.clientes.model.entities.Service;
import com.felo.clientes.model.repositories.ClientRepository;
import com.felo.clientes.model.repositories.ServiceRepository;
import com.felo.clientes.rest.dto.ServiceDTO;

@RestController
@RequestMapping("/api/servicos-prestados")
public class ServiceController {
	
	private final ClientRepository clientRepository;
	private final ServiceRepository repository;
	
	public ServiceController(ClientRepository clientRepository, ServiceRepository repository) {
		this.clientRepository = clientRepository;
		this.repository = repository;
	}

	@PostMapping
	public Service save(@RequestBody ServiceDTO dto) {
		
		LocalDate date = LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Integer ClientId = dto.getClientId();
		
		Client client = clientRepository.findById(ClientId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente"));
		
		Service service = new Service();
		service.setDescription(dto.getDescription());
		service.setDate(date);
		service.setClient(client);
		service.setPrice(null);
		
	}

}
