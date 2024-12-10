import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.List;
import Lecture1_adt.*; // Import all classes from the Lecture1_adt package

// Client Code for accessing the Lecture1_adt.TransactionInterface.java module
public class Main {

    // Method to test Transaction1
    public static void testTransaction1() {
        Calendar d1 = new GregorianCalendar(); // d1 is an Object [Objects are Reference types]
        Lecture1_adt.Transaction1 t1 = new Lecture1_adt.Transaction1(1000, d1); // amount and d1 are arguments

        System.out.println(t1.toString());
        System.out.println("Lecture1_adt.TransactionInterface Amount: \t " + t1.amount);
        System.out.println("Lecture1_adt.TransactionInterface Date: \t " + t1.date);
    }

    // Method to test Transaction2
    public static Transaction2 makeNextPayment(Transaction2 t) {
        Calendar d = t.getDate();
        d.add(Calendar.MONTH, 1);
        return new Transaction2(t.getAmount(), d);
    }

    public static void testTransaction2() {
        Calendar d1 = new GregorianCalendar();
        Lecture1_adt.Transaction2 t = new Lecture1_adt.Transaction2(1000, d1);

        Lecture1_adt.Transaction2 modified_t = makeNextPayment(t);
        System.out.println("\n\nState of the Object T1 After Client Code Tried to Change the Amount");
        System.out.println("Lecture1_adt.TransactionInterface Amount: \t " + modified_t.getAmount());
        System.out.println("Lecture1_adt.TransactionInterface Date: \t " + modified_t.getDate().getTime());
    }

    // Method to create a list of Transaction3 objects
    public static List<Transaction3> makeYearOfPayments(int amount) throws NullPointerException {
        List<Transaction3> listOfTransaction3s = new ArrayList<Transaction3>();
        Calendar date = new GregorianCalendar(2024, Calendar.JANUARY, 3);

        for (int i = 0; i < 12; i++) {
            listOfTransaction3s.add(new Transaction3(amount, date));
            date.add(Calendar.MONTH, 1);
        }
        return listOfTransaction3s;
    }

    public static void testTransaction3() {
        List<Transaction3> allPaymentsIn2024 = makeYearOfPayments(1000);

        for (Transaction3 transact : allPaymentsIn2024) {
            System.out.println("\n\n  ::::::::::::::::::::::::::::::::::::::::::::\n");
            System.out.println("Lecture1_adt.TransactionInterface Amount: \t " + transact.getAmount());
            System.out.println("Lecture1_adt.TransactionInterface Date: \t " + transact.getDate().getTime());
        }
    }

    // Method to create a list of Transaction4 objects
    public static List<Transaction4> makeYearOfPaymentsFinal(int amount) throws NullPointerException {
        List<Transaction4> listOfTransaction4s = new ArrayList<Transaction4>();
        Calendar date = new GregorianCalendar(2024, Calendar.JANUARY, 3);

        for (int i = 0; i < 12; i++) {
            listOfTransaction4s.add(new Transaction4(amount, date));
            date.add(Calendar.MONTH, 1);
        }
        return listOfTransaction4s;
    }

    public static void testTransaction4() {
        List<Transaction4> transactionsIn2024 = makeYearOfPaymentsFinal(1200);

        for (Transaction4 transact : transactionsIn2024) {
            System.out.println("\n\n  ::::::::::::::::::::::::::::::::::::::::::::\n");
            System.out.println("Lecture1_adt.TransactionInterface Amount: \t " + transact.getAmount());
            System.out.println("Lecture1_adt.TransactionInterface Date: \t " + transact.getDate().getTime());
        }
    }

    // Testing DepositTransaction
    public static void testDepositTransaction() {
        DepositTransaction deposit = new DepositTransaction(500, new GregorianCalendar(2024, Calendar.JANUARY, 1));

        deposit.apply();
        System.out.println("Deposit applied: " + deposit.toString());

        Transaction transaction = (Transaction) deposit;
        transaction.apply();
        System.out.println("Deposit applied (via superclass reference): " + transaction.toString());
    }

    // Testing WithdrawalTransaction
    public static void testWithdrawalTransaction() {
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(200, new GregorianCalendar(2024, Calendar.FEBRUARY, 15));

        withdrawal.apply();
        System.out.println("Withdrawal applied: " + withdrawal.toString());

        Transaction transaction = (Transaction) withdrawal;
        transaction.apply();
        System.out.println("Withdrawal applied (via superclass reference): " + transaction.toString());
    }

    public static void main(String[] args) {
        // This is the client code
        // Uncomment the following lines to test the class you would like to test

        testTransaction1();
        testTransaction2();
        testTransaction3();
        testTransaction4();

        // Test DepositTransaction and WithdrawalTransaction
        testDepositTransaction();
        testWithdrawalTransaction();
    }
}
