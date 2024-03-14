package racingcar.domain;

import racingcar.exception.NegativeInitialDistanceException;

import java.util.Objects;

public class Distance {

    private int distance;

    public Distance() {
        this.distance = 0;
    }

    // Constructor for UnitTest
    public Distance(int initValue) {
        if (isNegative(initValue)) {
            throw new NegativeInitialDistanceException(initValue);
        }
        this.distance = initValue;
    }

    private boolean isNegative(int initValue) {
        return initValue < 0;
    }

    public void increase() {
        this.distance++;
    }

    public int get() {
        return this.distance;
    }

    public boolean greaterThan(Distance distance) {
        return this.distance >= distance.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Distance distance1 = (Distance) o;
        return distance == distance1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
