package in.spring.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.spring.entity.Restaurant;

@Repository
public interface RestaurnatRepo extends JpaRepository<Restaurant,Integer> {

	public List<Restaurant> findByArea(String area);
}
