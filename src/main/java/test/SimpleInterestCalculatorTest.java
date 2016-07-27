package test;

import interestCalculator.InterestCalculator;
import interestCalculator.SimpleInterestCalculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by yubraj on 7/26/16.
 */
public class SimpleInterestCalculatorTest {
    private InterestCalculator interestCalculator;

    @Before
    public void init(){
        interestCalculator = new SimpleInterestCalculator();
        interestCalculator.setRate(0.05);
    }

    @Test
    public void calculate(){
        double interest = interestCalculator.calculate(1000, 2);
        assertEquals(interest, 100.0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalAmountCalculate(){
        interestCalculator.calculate(-1000, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalYearCalculate(){
        interestCalculator.calculate(1000, -2);
    }
}
