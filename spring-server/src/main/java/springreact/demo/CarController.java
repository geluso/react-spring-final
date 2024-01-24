package springreact.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/cars")
public class CarController {
    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public @ResponseBody Iterable<Car> getAllCars() {
        return carRepository.findAll();
    }

    @PostMapping(consumes = "application/json")
    public @ResponseBody Car createCar(
            @RequestBody CreateCarNetworkRequestData data
    ) {
        Car car = new Car();
        car.year = data.year;
        car.make = data.make;
        car.model = data.model;
        carRepository.save(car);
        return car;
    }
}
