package in.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer restaurantId;
	private String restaurantName;
	private String location;
	private String area;
	private Double longitude;
	private Double latitude;
	private Long phNo;
	
	

}
