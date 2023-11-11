package carRacing.view;

import carRacing.domain.Car;
import java.util.List;

public class ResultView {

	private static final String HYPHEN = "-";
	private static final String COLON = ":";

	public void showResult(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(car.getCarName() + COLON + HYPHEN.repeat(car.getPosition()));
		}
		System.out.println();
	}

	public void showWinner(List<Car> winnerList) {
		for (Car winnerCar : winnerList) {
			System.out.print(winnerCar.getCarName() + " ");
		}
		System.out.println("가 최종 우승했습니다.");
	}
}