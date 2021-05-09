package hu.webuni.airport.service;

public class NonUniqueIataExeption extends RuntimeException{
	
	public NonUniqueIataExeption(String iata) {
	super("Existing iata : " + iata);
	}
}
