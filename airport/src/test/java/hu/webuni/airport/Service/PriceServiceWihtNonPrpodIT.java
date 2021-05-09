package hu.webuni.airport.Service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hu.webuni.airport.service.PriceService;

@SpringBootTest
public class PriceServiceWihtNonPrpodIT {
	
	@Autowired
	PriceService priceService;
	
	@Test
	void testGetFinalPrice1() throws Exception {
		int newPrice = priceService.getFinalPrice(100);
		assertThat(newPrice).isEqualTo(90);
	}
	
	@Test
	void testGetFinalPrice2() throws Exception {
		int newPrice = priceService.getFinalPrice(11000);
		assertThat(newPrice).isEqualTo(8250);
	}
	
	
	
	
	
}
