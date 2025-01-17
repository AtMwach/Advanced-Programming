package Lecture4_interfaces_abstract_classes;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {

        // Create a new bank account with an initial balance of 1000
        BankAccount account = new BankAccount(1000);

        // Create and execute a deposit transaction
        DepositTransaction deposit = new DepositTransaction(500, Calendar.getInstance(), "TX001");
        System.out.println("\nExecuting Deposit Transaction:");
        deposit.printTransactionDetails(); // Print details of the deposit
        deposit.apply(account); // Apply the deposit to the account
        System.out.println("Account balance after deposit: " + account.getBalance());

        // Create and execute a withdrawal transaction
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(200, Calendar.getInstance(), "TX002");
        System.out.println("\nExecuting Withdrawal Transaction:");
        withdrawal.printTransactionDetails(); // Print details of the withdrawal
        withdrawal.apply(account); // Apply the withdrawal to the account
        System.out.println("Account balance after withdrawal: " + account.getBalance());

        // Reverse the withdrawal transaction
        System.out.println("\nReversing Withdrawal Transaction:");
        if (withdrawal.reverse(account)) { // Attempt to reverse the withdrawal
            System.out.println("Withdrawal reversed successfully.");
        } else {
            System.out.println("Reversal failed due to insufficient balance.");
        }
        System.out.println("Account balance after reversal: " + account.getBalance());

        // Reverse the deposit transaction
        System.out.println("\nReversing Deposit Transaction:");
        if (deposit.reverse(account)) { // Attempt to reverse the deposit
            System.out.println("Deposit reversed successfully.");
        } else {
            System.out.println("Reversal failed due to insufficient balance.");
        }
        System.out.println("Account balance after deposit reversal: " + account.getBalance());
    }
}
