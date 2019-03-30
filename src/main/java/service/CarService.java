package service;

import model.Car;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private Car car;

    public CarService() {
        car = new Car("Mercedes-Benz", "A 200");
    }

    public Car getCar() {
        return car;
    }
}
