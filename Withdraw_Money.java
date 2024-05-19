package ATMJDBC;

import java.util.Scanner;

public class Withdraw_Money {
    public void withdraw(int accountNumber) {
        Scanner sc = new Scanner(System.in);
        int currentBalance = DatabaseConnector.getBalance(accountNumber);

        System.out.println("Enter the Withdraw Amount:");
        int withdrawAmount = sc.nextInt();

        if (withdrawAmount <= currentBalance) {
            // Calculate new balance
            int newBalance = currentBalance - withdrawAmount;

            // Update balance in the database
            boolean success = DatabaseConnector.updateBalance(accountNumber, newBalance);

            if (success) {
                System.out.println("Remaining Balance: " + newBalance);
                System.out.println("Withdrawal Successful!");
            } else {
                System.out.println("Failed to update balance. Please try again later.");
            }
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
}
