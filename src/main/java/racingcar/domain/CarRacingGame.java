package racingcar.domain;

import java.util.LinkedList;
import java.util.List;

public class CarRacingGame {
    private final Cars cars;
    private final Round round;

    public CarRacingGame(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public List<RoundResult> race(NumberGenerator numberGenerator) {
        List<RoundResult> roundResults = new LinkedList<>();

        while (round.isPlayable()) {
            RoundResult roundResult = playRound(numberGenerator);
            roundResults.add(roundResult);
        }

        return roundResults;
    }

    public List<String> findWinners() {
        List<Car> carsAtMaxPosition = cars.findCarsAtMaxPosition();
        return findWinnerNamesBy(carsAtMaxPosition);
    }

    private RoundResult playRound(NumberGenerator numberGenerator) {
        RoundResult roundResult = new RoundResult();

        cars.moveCars(numberGenerator);
        round.decrease();

        roundResult.recordRoundResult(cars.getCars());
        return roundResult;
    }

    private List<String> findWinnerNamesBy(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .toList();
    }
}
