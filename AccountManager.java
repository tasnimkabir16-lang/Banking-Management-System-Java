
package bankofaasr;


import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    private  ArrayList<Account> accounts = new ArrayList<>();
    private  int accountCounter = 1001;  

   
    public  Account createAccount(String ownerName, double initialDeposit) {
        Account account = new Account(accountCounter++, ownerName, initialDeposit);
        accounts.add(account);  
        return  account;
    }


    public  Account getAccount(int accountId) {
        for (Account account : accounts) {
            if (account.getAccountId() == accountId) {
                return  account;
            }
        }
        return null;  
    }
 public  List<Account> getAllAccounts() {
        return accounts;
    }
    

   
}
