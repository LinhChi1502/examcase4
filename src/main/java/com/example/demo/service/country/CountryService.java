package com.example.demo.service.country;

import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService implements ICountryService {
    @Autowired
    private CountryRepo countryRepo;

    @Override
    public Iterable<Country> findAll() {
        return countryRepo.findAll();
    }

    @Override
    public Country findById(Integer id) {
        return countryRepo.findById(id).get();
    }

    @Override
    public void save(Country model) {
        countryRepo.save(model);
    }

    @Override
    public void remove(Integer id) {
        countryRepo.deleteById(id);
    }
}
