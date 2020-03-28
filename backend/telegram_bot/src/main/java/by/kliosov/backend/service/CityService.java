package by.kliosov.backend.service;

import by.kliosov.backend.model.City;

import java.util.List;

public interface CityService {
    City findByName(String name);
    City findByCityId(Long cityId);
    List<City> findAll();
    void deleteCity(Long cityId);
    City saveCity(City city);
}
