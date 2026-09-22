
package bankofaasr;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
   private int accountId;
    private String ownerName;
    private double balance;
    private List<String> transactionHistory;
    private final Lock lock = new ReentrantLock();

    public Account(int accountId, String ownerName, double initialDeposit) {
        this.accountId = accountId;
        this.ownerName = ownerName;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        recordTransaction("Account created with initial deposit of " + initialDeposit);
    }

    public int getAccountId() {
        return accountId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        lock.lock(); 
        try {
            balance += amount;
            recordTransaction("Deposited " + amount);
        } finally {
            lock.unlock(); 
        }
    }

    public boolean withdraw(double amount) {
        lock.lock();  
        try {
            if (amount > balance) {
                return false;
            }
            balance -= amount;
            recordTransaction("Withdrew " + amount);
            return true;
        } finally {
            lock.unlock();  
        }
    }

    public void recordTransaction(String transaction) {
        transactionHistory.add(transaction);
    }

    public void displayTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
}

