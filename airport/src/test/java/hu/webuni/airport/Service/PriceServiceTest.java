package hu.webuni.airport.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import hu.webuni.airport.config.AirportConfigPropertis.Discount;
import hu.webuni.airport.service.DiscountService;
import hu.webuni.airport.service.PriceService;


@ExtendWith(MockitoExtension.class)
public class PriceServiceTest {

	
	@InjectMocks
	PriceService priceService;
	
	@Mock
	DiscountService discountService;
	
	@Test
	void testGetFinalPrice() throws Exception {
		int newPrice = new PriceService(p->5).getFinalPrice(100);
//		assertEquals(95, newPrice);
		assertThat(newPrice).isEqualTo(95);
	}
	

	@Test
	void testGetFinalPrice2() throws Exception {
		Mockito.when(discountService.getDiscountPercent(100)).thenReturn(5);
		int newPrice = priceService.getFinalPrice(100);
		assertThat(newPrice).isEqualTo(95);
	}
	

	
}
