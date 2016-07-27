package account.service;

import account.Account;

/**
 * Created by yubraj on 7/27/16.
 */
public interface AccountService {
    public void createAccount(String accountNo);
    public void removeAccount(String accountNo);
    public void deposit(String accountNo, double amount);
    public void withdraw(String accountNo, double amount);
    public double getBalance(String accountNo);
}
