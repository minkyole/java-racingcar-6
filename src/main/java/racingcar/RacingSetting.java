package racingcar;

import java.util.Arrays;

public class RacingSetting {
    private MoveNum moveNum;

    private final static int MAX_CAR_NUM = 10;

    String[] getCarName() {
        String inputCarName;
        String[] parsedCarName;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputCarName = Util.getUserInput();
        isVaildInputCarName(inputCarName);
        parsedCarName = inputCarName.split(",");
        isDuplicatedInputCarName(parsedCarName);
        isValidCarNum(parsedCarName);
        return (parsedCarName);
    }

    void getMoveNum() {
        String inputMoveNum;

        System.out.println("시도할 회수는 몇회인가요?");
        inputMoveNum = Util.getUserInput();
        moveNum = new MoveNum(inputMoveNum);
    }

    private void isVaildInputCarName(String inputCarName) throws IllegalArgumentException {
        if (inputCarName.matches(".*,,.*|.*,+$|^,.*")) {
            throw new IllegalArgumentException("Error : 자동차 이름이 없습니다 최소 한글자 이상 적어주세요");
        }
    }

    private void isDuplicatedInputCarName(String[] parsedCarName) throws IllegalArgumentException {
        if (Arrays.stream(parsedCarName)
                .distinct()
                .count() != parsedCarName.length) {
            throw new IllegalArgumentException("Error : 중복된 자동차 이름이 있습니다 중복되지않게 입력해 주세요");
        }
    }

    private void isValidCarNum(String[] carNameParsing) throws IllegalArgumentException {
        if (carNameParsing.length > MAX_CAR_NUM) {
            throw new IllegalArgumentException("Error : 자동차 개수가 너무 많습니다 최대개수 " + MAX_CAR_NUM);
        }
        if (carNameParsing.length == 1 && carNameParsing[0].isBlank()) {
            throw new IllegalArgumentException("Error : 자동차 개수가 너무 적습니다 최소 하나라도 입력해 주세요");
        }
    }

    boolean isInRange(int index) {
        return (moveNum.isInRange(index));
    }
}
