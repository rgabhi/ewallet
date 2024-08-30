package Learning.services;

import Learning.dao.AccountDao;
import Learning.models.Account;
import Learning.models.Transaction;
import Learning.models.User;
import Learning.utilities.AccountNumberGenerator;

import java.util.*;

public class AccountService {

    private AccountDao accountDao;

    public AccountService() {
        this.accountDao = new AccountDao();
    }

    public  void createAccount(User user, double amount) {
            Account account  = new Account(user, amount);
            accountDao.getAccounts().put(account.getAccountNumber(), account);
    }

    private boolean validateTransaction(Long fromAccountId, Long toAccountId, double amount){
        if(fromAccountId == null || toAccountId == null){
            System.out.println("Invalid transaction:\n Sender Account number or Receiver Account number is null");
            return false;
        }
        if(amount < 0.0001){
            System.out.println("Invalid transaction:\n Transaction amount too low");
            return false;
        }
        if(fromAccountId.equals(toAccountId)){
            System.out.println("Invalid transaction:\n " +
                    "Receiver Account number is the same as the sender account number");
            return false;
        }
        if(!accountDao.getAccounts().containsKey(fromAccountId)){
            System.out.println("Invalid transaction:\n " +
                    "Invalid sender account number");
            return false;
        }
        if(!accountDao.getAccounts().containsKey(toAccountId)){
            System.out.println("Invalid transaction:\n " +
                    "Invalid receiver account number");
            return false;
        }
        return true;
    }

    public void makeTransaction(Long fromAccountId, Long toAccountId, double amount) {
        if(!validateTransaction(fromAccountId, toAccountId, amount)){
            return;
        }
        Account fromAccount = accountDao.getAccounts().get(fromAccountId);
        Account toAccount = accountDao.getAccounts().get(toAccountId);
        if(fromAccount.getAmount() < amount){
            System.out.println("Insufficient sender balance");
            return;
        }
        Transaction transaction = new Transaction(fromAccountId, toAccountId, amount, new Date());
        fromAccount.setAmount(fromAccount.getAmount() - amount);
        toAccount.setAmount(toAccount.getAmount() + amount);
        fromAccount.getTransactions().add(transaction);
        toAccount.getTransactions().add(transaction);
        System.out.println("Transaction made");

    }

    public void getAccountStatement(Long accountNumber){
        Account account = accountDao.getAccounts().get(accountNumber);
        if(account == null){
            System.out.println("Account not found");
        }
        System.out.println("Summary for Account: " + account.getAccountNumber());
        System.out.println("Current Balance=" +  account.getAmount());
        System.out.println("===Transaction history===\n");
        System.out.println(account.getTransactions());

    }

    public void getOverview(){
        for(Long accountNumber : accountDao.getAccounts().keySet()){
            System.out.println("Current Balance from account: " +  accountNumber);
            System.out.println(accountDao.getAccounts().get(accountNumber).getAmount());
        }

    }

}
