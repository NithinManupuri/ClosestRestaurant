package in.spring.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.spring.dto.Coordinates;
import in.spring.dto.RestaurantDistance;
import in.spring.entity.Restaurant;
import in.spring.mapApi.GeocodingService;
import in.spring.repo.RestaurnatRepo;

@Service
public class RestaurantImpl implements RestaurantInterface {
	
	
	 private static final Logger logger = LoggerFactory.getLogger(RestaurantImpl.class);

	@Autowired
	private RestaurnatRepo repo;
	
	@Autowired
	private SortService sort;
	
	@Autowired
	private GeocodingService  geoService;
	
	
	
     List<Restaurant> sortedRestaurants;

	@Override
	public boolean insertRestaurant(Restaurant object) {
		// TODO Auto-generated method stub
		  try {

			  repo.save(object);
			  return true;
		  }catch(Exception ex) {
			 ex.printStackTrace();
			  
			  
		  }
		return false;
	}




	@Override
	public List<RestaurantDistance> getClosestRestaurant(String area,Double lat , Double lon) {
		String lastPart = getLastPart(area);
		       List<Restaurant> byArea = repo.findByArea(lastPart);
		         System.out.println(byArea.toString());
		          return  sort.getThreeClosest(byArea, lat, lon);
		
	}




	@Override
	public List<Coordinates> getAddressCoordinates(String address)  {
		return  geoService.getCoordinates(address);
	}

	private String getLastPart(String input) {
	    if (input == null || input.isEmpty()) {
	        throw new IllegalArgumentException("Input string cannot be null or empty");
	    }

	    String[] parts = input.split(","); 
	    return parts[parts.length - 1].trim(); 
	}
	
}
