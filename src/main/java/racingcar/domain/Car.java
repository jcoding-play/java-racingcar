package racingcar.domain;

public class Car implements Comparable<Car> {
    private static final int INITIAL_POSITION = 0;
    private static final int MAXIMUM_LENGTH_OF_NAME = 5;
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;

    private final String name;
    private final Position position;

    Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = new Position(position);
    }

    public Car(String name) {
        this(name, INITIAL_POSITION);
    }

    private void validateName(final String name) {
        if (name.isBlank() || name.length() > MAXIMUM_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(
                    String.format("자동차의 이름은 공백이거나 %d자를 초과할 수 없습니다.", MAXIMUM_LENGTH_OF_NAME));
        }
    }

    public void move(int number) {
        if (number >= MINIMUM_NUMBER_TO_MOVE) {
            position.increase();
        }
    }

    public boolean isSamePosition(Car car) {
        return this.position.isMatchPosition(car.getPosition());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
    }

    @Override
    public int compareTo(Car other) {
        return position.compareTo(other.position);
    }
}
