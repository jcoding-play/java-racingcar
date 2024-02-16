package racingcar.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    private static Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        return inputTemplate(INPUT_CAR_NAMES_MESSAGE);
    }

    public static String inputRound() {
        return inputTemplate(INPUT_ROUND_MESSAGE);
    }

    private static String inputTemplate(String inputMessage) {
        System.out.println(inputMessage);
        String input = scanner.nextLine();

        InputValidator.validate(input);
        return input;
    }
}
