package in.spring.service;

import java.util.List;

import in.spring.dto.Coordinates;
import in.spring.dto.RestaurantDistance;
import in.spring.entity.Restaurant;


public interface RestaurantInterface {
	
	
	public boolean  insertRestaurant(Restaurant object);
	
	public List<RestaurantDistance> getClosestRestaurant(String area,Double lon,Double lan);
	
	
	public List<Coordinates> getAddressCoordinates(String address);
}
