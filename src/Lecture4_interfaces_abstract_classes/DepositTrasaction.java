public class DepositTransaction extends BaseTransaction {

    // Constructor for DepositTransaction
    public DepositTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    // Check if the deposit amount is valid (positive)
    private boolean checkDepositAmount(int amt) {
        return amt >= 0; // Return true if amount is valid (positive), else false
    }

    // Apply the deposit to the bank account
    @Override
    public void apply(BankAccount ba) {
        // Validate the deposit amount before applying it
        if (!checkDepositAmount(getAmount())) {
            System.out.println("Invalid deposit amount: " + getAmount() + ". Deposit not applied.");
            return; // Early return if the deposit is invalid
        }

        double currentBalance = ba.getBalance();
        double newBalance = currentBalance + getAmount();
        ba.setBalance(newBalance);

        // Log the successful deposit
        System.out.println("Deposit of " + getAmount() + " applied. New Balance: " + newBalance);

        // **Irreversibility Factor**:
        // The absence of a reverse() method in this class means that once the deposit is applied, it cannot be undone. 
        // There is no way to reverse it, satisfying the constraint given in the assignment.
    }

    // Print transaction details for the deposit transaction
    @Override
    public void printTransactionDetails() {
        System.out.println("Deposit Transaction Details:");
        System.out.println("Transaction ID: " + getTransactionID());
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate().getTime());
    }
}
