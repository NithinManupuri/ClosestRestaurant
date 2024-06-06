package in.spring.mapApi;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.spring.dto.Coordinates;
import in.spring.dto.Response;


@Service
public class GeocodingService {

    private static final Logger logger = LoggerFactory.getLogger(GeocodingService.class);

   
    public List<Coordinates> getCoordinates(String address) {
        if (address == null || address.isEmpty()) {
            logger.error("Address cannot be null or empty");
            throw new IllegalArgumentException("Address cannot be null or empty");
        }

       
        

            
            	String apiKey="AIzaSyAkJ4dJe5yrFqHVDHze_Y6q8ECjzJ85H4Q";

                try {
                   
                    String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=" + apiKey;
                    RestTemplate restTemplate = new RestTemplate();

                     ResponseEntity<Response> response = restTemplate.getForEntity(url, Response.class);
                     
                     Response body = response.getBody();
                     System.out.println(body.toString());
                     List<Coordinates> list=new ArrayList();
                     Coordinates cord=new Coordinates();
                    Double lat= body.getResults()[0].getGeometry().getLocation().getLat();
                    Double lon=body.getResults()[0].getGeometry().getLocation().getLng();
                    System.out.println(lat);
                    cord.setLatitude(lat);
                    cord.setLongitude(lon);
                    list.add(cord);
                    return list;
              
            }catch(Exception ex) {
            	
            }
                return null;
         }
    }
      
  

