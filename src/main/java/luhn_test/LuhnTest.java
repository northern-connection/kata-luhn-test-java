package luhn_test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class LuhnTest {
    public static boolean isValid(String digits) {
        String reversedDigits = reverseDigits(digits);
        List<Integer> numbers = getNumbers(reversedDigits);
        List<Integer> numbersAtOddPositions = extractNumbersAtPositions((pos) -> pos % 2 != 0, numbers);
        List<Integer> numbersAtEvenPositions = extractNumbersAtPositions((pos) -> pos % 2 == 0, numbers);
        List<Integer> numbersAtEvenPositionsByTwo = multiplyByTwo(numbersAtEvenPositions);
        List<Integer> reducedNumbersAtEvenPositions = reduceToOneDigitNumbers(numbersAtEvenPositionsByTwo);

        int result = sum(numbersAtOddPositions) + sum(reducedNumbersAtEvenPositions);

        return result % 10 == 0;
    }

    private static List<Integer> reduceToOneDigitNumbers(List<Integer> numbers) {
        return numbers.stream().map(n -> n % 10 + n / 10).collect(Collectors.toList());
    }

    private static List<Integer> multiplyByTwo(List<Integer> numbers) {
        return numbers.stream().map(n -> n * 2).collect(Collectors.toList());
    }

    private static String reverseDigits(String digits) {
        return new StringBuilder(digits).reverse().toString();
    }

    private static int sum(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
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
