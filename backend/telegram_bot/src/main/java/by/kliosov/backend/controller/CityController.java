package by.kliosov.backend.controller;

import by.kliosov.backend.model.City;
import by.kliosov.backend.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/delete/{cityId}", method = RequestMethod.DELETE)
    public void deleteCity(@PathVariable(name = "cityId") Long cityId){
        cityService.deleteCity(cityId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<City> getAllCities(){
        return cityService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public City saveCity(@RequestBody City city){
        return cityService.saveCity(city);
    }
}
