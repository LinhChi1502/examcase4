package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.service.city.CityService;
import com.example.demo.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CityController {
    @Autowired
    private CountryService countryService;
    @Autowired
    private CityService cityService;

    @GetMapping("")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        Iterable<City> cities = cityService.findAll();
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        City city = cityService.findById(id);
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        City city = cityService.findById(id);
        Iterable<Country> countries = countryService.findAll();
        modelAndView.addObject("city", city);
        modelAndView.addObject("countries", countries);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute City city) {
        ModelAndView modelAndView = new ModelAndView("home");
        cityService.save(city);
        Iterable<City> cities = cityService.findAll();
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create");
        Iterable<Country> countries = countryService.findAll();
        modelAndView.addObject("city", new City());
        modelAndView.addObject("countries", countries);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute City city) {
        ModelAndView modelAndView = new ModelAndView("home");
        cityService.save(city);
        Iterable<City> cities = cityService.findAll();
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("home");
        cityService.remove(id);
        Iterable<City> cities = cityService.findAll();
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }
}
