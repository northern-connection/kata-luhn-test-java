package luhn_test;

import java.util.ArrayList;
import java.util.List;

public class LuhnTest {
    public static boolean isValid(String digits) {
        String reversedDigits = new StringBuilder(digits).reverse().toString();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < reversedDigits.length() ; i++) {
            String digit = reversedDigits.substring(i, i + 1);
            numbers.add(Integer.parseInt(digit));
        }

        List<Integer> odds = new ArrayList<>();
        for (int i = 0; i < numbers.size() ; i++) {
            int pos = i + 1;
            if (pos % 2 != 0) {
                odds.add(numbers.get(i));
            }
        }

        int acum = 0;
        for (Integer odd : odds) {
            acum += odd;
        }

        return acum % 10 == 0;
    }
}
