package luhn_test;

public class LuhnTest {
    public static boolean isValid(String digits) {
        String reversedDigits = new StringBuilder(digits).reverse().toString();

        int firstDigit = Integer.parseInt(reversedDigits.substring(0, 1));
        int thirdDigit = Integer.parseInt(reversedDigits.substring(2, 3));
        int fifthDigit = Integer.parseInt(reversedDigits.substring(4, 5));

        return (firstDigit + thirdDigit + fifthDigit) % 10 == 0;
    }
}
