package account.dao;

import account.Account;

/**
 * Created by yubraj on 7/27/16.
 */
public interface AccountDao {
    public void createAccount(Account account);
    public void updateAccount(Account account);
    public void removeAccount(Account account);
    public Account findAccount(String accountNo);
}
