
package bankofaasr;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private String adminPassword = "admin123"; 

    public boolean validatePassword(String password) {
        return password.equals(adminPassword);
    }
     private ArrayList<Account> accounts = new ArrayList<>();
    public void removeAccount(Account account) {
        accounts.remove(account);  
    }

    public void displayAllAccounts(List<Account> accounts) {
        if (accounts.isEmpty()) {
            System.out.println("No accounts to display.");
        } else {
            for (Account account : accounts) {
                System.out.println("Account ID: " + account.getAccountId() + ", Owner: " + account.getOwnerName() + ", Balance: " + account.getBalance());
            }
        }
    }
}

