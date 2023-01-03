package com.RestFul.capgemini.demo.Service;

import java.util.List;

import com.RestFul.capgemini.demo.dto.PriceDto;


public interface PriceService {

List<PriceDto>  getAllPrices();
	
	PriceDto getPrice(int priceId);
	
	int addPrice(PriceDto i);
	
	void deletePrice(int id);
}
