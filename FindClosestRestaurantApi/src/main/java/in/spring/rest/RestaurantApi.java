package in.spring.rest;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.spring.dto.Coordinates;
import in.spring.dto.RequestRestuarant;
import in.spring.dto.RestaurantDistance;
import in.spring.entity.Restaurant;
import in.spring.service.RestaurantInterface;


@CrossOrigin("http://localhost:4200")
@RestController
public class RestaurantApi {
	
	@Autowired
	private RestaurantInterface service;
	
	@PostMapping("/add")
	public ResponseEntity<String>  addRestaurant(@RequestBody RequestRestuarant object){
		
		String address = object.getRestaurantName() +" ," + object.getLocation() + ", " + object.getArea();		 
		System.out.println(address);
		
		 List<Coordinates> addressCoordinates = service.getAddressCoordinates(address);
		
		
		
		 Restaurant  r=new Restaurant();
		 r.setLatitude(addressCoordinates.get(0).getLatitude());
		 r.setLongitude(addressCoordinates.get(0).getLongitude());
		 r.setRestaurantName(object.getRestaurantName());
		 r.setLocation(object.getLocation());
		 r.setPhNo(object.getPhNo());
		 r.setArea(object.getArea());
		
		
		boolean status = service.insertRestaurant(r);
		if(status) {
		return ResponseEntity.status(HttpStatus.CREATED).body("Inserted");
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("FAILED");
		}
	}
	
	
	@GetMapping("/get")
	public ResponseEntity<List<RestaurantDistance>>  getClosestRestaurant(@RequestParam("area") String area ){
		 List<Coordinates> addressCoordinates = service.getAddressCoordinates(area);
		   Double lan=addressCoordinates.get(0).getLatitude();
		  Double lon= addressCoordinates.get(0).getLongitude();
		
		 List<RestaurantDistance> closestRestaurant = service.getClosestRestaurant(area,lan,lon);
		 
		
		 if(closestRestaurant==null) {
			 return ResponseEntity.status(HttpStatus.OK).body(null);
		 }else {
		System.out.println(closestRestaurant.toString());
		return ResponseEntity.status(HttpStatus.OK).body(closestRestaurant);
		 }
	}
	
	
	
	

}
