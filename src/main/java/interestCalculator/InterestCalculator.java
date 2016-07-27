package interestCalculator;

/**
 * Created by yubraj on 7/26/16.
 */
public interface InterestCalculator {
    public void setRate(double rate);
    public double calculate(double amount, double year);
}
