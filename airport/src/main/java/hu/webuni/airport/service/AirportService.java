package hu.webuni.airport.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Service;

import hu.webuni.airport.dto.AirportDto;
import hu.webuni.airport.model.Airport;

@Service
public class AirportService {
	private Map<Long, Airport> airports = new HashMap<>();
	{
		airports.put(1L, new Airport(1L, "abc", "xyz"));
		airports.put(2L, new Airport(2L, "cba", "zyx"));
	}
	
	public Airport save(Airport airport) {
		airports.put(airport.getId(), airport);
		return airport;
	}
	
	public List<Airport> findAll(){
		return new ArrayList<>(airports.values());
	}
	
	public Airport findById(Long id) {
		return airports.get(id);
	}
	
	public void delete(long id) {
		 airports.remove(id);
	}
	
}
