package luhn_test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class LuhnTestTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "00000000000", true },
                { "00000000001", false },
                { "00000000901", true },
                { "00000010901", false },
                { "00000000040", false },
                { "00000001040", true },
                { "00000006080", true },
                { "49927398716", true },
                { "49927398717", false },
           });
    }

    private String fInput;

    private boolean fExpected;

    public LuhnTestTest(String input, boolean expected) {
        fInput= input;
        fExpected= expected;
    }

    @Test
    public void test() {
        assertThat(LuhnTest.isValid(fInput), is(fExpected));
    }
}
