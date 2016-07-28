package parametirized;

/**
 * Created by yubraj on 7/27/16.
 */
public class PrimeNumberChecker {
    public boolean validate(final Integer primeNumber){
        System.out.println(primeNumber);
        for (int i = 2; i < (primeNumber / 2); i++) {
            if(primeNumber % i == 0)
                return false;
        }
        return true;
    }
}
