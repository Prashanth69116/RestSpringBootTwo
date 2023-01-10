package com.RestFul.capgemini.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.RestFul.capgemini.demo.Entity.Item;
import com.RestFul.capgemini.demo.Service.PriceServiceImpl;
import com.RestFul.capgemini.demo.feign.FeignClientInterface;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.Before;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {


	@Test
	public void contextLoads() {
	}

	@Autowired
	private RestTemplate restTemplate=  mock(RestTemplate.class);
	
	@Autowired
	private FeignClientInterface feignClient;

	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@MockBean
	private PriceServiceImpl service;

	ObjectMapper om = new ObjectMapper();

	@Before
	private void setUp()
	{
	mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getItemTest() throws Exception
	{
	Item[] objects = new Item[2];
	objects[0] = new Item(1 ,"Iphone 6s","Mobile");
	objects[1] = new Item(2 ,"Samsung Galaxy","Mobile");

	mockMvc.perform(get("/price/getAllItems")).andExpect(status().isOk());
	assertEquals(objects.length , 2);

	}
	
	
	@Test
	public void getItembyFeignTest() throws Exception
	{

	List<Item> item = new ArrayList<Item>();
	Item item1 = new Item(1,"Iphone 6s","Mobile");
	Item item2 = new Item(2,"Samsung Galaxy","Mobile");
	item.add(item1);
	item.add(item2);
	
	mockMvc.perform(get("/price/getAllItemsFeign")).andExpect(status().isOk());


	}

	
	
	

}
