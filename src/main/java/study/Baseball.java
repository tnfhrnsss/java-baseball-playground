package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Baseball {
    private static int[] ANSWER_NUMBER;

    public static void main(String[] args) {
        getRandomNumber();
        Scanner scanner = new Scanner(System.in);
        inputNumber(scanner);
    }

    private static void inputNumber(Scanner scanner) {
        System.out.println("please typing numbers.");
        String str = scanner.next();

        List<String> numbers = Stream.of(str.split("")).collect(Collectors.toList());

        boolean isSuccess = false;
        if (validationInputNumber(numbers)) {
            isSuccess = checkNumber(scanner, numbers);
        }

        if (isSuccess) {
            System.out.println("Congratulation!");
        } else {
            inputNumber(scanner);
        }
    }

    private static boolean checkNumber(Scanner scanner, List<String> numbers) {
        int ballCount = getBallCount(numbers);
        if (ballCount > 0) {
            int strikeCount =  checkStrikeCount(numbers);
            System.out.println("strike : " + strikeCount + ", ball : " + (ballCount - strikeCount));
            return strikeCount == 3;
        }
        return false;
    }

    private static int getBallCount(List<String> numbers) {
        List ballList = new ArrayList();
        Arrays.stream(ANSWER_NUMBER).forEach(num -> {
            if (numbers.contains(String.valueOf(num))) {
                ballList.add(num);
            }
        });
        return ballList.size();
    }

    private static boolean validationInputNumber(List<String> digits) {
        return digits.size() == 3;
    }

    private static int checkStrikeCount(List<String> inputNumbers) {
        List targetNumbers = Arrays.stream(ANSWER_NUMBER).boxed().collect(Collectors.toList());

        List strike = new ArrayList();
        AtomicInteger index = new AtomicInteger();
        targetNumbers.forEach(number -> {
            if (String.valueOf(number).equals(inputNumbers.get(index.get()))) {
                strike.add(number);
            }
            index.incrementAndGet();
        });
        return strike.size();
    }

    private static void getRandomNumber() {
        int[] numbers = new int[3];
        for (int i = 0 ; i < 3; i++) {
            numbers[i] = (int)((Math.random()*10000)%10);
        }
        ANSWER_NUMBER = numbers;
        //Arrays.stream(ANSWER_NUMBER).forEach(aa -> System.out.println(aa));
    }
}
