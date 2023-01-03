package com.RestFul.capgemini.demo.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.RestFul.capgemini.demo.Entity.Price;
import com.RestFul.capgemini.demo.dto.PriceDto;


@Repository
public class PriceRepository {
	
	 @Autowired
	    JdbcTemplate template;

	   /*Getting all Prices from table*/
	    public List<PriceDto> getAllPrices(){
	        List<PriceDto> price = template.query("select PriceId, Price from price",(result,rowNum)->new PriceDto(result.getInt("PriceId"),
	                result.getInt("Price")));
	        return price;
	    }
	    
	    /*Getting a specific price by item id from table*/
	    public PriceDto getPrice(int priceId){
	        String query = "SELECT * FROM PRICE WHERE PRICEID=?";
	        PriceDto price = template.queryForObject(query,new Object[]{priceId},new BeanPropertyRowMapper<>(PriceDto.class));

	        return price;
	    }
	    
	    /*delete an price from database*/
	    public int deletePrice(int id){
	        String query = "DELETE FROM PRICE WHERE PRICEID =?";
	        return template.update(query,id);
	    }
	    
	    /*Adding an price into database table*/
		public int addPrice(PriceDto id) {
			String query = "INSERT INTO PRICE VALUES(?,?)";
	        return template.update(query,new Object[] {id.getPriceId(), id.getPrice()});
			
		}


}
