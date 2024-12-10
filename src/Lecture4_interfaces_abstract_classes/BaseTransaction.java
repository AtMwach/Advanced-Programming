package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

// TransactionInterface should be defined elsewhere
public class BaseTransaction implements TransactionInterface {
    private final int amount;
    private final Calendar date;
    private final String transactionID;

    /**
     * Constructor
     *
     * @param amount The transaction amount
     * @param date   The transaction date (must not be null)
     */
    public BaseTransaction(int amount, @NotNull Calendar date) {
        this.amount = amount;
        this.date = (Calendar) date.clone();
        int uniq = (int) (Math.random() * 10000); // Ensure correct random generation
        transactionID = date.toString() + uniq;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public Calendar getDate() {
        return (Calendar) date.clone(); // Defensive copying
    }

    @Override
    public String getTransactionID() {
        return transactionID;
    }

    // Added concrete implementation
    @Override
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date.getTime());
    }

    // Base implementation of the apply method
    @Override
    public void apply(BankAccount ba) {
        System.out.println("BaseTransaction applied on BankAccount.");
        // Placeholder logic for applying a transaction

}
