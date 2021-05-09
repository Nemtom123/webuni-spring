package hu.webuni.airport.web;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hu.webuni.airport.dto.AirportDto;



@Controller
public class AirportTLController {
	
	
	private List<AirportDto> allAirports = new ArrayList<>();
	
	{
		allAirports.add(new AirportDto((long) 1, "Ferenc Liszt", "BUD"));
	}
	
	// Index oldal
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	//Átküldjük az adatokat aiports oldalra
	@GetMapping("/airports")
	public String listAirports(Map<String, Object>model) {
		model.put("airports", allAirports);
		model.put("newAirport", new AirportDto()); // airports.html oldalrol kérjük vissza az objektet
		return "airports";
	}
	
	//Post keresztűl küldjük vissza az oldalra 
	@PostMapping("/airports")
	public String addAirports(AirportDto airport) {
		allAirports.add(airport); // feltöltjük adatokkal a tömböt 
		return "redirect:airports"; // redirect azért kell mert a böngészőt kérjük meg, hogy Get mappingon keresztűl kapja meg az adatokat
	}
	
}
