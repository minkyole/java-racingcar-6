package racingcar;

public class Information {
    String name;
    int destination;

    Information(String name) {
        this.name = name;
        destination = 0;
    }

    void update() {
        destination++;
    }

    void print() {
        System.out.println(name + " : " + "-".repeat(destination));
    }
}
