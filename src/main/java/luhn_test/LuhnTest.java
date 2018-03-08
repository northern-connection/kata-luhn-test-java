package luhn_test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LuhnTest {
    public static boolean isValid(String digits) {
        String reversedDigits = reverseDigits(digits);
        List<Integer> numbers = getNumbers(reversedDigits);

        int oddPositionsContribution = extractNumbersAtPositions((pos) -> pos % 2 != 0, numbers).stream()
                .reduce(0, Integer::sum);

        int evenPositionsContribution = extractNumbersAtPositions((pos) -> pos % 2 == 0, numbers).stream()
                .map(n -> n * 2)
                .map(reduceToOneDigitNumber())
                .reduce(0, Integer::sum);

        return (oddPositionsContribution + evenPositionsContribution) % 10 == 0;
    }

    private static Function<Integer, Integer> reduceToOneDigitNumber() {
        return n -> n % 10 + n / 10;
    }

    private static String reverseDigits(String digits) {
        return new StringBuilder(digits).reverse().toString();
    }

    private static List<Integer> extractNumbersAtPositions(IntPredicate predicate, List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .map(i -> i+1)
                .filter(predicate)
                .mapToObj(i -> numbers.get(i-1))
                .collect(Collectors.toList());
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
