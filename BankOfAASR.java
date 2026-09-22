
package bankofaasr;

  
import java.util.*;


public class BankOfAASR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountManager accountManager = new AccountManager();
        Admin admin = new Admin();

        while (true) {
            try{
            System.out.println("\n--- Banking Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Account Details");
            System.out.println("5. View All Accounts (Admin)");
            System.out.println("6. Delete Account (Admin)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter owner name: ");
                    scanner.nextLine(); 
                    String ownerName = scanner.nextLine();
                    
                    System.out.print("Enter initial deposit: ");
                    
                    double initialDeposit = scanner.nextDouble();
                    if (initialDeposit < 0) {
                        System.out.println("Initial deposit cannot be negative.");
                    } else {
                        Account account = accountManager.createAccount(ownerName, initialDeposit);
                        System.out.println("Account created successfully. Your Account ID: " + account.getAccountId());
                    }
                    break;
                case 2:
                    System.out.print("Enter account ID: ");
                    
                    int depositAccountId = scanner.nextInt();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount < 0) {
                        System.out.println("Deposit amount cannot be negative.");
                    } else {
                        Account depositAccount = accountManager.getAccount(depositAccountId);
                        if (depositAccount != null) {
                            depositAccount.deposit(depositAmount);
                            System.out.println("Deposit successful. New Balance: " + depositAccount.getBalance());
                        } else {
                            System.out.println("Account not found.");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter account ID: ");
                    int withdrawAccountId = scanner.nextInt();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount < 0) {
                        System.out.println("Withdrawal amount cannot be negative.");
                    } else {
                        Account withdrawAccount = accountManager.getAccount(withdrawAccountId);
                        if (withdrawAccount != null) {
                            if (withdrawAccount.withdraw(withdrawAmount)) {
                                System.out.println("Withdrawal successful. Remaining Balance: " + withdrawAccount.getBalance());
                            } else {
                                System.out.println("Insufficient balance.");
                            }
                        } else {
                            System.out.println("Account not found.");
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter account ID: ");
                    int viewAccountId = scanner.nextInt();
                    Account viewAccount = accountManager.getAccount(viewAccountId);
                    if (viewAccount != null) {
                        System.out.println("Account ID: " + viewAccount.getAccountId());
                        System.out.println("Owner Name: " + viewAccount.getOwnerName());
                        System.out.println("Balance: " + viewAccount.getBalance());
                        System.out.println("Transaction History: ");
                        viewAccount.displayTransactionHistory();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter admin password: ");
                    scanner.nextLine(); 
                    String adminPassword = scanner.nextLine();
                    if (admin.validatePassword(adminPassword)) {
                        admin.displayAllAccounts(accountManager.getAllAccounts());
                    } else {
                        System.out.println("Incorrect admin password.");
                    }
                    break;
                case 6:
                    System.out.print("Enter account ID to delete: ");
                    int deleteAccountId = scanner.nextInt();
                    System.out.print("Enter admin password: ");
                    scanner.nextLine(); 
                    String deletePassword = scanner.nextLine();
                    if (admin.validatePassword(deletePassword)) {
                        Account deleteAccount = accountManager.getAccount(deleteAccountId);
                        if (deleteAccount != null) {
                            admin.removeAccount(deleteAccount);
                            System.out.println("Account with ID " + deleteAccountId + " has been deleted successfully.");
                        } else {
                            System.out.println("Account not found.");
                        }
                    } else {
                        System.out.println("Incorrect admin password.");
                    }
                    break;
                case 7:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }}catch(InputMismatchException e){
                System.out.println("Use Digit only");
                scanner.nextLine();
            }
        
    }
}}

    

