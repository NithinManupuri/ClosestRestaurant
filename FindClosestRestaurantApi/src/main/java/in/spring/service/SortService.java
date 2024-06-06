package in.spring.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import in.spring.dto.RestaurantDistance;
import in.spring.entity.Restaurant;

@Service
public class SortService {

    public List<RestaurantDistance> getThreeClosest(List<Restaurant> byArea, Double lat, Double lon) {
        List<RestaurantDistance> nearestDistances = new ArrayList<>();
       

        for (Restaurant obj : byArea) {
            Double distance = calculateDistance(obj.getLatitude(), obj.getLongitude(), lat, lon);
            RestaurantDistance r = new RestaurantDistance();
            BeanUtils.copyProperties(obj, r);
            r.setDistance(distance);
            nearestDistances.add(r);
        }

        Collections.sort(nearestDistances, Comparator.comparingDouble(RestaurantDistance::getDistance));

        return nearestDistances.subList(0, Math.min(3, nearestDistances.size()));
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Earth's radius in kilometers
        double latRad1 = Math.toRadians(lat1);
        double lonRad1 = Math.toRadians(lon1);
        double latRad2 = Math.toRadians(lat2);
        double lonRad2 = Math.toRadians(lon2);

        double dlat = latRad2 - latRad1;
        double dlon = lonRad2 - lonRad1;

        double a = Math.sin(dlat / 2) * Math.sin(dlat / 2) +
                   Math.cos(latRad1) * Math.cos(latRad2) *
                   Math.sin(dlon / 2) * Math.sin(dlon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
