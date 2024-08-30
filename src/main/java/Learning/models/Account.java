package Learning.models;

import Learning.utilities.AccountNumberGenerator;

import java.util.Set;
import java.util.TreeSet;

public class Account {
    private Long accountNumber;
    private User user;
    private double amount;
    private Set<Transaction> transactions;

    public Account(User user, double amount) {
        this.accountNumber = AccountNumberGenerator.generateAccountNumber();
        this.user = user;
        this.amount = amount;
        this.transactions = new TreeSet<>((a, b)->a.getDate().compareTo(b.getDate()));
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
