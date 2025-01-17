package Lecture1_adt;

import java.util.Calendar;

/**
 * This Lecture1_adt.Transaction4 class ensures that both constructor arguments and method returns use defensive copying.
 * This prevents unintended side effects when dealing with reference types.
 */
public class Transaction4 {
    private final int amount;
    private final Calendar date;

    public Transaction4(int amount, Calendar date) {
        this.amount = amount;
        this.date = (Calendar) date.clone(); // Defensive copying for constructor arguments
    }

    public int getAmount() {
        return amount; // Value types like integers can be returned directly
    }

    public Calendar getDate() {
        return (Calendar) date.clone(); // Defensive copying ensures reference types are not altered externally
    }
}
