package Learning.dao;

import Learning.models.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountDao {
    private  Map<Long, Account> accounts = new HashMap<Long, Account>();

    public Map<Long, Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(Map<Long, Account> accounts) {
        this.accounts = accounts;
    }
}
