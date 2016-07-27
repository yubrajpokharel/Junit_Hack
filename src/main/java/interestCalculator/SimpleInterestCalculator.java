package interestCalculator;

/**
 * Created by yubraj on 7/26/16.
 */
public class SimpleInterestCalculator implements InterestCalculator {
    private double rate;

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double calculate(double amount, double year) {
        if(amount < 0 || year < 0)
            throw new IllegalArgumentException("Amount or Year must be positive");
        return amount * year * rate;
    }
}
