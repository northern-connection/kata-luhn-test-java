package luhn_test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

public class LuhnTest {
    public static boolean isValid(String digits) {
        String reversedDigits = reverseDigits(digits);
        List<Integer> numbers = getNumbers(reversedDigits);
        List<Integer> numbersAtOddPositions = extractNumbersAtPositions((pos) -> pos % 2 != 0, numbers);
        List<Integer> numbersAtEvenPositions = extractNumbersAtPositions((pos) -> pos % 2 == 0, numbers);
        List<Integer> numbersAtEvenPositionsByTwo = multiplyByTwo(numbersAtEvenPositions);
        List<Integer> reducedNumbersAtEvenPositions = reduceNumbers(numbersAtEvenPositionsByTwo);

        int acum = sum(numbersAtOddPositions) + sum(reducedNumbersAtEvenPositions);

        return acum % 10 == 0;
    }

    private static List<Integer> reduceNumbers(List<Integer> numbers) {
        List<Integer> reduced = new ArrayList<>();
        for (int i = 0; i < numbers.size() ; i++) {
            reduced.add(reduceNumber(numbers.get(i)));
        }
        return reduced;
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

    private static List<Integer> extractNumbersAtPositions(IntPredicate predicate, List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.size() ; i++) {
            Integer pos = i + 1;
            if (predicate.test(pos)) {
                result.add(numbers.get(i));
            }
        }
        return result;
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
