package luhn_test;

public class LuhnTest {
    public static boolean isValid(String digits) {
        String reversedDigits = new StringBuilder(digits).reverse().toString();

        int acum = 0;
        for (int i = 0; i < reversedDigits.length() ; i++) {
            int pos = i + 1;
            if (pos % 2 != 0) {
                acum += Integer.parseInt(reversedDigits.substring(i, i + 1));
            }
        }

        return acum % 10 == 0;
    }
}
