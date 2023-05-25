package com.felo.clientes.rest.dto;

import java.util.Objects;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ServiceDTO {

	@NotEmpty(message = "{field.description.mandatory}")
	private String description;
	
	@NotEmpty(message = "{field.price.mandatory}")
	private String price;
	
	@NotEmpty(message = "{field.date.mandatory}")
	private String date;
	
	@NotNull(message = "{field.client.mandatory}")
	private Integer clientId;
	
	public ServiceDTO() {
		
	}

	public ServiceDTO(String description, String price, String date, Integer clientId) {
		this.description = description;
		this.price = price;
		this.date = date;
		this.clientId = clientId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clientId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceDTO other = (ServiceDTO) obj;
		return Objects.equals(clientId, other.clientId);
	}
}
