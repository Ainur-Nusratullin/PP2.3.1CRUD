package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceIml;

import java.util.Arrays;
import java.util.List;

@Controller
public class CarController {

    CarService carServiceIml = new CarServiceIml();

    @GetMapping(value = "/cars")
    public String printCars5(@RequestParam(value = "count", required = false)Integer count, Model model) {
        List<Car> cars = carServiceIml.getCar(count);
        model.addAttribute("cars", cars);
        return "cars";
    }

}
