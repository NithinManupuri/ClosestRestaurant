package in.spring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.spring.entity.Restaurant;
import in.spring.repo.RestaurnatRepo;

@Service
public class RestaurantImpl implements RestaurantInterface {
	
	
	 private static final Logger logger = LoggerFactory.getLogger(RestaurantImpl.class);

	@Autowired
	private RestaurnatRepo repo;
	
	@Autowired
	private HeapSort sort;

	@Override
	public boolean insertRestaurant(Restaurant object) {
		// TODO Auto-generated method stub
		  try {
			  Restaurant save = repo.save(object);
			   if(save!=null) {
				   return true;
			   }
		  }catch(Exception ex) {
			 ex.printStackTrace();
			  
			  
		  }
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Restaurant> getClosestRestaurant(String area) {
		// TODO Auto-generated method stub
		 try {
			 
			 
	       List<Restaurant> byArea = repo.findByArea(area);
	       logger.info("yes get size",byArea.size());
	       System.out.println(byArea.toString());
	        return sort.getThreeClosest(byArea);
	        
		 }catch(Exception ex) {
			 ex.printStackTrace();
			 
		 }
		
		return null;
	}

	
	
}
