package com.example.demo.service.city;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.repository.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService implements ICityService {
    @Autowired
    private CityRepo cityRepo;

    @Override
    public Iterable<City> findAll() {
        return cityRepo.findAll();
    }

    @Override
    public City findById(Integer id) {
        return cityRepo.findById(id).get();
    }

    @Override
    public void save(City model) {
        cityRepo.save(model);
    }

    @Override
    public void remove(Integer id) {
        cityRepo.deleteById(id);
    }
}
