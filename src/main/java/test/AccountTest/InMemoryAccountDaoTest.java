package test.AccountTest;

import account.Account;
import account.dao.ImmemoryAccountDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by yubraj on 7/27/16.
 */
public class InMemoryAccountDaoTest {
    private static final String EXISTING_ACCOUNT_NUMBER = "1234";
    private static final String NEW_ACCOUNT_NUMBER = "5678";

    private Account existingAccount;
    private Account newAccount;
    private ImmemoryAccountDao accountDao;

    @Before
    public void init(){
        existingAccount = new Account(EXISTING_ACCOUNT_NUMBER, 1000);
        newAccount = new Account(NEW_ACCOUNT_NUMBER, 2000);
        accountDao = new ImmemoryAccountDao();
        accountDao.createAccount(existingAccount);
    }


    @Test
    public void accountExists(){
        assertTrue(accountDao.accountExists(EXISTING_ACCOUNT_NUMBER));
        assertFalse(accountDao.accountExists(NEW_ACCOUNT_NUMBER));
    }

    @Test
    public void createNewAccount(){
        accountDao.createAccount(newAccount);
        assertEquals(accountDao.findAccount(NEW_ACCOUNT_NUMBER), newAccount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createDuplicateAccount(){
        accountDao.createAccount(existingAccount);
    }

    @Test
    public void updateExistingAccount(){
        existingAccount.setBalance(200);
        accountDao.updateAccount(existingAccount);
        assertEquals(accountDao.findAccount(EXISTING_ACCOUNT_NUMBER), existingAccount);
        assertEquals(200, existingAccount.getBalance(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateNotExistedAccount(){
        accountDao.updateAccount(newAccount);
    }

    @Test
    public void removeExistingAccount(){
        accountDao.removeAccount(existingAccount);
        assertFalse(accountDao.accountExists(EXISTING_ACCOUNT_NUMBER));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeNonExistedAccount(){
        accountDao.removeAccount(newAccount);
    }

    @Test
    public void findExistedAccount(){
        Account account = accountDao.findAccount(EXISTING_ACCOUNT_NUMBER);
        assertEquals(account, existingAccount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findNotExistedAccount(){
        accountDao.findAccount(NEW_ACCOUNT_NUMBER);
    }

}
