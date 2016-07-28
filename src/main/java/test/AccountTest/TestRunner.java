package test.AccountTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by yubraj on 7/27/16.
 */
public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(JunitTestSuite.class);

        if(!result.wasSuccessful()) {
            System.out.println("Total Number of failure : "+result.getFailureCount());
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }else {

            System.out.println("Result was successful");
        }


    }
}
