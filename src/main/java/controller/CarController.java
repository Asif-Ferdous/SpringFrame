package controller;

import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CarService;

@CrossOrigin
@RestController
@RequestMapping("/")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("hello")
    public Car getPerson() {
        return carService.getCar();
    }
}
