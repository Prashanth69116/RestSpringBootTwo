package com.RestFul.capgemini.demo.MapStruct;

import java.util.List;

import org.mapstruct.Mapper;

import com.RestFul.capgemini.demo.Entity.Price;
import com.RestFul.capgemini.demo.dto.PriceDto;

@Mapper(componentModel="spring")
public interface MapStructMapper {
	
	PriceDto priceToPriceDto(Integer id);
	
	PriceDto priceToPriceDto(Price price);
	
	Price priceDtoToPrice(PriceDto price);
	
	List<PriceDto> priceToPriceDtoList(List<Price> list);
	
	List<PriceDto> priceDtoToPriceList(List<PriceDto> list);	


}
