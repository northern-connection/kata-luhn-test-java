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
                { "00000000000", true }
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
