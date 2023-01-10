package com.RestFul.capgemini.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestFul.capgemini.demo.Entity.Item;
import com.RestFul.capgemini.demo.MapStruct.MapStructMapper;
import com.RestFul.capgemini.demo.Service.PriceServiceImpl;
import com.RestFul.capgemini.demo.dto.PriceDto;
import com.RestFul.capgemini.demo.feign.FeignClientInterface;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@EnableFeignClients
@RestController
@RequestMapping("/price")
public class PriceController {
	
	@Autowired
    private PriceServiceImpl service;
	
	@Autowired 
	MapStructMapper mapStruct;
	
	/*@Autowired
	FeignClientInterface feignClient;*/
	
	private static final Logger LOGGER= LoggerFactory.getLogger(PriceController.class);

	private static final String ITEMSBYTEMPLATE = "getAllMethods";

	private static final String ITEMSBYFEIGN = "getAllByFeign";

    @RequestMapping("/getAllPrice")
    public List<PriceDto> getAllPrices(){
    	LOGGER.info("inside class !!! PriceController, method!!!: getAllItems");
        return service.getAllPrices();
    }

    @GetMapping("/getPrice/{id}")
    
    public PriceDto getPrice(@PathVariable int id){
    	LOGGER.info("inside class !!! PriceController, method!!!: getItem");
        return service.getPrice(id);
    }

    @PostMapping("/addPrice")
    public String addPrice( @RequestBody PriceDto body) {
    	LOGGER.info("inside class !!! PriceController, method!!!: addItem");
    	return service.addPrice(body)+"New Details added successfully";
    }
    
    @DeleteMapping("/deletePrice/{id}")
    public void deletePrice(@PathVariable int id){
    	LOGGER.info("inside class !!! PriceController, method!!!: deleteItem");
    		service.deletePrice(id);
        
    }
    @GetMapping("/Health")
    public String HealthCheck() {
    	LOGGER.info("Health check");
    	return "Status : up ";
    }

    
    //Rest Template
    @RequestMapping("/getAllItems")
    @CircuitBreaker(name=ITEMSBYTEMPLATE, fallbackMethod="getAllMethod")
    public ResponseEntity<List<Item>> getAllItems()
    {
    List<Item> allItems = service.getAllItems();
    LOGGER.info("fetched data in controller by REST TEMPLATE");
    return new ResponseEntity<List<Item>>(allItems , HttpStatus.OK);

    }
    public ResponseEntity<String> getAllMethod(Exception e){
   	 return new ResponseEntity<String>("Item_service_is_down" , HttpStatus.OK);
    }
    
    
  //Feign Client
  @RequestMapping("/getAllItemsFeign")
  @CircuitBreaker(name=ITEMSBYFEIGN, fallbackMethod="getAllByFeign")
  public ResponseEntity<List<Item>> getAllItemsFeign()
  {
  List<Item> allItems = service.getAllItems();
  LOGGER.info("fetched data in controller by REST TEMPLATE");
  return new ResponseEntity<List<Item>>(allItems , HttpStatus.OK);

  }
  public ResponseEntity<String> getAllByFeign(Exception e){
 	 return new ResponseEntity<String>("Item_service_is_down" , HttpStatus.OK);
  }

  
  @GetMapping("/getItem/{id}")
  public Item getItem(@PathVariable int id){
  	LOGGER.info("inside class !!! PriceController, method!!!: getItem");
      return service.getItem(id);
  }

  @PostMapping("/items")
  public String addItem( @RequestBody Item id) {
  	LOGGER.info("inside class !!! PriceController, method!!!: addItem");
  	return service.addItem(id)+"New Details added successfully";
  }
  
  @DeleteMapping("/deleteItem/{id}")
  public String deleteItem(@PathVariable int id){
  	LOGGER.info("inside class !!! PriceController, method!!!: deleteItem");
  	return service.deleteItem(id);
    
  	
  	
  	
  }
  //REST TEMPLATE
  /*@RequestMapping("/getAllItems")
  @CircuitBreaker(name=ITEMSBYTEMPLATE, fallbackMethod="getAllMethod")
  public List<Item> getAllItems(){
  	LOGGER.info("inside class !!! PriceController, method!!!: getAllItems");
      return service.getAllItems();
  }*/
  
  //FEIGN CLIENT
  /*@RequestMapping("/getAllItemsFeign")
  public List<Item> getAllItemsFeign(){
  	LOGGER.info("inside class !!! PriceController, method!!!: getAllItems");
      return service.getAllItems();
  }*/
    
}
