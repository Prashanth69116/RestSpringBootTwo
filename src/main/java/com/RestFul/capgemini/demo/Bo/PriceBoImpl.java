package com.RestFul.capgemini.demo.Bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RestFul.capgemini.demo.Eo.PriceEo;
import com.RestFul.capgemini.demo.Eo.PriceEoImpl;
import com.RestFul.capgemini.demo.MapStruct.MapStructMapper;
import com.RestFul.capgemini.demo.Repository.PriceRepository;
import com.RestFul.capgemini.demo.dto.PriceDto;

@Component
public class PriceBoImpl implements PriceBo {
	

	@Autowired
	private PriceEoImpl priceEoImpl;
	
	@Autowired
	private MapStructMapper mapStruct;
	
	static final Logger LOGGER= LoggerFactory.getLogger(PriceEo.class);
	public String ServiceLog() {
		LOGGER.info("This is a Employee Entity Eo File");
		LOGGER.warn("This is a 	Warn Message");
		LOGGER.error("This is an Error Message");
		return "ServiceLog";
	}
	@Override
	public List<PriceDto> getAllPrices() {
		List<PriceDto> allPrices = priceEoImpl.getAllPrices();
		return allPrices;
	}
	@Override
	public PriceDto getPrice(int priceId) {
		return priceEoImpl.getPrice(priceId);
	}
	@Override
	public int addprice(PriceDto id) {
		return priceEoImpl.addprice(id);
	}
	@Override
	public String deletePrice(int id) {
		return priceEoImpl.deletePrice(id);
	}
}
