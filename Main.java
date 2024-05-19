package ATMJDBC;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to ATM\nEnter your Details");
        Login login = new Login();
        login.validate();

        System.out.println("========MENU=========");
        System.out.println("1.Check Balance \n2.Withdraw Money \n3.Deposit money \n4.Exit");

        Check_Balance checkBalance = new Check_Balance();
        Withdraw_Money withdrawMoney = new Withdraw_Money();
        Deposit_Money depositMoney = new Deposit_Money();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("Select the Option");
                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        checkBalance.checkBalance(login.getAccountNumber());
                        break;
                    case 2:
                        withdrawMoney.withdraw(login.getAccountNumber());
                        break;
                    case 3:
                        depositMoney.deposit(login.getAccountNumber());
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Enter a valid option (1-4).");
                }
                System.out.println("========MENU=========");
                System.out.println("1.Check Balance \n2.Withdraw Money \n3.Deposit money \n4.Exit");
            }
        }
    }
}


