package racingrefactoring.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingrefactoring.util.FactoryCar;

public class CarGroup {

  private final List<Car> cars;

  public CarGroup(String carNames) {
    this.cars = FactoryCar.createCars(carNames);
  }

  protected CarGroup(Car ... cars) {
    this.cars = List.of(cars);
  }

  public CarGroup moveCars(MoveStrategy moveStrategy) {
    cars.forEach(car -> car.move(moveStrategy));
    return this;
  }

  public List<Car> getCars() {
    return new ArrayList<>(cars);
  }

  public Winners findWinners() {
    Position maxPosition = findMaxPosition();

    return new Winners(cars.stream()
        .filter(car -> car.isMaxPosition(maxPosition))
        .collect(Collectors.toList()));
  }

  private Position findMaxPosition() {
    int maxPosition = cars.stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElse(0);

    return new Position(maxPosition);
  }
}