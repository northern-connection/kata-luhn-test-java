package luhn_test;

import java.util.ArrayList;
import java.util.List;

public class LuhnTest {
    public static boolean isValid(String digits) {
        String reversedDigits = reverseDigits(digits);
        List<Integer> numbers = getNumbers(reversedDigits);
        List<Integer> odds = filterOdds(numbers);
        List<Integer> evens = filterEvens(numbers);
        List<Integer> evensByTwo = multiplyByTwo(evens);

        int acum = sum(odds) + reduceNumber(evensByTwo.get(0))  + reduceNumber(evensByTwo.get(1));

        return acum % 10 == 0;
    }

    private static int reduceNumber(int number) {
        return number % 10 + number / 10;
    }

    private static List<Integer> multiplyByTwo(List<Integer> evens) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < evens.size() ; i++) {
            numbers.add(evens.get(i) * 2);
        }
        return numbers;
    }

    private static String reverseDigits(String digits) {
        return new StringBuilder(digits).reverse().toString();
    }

    private static int sum(List<Integer> numbers) {
        int acum = 0;
        for (Integer number : numbers) {
            acum += number;
        }
        return acum;
    }

    private static List<Integer> filterOdds(List<Integer> numbers) {
        List<Integer> odds = new ArrayList<>();
        for (int i = 0; i < numbers.size() ; i++) {
            int pos = i + 1;
            if (pos % 2 != 0) {
                odds.add(numbers.get(i));
            }
        }
        return odds;
    }

    private static List<Integer> filterEvens(List<Integer> numbers) {
        List<Integer> evens = new ArrayList<>();
        for (int i = 0; i < numbers.size() ; i++) {
            int pos = i + 1;
            if (pos % 2 == 0) {
                evens.add(numbers.get(i));
            }
        }
        return evens;
    }

    private static List<Integer> getNumbers(String digits) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < digits.length() ; i++) {
            String digit = digits.substring(i, i + 1);
            numbers.add(Integer.parseInt(digit));
        }
        return numbers;
    }
}
