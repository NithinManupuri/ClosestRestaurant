package in.spring.dto;


import lombok.Data;


@Data
public class RestaurantDistance {
	
	
	private String restaurantName;
	private String location;
	private String area;
	private Double longitude;
	private Double latitude;
	private Long phNo;
     private Double distance;

     public RestaurantDistance() {
        
     }

    

}
