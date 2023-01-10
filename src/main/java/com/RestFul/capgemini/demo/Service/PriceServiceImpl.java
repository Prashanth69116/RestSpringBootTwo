package com.RestFul.capgemini.demo.Service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.RestFul.capgemini.demo.Bo.PriceBoImpl;
import com.RestFul.capgemini.demo.Entity.Item;
import com.RestFul.capgemini.demo.Entity.Price;
import com.RestFul.capgemini.demo.Eo.PriceEoImpl;
import com.RestFul.capgemini.demo.MapStruct.MapStructMapper;
import com.RestFul.capgemini.demo.Repository.PriceRepository;
import com.RestFul.capgemini.demo.dto.PriceDto;
import com.RestFul.capgemini.demo.feign.FeignClientInterface;


@Service
public class PriceServiceImpl implements PriceService{

	@Autowired
	private PriceBoImpl priceBoImpl;
	
	@Autowired
	private MapStructMapper mapStruct;
	
	@Autowired
	private RestTemplate restTemplate;

	/*@Autowired
	private FeignClientInterface feignClient;*/
	
	private static final Logger LOGGER= LoggerFactory.getLogger(PriceServiceImpl.class);
	public String ServiceLog() {
		LOGGER.info("This is a Emplpyee service Layer ");
		return "ServiceLog";
	}
	@Override
	public List<PriceDto> getAllPrices() {
		LOGGER.info("inside class !!! ItemService, method!!!: getAllItems");
		
		List<PriceDto> allEmployees = priceBoImpl.getAllPrices();
		
		return allEmployees;
	}
	@Override
	public PriceDto getPrice(int priceId) {
		
		return priceBoImpl.getPrice(priceId);	
	}
	@Override
	public int addPrice(PriceDto i) {
		
		return priceBoImpl.addprice(i);
	}
	@Override
	public void deletePrice(int id) {
		priceBoImpl.deletePrice(id);
		
	}
	
	public List<Item> getAllItems() {
		      HttpHeaders headers = new HttpHeaders();
		      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		      HttpEntity <String> entity = new HttpEntity<String>(headers);
		      
		      return restTemplate.exchange("http://localhost:8080/items/getAllItems", HttpMethod.GET, entity, List.class).getBody();
	}
	public Item getItem(int id) {
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8080/items/getItem/"+id, HttpMethod.GET, entity, Item.class).getBody();
	}
	public String addItem(Item id) {
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8080/items/items", HttpMethod.POST, entity, String.class).getBody();
	}
	public String deleteItem(int id) {
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange("http://localhost:8080/items/deleteItem/"+id, HttpMethod.DELETE, entity, String.class).getBody();
		
	}
	/*public List<Item> getAllItemsFeign() {	
		return feignClient.getAllItems();
	}*/

	
	
	
	
	

}
