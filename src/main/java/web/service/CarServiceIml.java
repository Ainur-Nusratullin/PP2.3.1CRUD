package web.service;
import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceIml implements CarService {

    private List<Car> carList = new ArrayList<>();

    public CarServiceIml() {
        carList.add(new Car("Ford", 1, "Yellow"));
        carList.add(new Car("Mazda", 2, "Blue"));
        carList.add(new Car("Lada", 3, "Red"));
        carList.add(new Car("Toyota", 4, "Green"));
        carList.add(new Car("Honda", 5, "Black"));
    }

    public List<Car> getCar(Integer count) {
        if (count == null || count >= 5) {
            return carList;
        } else {
            return carList.stream().limit(count).collect(Collectors.toList());
        }
    }
}
