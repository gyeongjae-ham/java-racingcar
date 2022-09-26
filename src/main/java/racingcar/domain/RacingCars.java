package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingCars of(String carNameText) {
        return new RacingCars(Arrays.stream(carNameText.split(","))
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public int size() {
        return cars.size();
    }

    public void race() {
        this.cars.forEach(Car::run);
    }

    public Winners pickWinners() {
        Collections.sort(cars);

        Car firstWinner = cars.get(0);

        List<Car> winners = cars.stream()
                .filter(car -> car.compareTo(firstWinner) == 0)
                .collect(Collectors.toList());

        return new Winners(winners);
    }

    public String showGraph(String figure) {
        return cars.stream()
                .map(car -> car.showGraph(figure))
                .collect(Collectors.joining("\n"));
    }

    public boolean contains(Car car) {
        return cars.contains(car);
    }
}
