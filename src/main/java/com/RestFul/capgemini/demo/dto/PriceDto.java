package com.RestFul.capgemini.demo.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PriceDto {
	
	@Id
	private Integer PriceId;
	
	private Integer Price;

	public PriceDto(Integer priceId, Integer price) {
		super();
		PriceId = priceId;
		Price = price;
	}

	public PriceDto() {
		super();
		
	}

	public Integer getPriceId() {
		return PriceId;
	}

	public void setPriceId(Integer priceId) {
		PriceId = priceId;
	}

	public Integer getPrice() {
		return Price;
	}

	public void setPrice(Integer price) {
		Price = price;
	}
	
	


}
