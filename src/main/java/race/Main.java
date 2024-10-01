package race;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        String[] carNames = InputView.inputCarName();
        int tryCount = InputView.inputTryCount() - 1;

        CarRace carRace = new CarRace(carNames, tryCount, new CarForwardCheck());

        List<Car> cars = carRace.getCars();

        ResultView.output(carRace.getCars());
        while (carRace.checkTryCount()) {
            carRace.proceedRound();
            ResultView.output(carRace.getCars());
        }
    }
}
