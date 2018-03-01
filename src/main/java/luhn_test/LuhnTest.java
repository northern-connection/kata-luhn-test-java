package luhn_test;

import java.util.ArrayList;
import java.util.List;

public class LuhnTest {
    public static boolean isValid(String digits) {
        String reversedDigits = reverseDigits(digits);
        List<Integer> numbers = getNumbers(reversedDigits);
        List<Integer> odds = filterOdds(numbers);
        int acum = sum(odds) + (numbers.get(1) + numbers.get(3))*2;

        return acum % 10 == 0;
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

    private static List<Integer> getNumbers(String digits) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < digits.length() ; i++) {
            String digit = digits.substring(i, i + 1);
            numbers.add(Integer.parseInt(digit));
        }
        return numbers;
    }
}
