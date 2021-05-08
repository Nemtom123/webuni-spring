package hu.webuni.airport.service;

import java.io.ObjectInputFilter.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import hu.webuni.airport.config.AirportConfigPropertis;

@Service
public class SpecialDiscountService implements DiscountService{
	
//	@Value("${airport.discount.special.limit}")
//	private int limit;
//	
//	@Value("${airport.discount.special.percent}")
//	private int special;
//	
//	@Value("${airport.discount.def.percent}")
//	private int def;
//	
	@Autowired
	AirportConfigPropertis config;
	@Override
	public int getDiscountPercent(int totalPrice) {
//		return totalPrice > limit ? special:def;
		return totalPrice > config.getDiscount().getSpecial().getLimit() ? config.getDiscount().getSpecial().getPercent() : config.getDiscount().getDef().getPercent();
	}

}
