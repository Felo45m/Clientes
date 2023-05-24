package com.felo.clientes.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.felo.clientes.model.entities.Service;

public interface ServiceRepository extends JpaRepository<Service, Integer>{

	@Query(" select s from Service s join s.client c " +
			" where upper( c.name ) like upper( :name ) and MONTH(s.date) =:mes ")
	List<Service> findByNameClientAndMes(
			@Param("name") String name, @Param("mes") Integer mes);

}
