package ATMJDBC;

import java.util.Scanner;

public class Deposit_Money {
    public void deposit(int accountNumber) {
        Scanner sc = new Scanner(System.in);
        int currentBalance = DatabaseConnector.getBalance(accountNumber);

        System.out.println("Enter the Deposit Amount:");
        int depositAmount = sc.nextInt();

        if (depositAmount > 0) {
            int newBalance = currentBalance + depositAmount;
            boolean success = DatabaseConnector.updateBalance(accountNumber, newBalance);

            if (success) {
                System.out.println("Remaining Balance: " + newBalance);
                System.out.println("Deposit Successful!");
            } else {
                System.out.println("Failed to update balance. Please try again later.");
            }
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}
