package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/car")
public class CarController {

    @RequestMapping("/info")       //localhost:8080/car/info?make=honda
    public String carInfo(@RequestParam String make, @RequestParam Integer year, Model model){
        model.addAttribute("make", make);
        model.addAttribute("year", year);
        return "car/car-info";
    }

    @RequestMapping("/info2")
    public String carInfo2(@RequestParam(value = "make", required = false, defaultValue = "Tesla") String make, @RequestParam Integer year, Model model){
        model.addAttribute("make", make);
        model.addAttribute("year", year);
        return "car/car-info";
    }

    @RequestMapping("/info/{make}/{year}")      //localhost:8080/car/info/honda/2019
    public String getCarInfo(@PathVariable String make, @PathVariable Integer year, Model model){
        model.addAttribute("make", make);
        model.addAttribute("year", year);
        return "car/car-info";
    }
}
