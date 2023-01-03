package com.RestFul.capgemini.demo.Eo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.RestFul.capgemini.demo.dto.PriceDto;


public interface PriceEo {
	
	static final Logger LOGGER= LoggerFactory.getLogger(PriceEo.class);
	public default String ServiceLog() {
		LOGGER.info("This is a Employee Entity File");
		LOGGER.warn("This is a 	Warn Message");
		LOGGER.error("This is an Error Message");
		return "ServiceLog";
	}
	
	public List<PriceDto> getAllPrices();
	
	public PriceDto getPrice(int priceId);
	
	public int addprice(PriceDto id);
	
	public String deletePrice(int id);
		

}
