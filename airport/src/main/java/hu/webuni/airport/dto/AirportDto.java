package hu.webuni.airport.dto;

import javax.validation.constraints.Size;

public class AirportDto {
	
	private Long id;
	@Size(min=3, max = 20)
	private String name;
	private String iata;
	
	public AirportDto() {}
	
	public AirportDto(Long id, String name, String iata) {
		super();
		this.id = id;
		this.name = name;
		this.iata = iata;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIata() {
		return iata;
	}
	public void setIata(String iata) {
		this.iata = iata;
	}

}
