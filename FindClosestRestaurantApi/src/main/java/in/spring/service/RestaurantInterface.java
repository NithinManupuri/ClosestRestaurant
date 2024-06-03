package in.spring.service;

import java.util.List;

import in.spring.entity.Restaurant;


public interface RestaurantInterface {
	
	
	public boolean  insertRestaurant(Restaurant object);
	
	public List<Restaurant> getClosestRestaurant(String area);

}
