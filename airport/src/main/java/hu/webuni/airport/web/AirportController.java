package hu.webuni.airport.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import hu.webuni.airport.dto.AirportDto;

@RestController
@RequestMapping("/api/airports")
public class AirportController { 
	
	
	private Map<Long, AirportDto> airports = new HashMap<>();
	
	{
		airports.put(1L, new AirportDto(1L, "ABC", "BUD"));
		airports.put(2L, new AirportDto(2L, "DEF", "WIN"));
	}
	
	@GetMapping // Összes memóriában lévő tömbötz add vissza
	public List<AirportDto> getAll(){
	return new ArrayList(airports.values());
	}
	
	@GetMapping("/{id}") // "id" egy darabot add vissza 404 hibábaval 
	public ResponseEntity<AirportDto> getById(@PathVariable Long id) {
		AirportDto airportDto = airports.get( id);
		if (airportDto != null ) {
			return ResponseEntity.ok(airportDto);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping// postmapping uj airport létrehozása
	public AirportDto createAirport(@RequestBody AirportDto airportDto) {
		airports.put(airportDto.getId(), airportDto);
		return airportDto;
	}
	
	@PutMapping("/{id}")//Meglévő adatot modosít
	public ResponseEntity<AirportDto> modifyAirpor(@PathVariable Long id,@RequestBody AirportDto airportDto){ 
		if(!airports.containsKey(id)) {
			return ResponseEntity.notFound().build();
		}
		airportDto.setId(id); // az url ben utazót állítjuk be mert itt ez a nérvadó  	és nem az AirportDto id állítjuk be
		airports.put(id, airportDto);
		return ResponseEntity.ok(airportDto);
		
	}


	@DeleteMapping("/{id}")
	public void deleteAirport(@PathVariable Long id) {
		airports.remove(id);
	}
	
}
