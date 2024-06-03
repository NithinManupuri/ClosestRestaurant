package in.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.spring.entity.Restaurant;
import in.spring.service.RestaurantInterface;


@CrossOrigin("http://localhost:4200")
@RestController
public class RestaurantApi {
	
	@Autowired
	private RestaurantInterface service;
	
	@PostMapping("/add")
	public ResponseEntity<String>  addRestaurant(@RequestBody Restaurant object){
		
		boolean status = service.insertRestaurant(object);
		if(status) {
		return ResponseEntity.status(HttpStatus.CREATED).body("Inserted");
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("FAILED");
		}
	}
	
	
	@GetMapping("/add")
	public ResponseEntity<List<Restaurant>>  addRestaurant(@RequestParam("area") String area){
		
		 List<Restaurant> closestRestaurant = service.getClosestRestaurant(area);
		 if(closestRestaurant==null) {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		 }else {
		
		return ResponseEntity.status(HttpStatus.OK).body(closestRestaurant);
		 }
	}
	
	
	
	

}
