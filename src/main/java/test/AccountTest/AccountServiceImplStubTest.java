package test.AccountTest;

import account.Account;
import account.dao.AccountDao;
import account.service.AccountService;
import account.service.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by yubraj on 7/27/16.
 */
public class AccountServiceImplStubTest {
    private static final String TEST_ACCOUNT_NO = "1234";
    private AccountDaoStub accountDaoStub;
    private AccountService accountService;

    private class AccountDaoStub implements AccountDao{

        private String accountNo;
        private double balance;

        public void createAccount(Account account) {}
        public void removeAccount(Account account) {}

        public void updateAccount(Account account) {
            this.accountNo = account.getAccountNo();
            this.balance = account.getBalance();
        }

        public Account findAccount(String accountNo) {
            return new Account(this.accountNo, this.balance);
        }
    }

    @Before
    public void init(){
        accountDaoStub = new AccountDaoStub();
        accountDaoStub.accountNo = TEST_ACCOUNT_NO;
        accountDaoStub.balance = 100;
        accountService = new AccountServiceImpl(accountDaoStub);
    }

    @Test
    public void deposit(){
        accountService.deposit(TEST_ACCOUNT_NO, 100);
        assertEquals(accountDaoStub.accountNo, TEST_ACCOUNT_NO);
        assertEquals(accountDaoStub.balance, 200, 0);
    }

    @Test
    public void withDrawWithSufficientBalance(){
        accountService.withdraw(TEST_ACCOUNT_NO, 50);
        assertEquals(accountDaoStub.accountNo, TEST_ACCOUNT_NO);
        assertEquals(50, accountDaoStub.balance, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withDrawWithInsufficientBalance(){
        accountService.withdraw(TEST_ACCOUNT_NO, 200);
    }
}
