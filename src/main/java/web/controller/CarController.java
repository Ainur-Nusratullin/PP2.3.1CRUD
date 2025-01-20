package web.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarController {

    private CarService carServiceIml;

    @Autowired
    public void setCarServiceIml(CarService carServiceIml) {
        this.carServiceIml = carServiceIml;
    }

    @GetMapping(value = "/cars")
    public String printCars5(@RequestParam(value = "count", required = false) Integer count, Model model) {
        List<Car> cars = carServiceIml.getCar(count);
        model.addAttribute("cars", cars);
        return "cars";
    }

}
