package test.AccountTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by yubraj on 7/27/16.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
                        AccountServiceImplStubTest.class,
                        InMemoryAccountDaoTest.class
                    })
public class JunitTestSuite {
}
