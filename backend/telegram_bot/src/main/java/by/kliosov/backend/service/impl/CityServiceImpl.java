package by.kliosov.backend.service.impl;

import by.kliosov.backend.model.City;
import by.kliosov.backend.repository.CityRepository;
import by.kliosov.backend.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City findByName(String name){
        return cityRepository.findByName(name);
    }

    @Override
    public City findByCityId(Long cityId){
        return cityRepository.findByCityId(cityId);
    }

    @Override
    public List<City> findAll(){
        return cityRepository.findAll();
    }

    @Override
    public void deleteCity(Long cityId){
        cityRepository.deleteById(cityId);
    }

    @Override
    public City saveCity(City city){
        return cityRepository.save(city);
    }
}
