package by.kliosov.backend.repository;

import by.kliosov.backend.model.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
    @Query("select c from City c where c.name = :name")
    City findByName(String name);
    City findByCityId(Long cityId);
    List<City> findAll();
}
