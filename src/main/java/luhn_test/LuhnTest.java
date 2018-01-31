package luhn_test;

public class LuhnTest {
    public static boolean isValid(String digits) {
        String reversedDigits = new StringBuilder(digits).reverse().toString();

        int firstDigit = Integer.parseInt(reversedDigits.substring(0, 1));

        return firstDigit % 10 == 0;
    }
}
