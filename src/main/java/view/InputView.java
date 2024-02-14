package view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static Scanner scanner = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String input = scanner.nextLine();

        InputValidator.validateCarNames(input);
        return input;
    }
}