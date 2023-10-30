package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private Information information;
    Car (String name) {
        information = new Information(name);
    }

    void move() {
        if (moveSuccessfully()) {
            information.update();
        }
    }

    private boolean moveSuccessfully() {
        int speed;

        speed = Randoms.pickNumberInRange(0,9);
        return (speed >= 4);
    }

    void printInformation() {
        information.print();
    }

    String getName() {
        return (information.getName());
    }

    int getDestination() {
        return (information.getDestination());
    }
}
