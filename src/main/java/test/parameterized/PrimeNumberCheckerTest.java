package test.parameterized;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parametirized.PrimeNumberChecker;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by yubraj on 7/27/16.
 */

@RunWith(Parameterized.class)
public class PrimeNumberCheckerTest {
    private Integer inputNumber;
    private boolean expectedResult;
    private PrimeNumberChecker primeNumberChecker;

    public PrimeNumberCheckerTest(Integer inputNumber, boolean expectedResult) {
        this.inputNumber = inputNumber;
        this.expectedResult = expectedResult;
    }

    @Before
    public void init(){
        primeNumberChecker = new PrimeNumberChecker();
    }

    @Parameterized.Parameters
    public static Collection primeNumbers(){
        return Arrays.asList(new Object[][] {
                {2, true}, {3, true}, {6, false}, {20, false}, {31, true}
        });
    }

    @Test
    public void testPrimeNumber(){
        assertEquals(expectedResult, primeNumberChecker.validate(inputNumber));
    }




}
