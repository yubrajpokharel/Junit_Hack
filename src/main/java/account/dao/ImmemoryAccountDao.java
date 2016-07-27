package account.dao;

import account.Account;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yubraj on 7/27/16.
 */
public class ImmemoryAccountDao implements AccountDao {

    private Map<String, Account> accounts;

    public ImmemoryAccountDao() {
        this.accounts = Collections.synchronizedMap(new HashMap<String, Account>());
    }

    public boolean accountExists(String accountNo){
        return accounts.containsKey(accountNo);
    }

    public void createAccount(Account account) {
        if(accounts.containsKey(account.getAccountNo())){
            throw new IllegalArgumentException("Duplicate Account. Account already exist with the no : "+account.getAccountNo());
        }
        accounts.put(account.getAccountNo(), account);
    }

    public void updateAccount(Account account) {
        if(!accounts.containsKey(account.getAccountNo()))
            throw new IllegalArgumentException("Account not found exception");
        accounts.put(account.getAccountNo(), account);
    }

    public void removeAccount(Account account) {
        if(!accounts.containsKey(account.getAccountNo()))
            throw new IllegalArgumentException("Account not found exception");
        accounts.remove(account.getAccountNo());
    }

    public Account findAccount(String accountNo) {
        Account account = accounts.get(accountNo);
        if(account == null)
            throw new IllegalArgumentException("Account not found exception");
        return account;

    }
}
