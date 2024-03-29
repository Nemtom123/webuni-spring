package hu.webuni.airport.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.webuni.airport.dto.AirportDto;
import hu.webuni.airport.mapper.AirportMapper;
import hu.webuni.airport.model.Airport;
import hu.webuni.airport.service.AirportService;
import hu.webuni.airport.service.NonUniqueIataExeption;

@RestController
@RequestMapping("/api/airports")
public class AirportController { 
	
	@Autowired
	AirportService airportService;
	
	AirportMapper airportMapper;
	
	
	@GetMapping
	public List<AirportDto> getAll(){
	airportService.findAll();
	return null;
	}
	
	
	@GetMapping("/{id}") 
	public AirportDto getById(@PathVariable Long id) {
		Airport airport = airportService.findById(id);
		
		if (airport != null ) 
			return airportMapper.airportToDto(airport);
		
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping
	public AirportDto createAirport(@RequestBody @Valid AirportDto airportDto) {
		Airport airport = airportService.save(airportMapper.dtoToAirport(airportDto));
		return airportMapper.airportToDto(airport);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AirportDto> modifyAirport(@PathVariable long id, @RequestBody AirportDto airportDto) {
		Airport airport = airportMapper.dtoToAirport(airportDto);
		airport.setId(id);
		try {
			AirportDto savedAirportDto = airportMapper.airportToDto(airportService.update(airport));
			
			return ResponseEntity.ok(savedAirportDto);
		}catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	


	@DeleteMapping("/{id}")
	public void deleteAirport(@PathVariable long id) {
		airportService.delete(id);
	}
	
	
//	private Map<Long, AirportDto> airports = new HashMap<>();
//	
//	{
//		airports.put(1L, new AirportDto(1L, "ABC", "BUD"));
//		airports.put(2L, new AirportDto(2L, "DEF", "WIN"));
//	}


//	@GetMapping("/{id}") // "id" egy darabot add vissza 404 hibábaval 
//	public AirportDto getById(@PathVariable Long id) {
//		AirportDto airportDto = airports.get( id);
////		if (airportDto != null ) {
////			return ResponseEntity.ok(airportDto);
////		}
////		else {
////			return ResponseEntity.notFound().build();
////		}
//		if (airportDto != null) 
//			return airportDto;
//		else
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//		
//	}
//	
//	@PostMapping// postmapping uj airport létrehozása
//	public AirportDto createAirport(@RequestBody @Valid AirportDto airportDto, BindingResult errors) {
//		checkUnqueIata(airportDto.getIata());
//		airports.put(airportDto.getId(), airportDto);
//		return airportDto;
//	}
//	
//	private void checkUnqueIata(String iata) {
//		// TODO Auto-generated method stub
//		Optional<AirportDto> airportWithSameIata = airports
//		.values().stream().filter(a->a.getIata()
//				.equals(iata)).findAny();
//		if(airportWithSameIata.isPresent())
//			throw new NonUniqueIataExeption(iata);
//
//	}
//
//	@PutMapping("/{id}")//Meglévő adatot modosít
//	public ResponseEntity<AirportDto> modifyAirpor(@PathVariable Long id,@RequestBody AirportDto airportDto){ 
//		if(!airports.containsKey(id)) {
//			return ResponseEntity.notFound().build();
//		}
//		checkUnqueIata(airportDto.getIata());
//		airportDto.setId(id); // az url ben utazót állítjuk be mert itt ez a nérvadó  	és nem az AirportDto id állítjuk be
//		airports.put(id, airportDto);
//		return ResponseEntity.ok(airportDto);
//		
//	}
//
//
//	@DeleteMapping("/{id}")
//	public void deleteAirport(@PathVariable Long id) {
//		airports.remove(id);
//	}
//	
}
