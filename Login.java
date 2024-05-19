package ATMJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
        private int accountNumber; // Account number associated with the logged-in user

        public int getAccountNumber() {
                return accountNumber;
        }

        public void validate() {
                Scanner sc = new Scanner(System.in);

                while (true) {
                        System.out.println("Enter your username: ");
                        String username = sc.nextLine();

                        try {
                                Connection connection = DatabaseConnector.getConnection();
                                String query = "SELECT a.account_number, u.pin FROM users u INNER JOIN accounts a ON u.id = a.id WHERE u.username = ?";

                                PreparedStatement preparedStatement = connection.prepareStatement(query);
                                preparedStatement.setString(1, username);
                                ResultSet resultSet = preparedStatement.executeQuery();

                                if (resultSet.next()) {
                                        int storedAccountNumber = resultSet.getInt("account_number");
                                        int storedPin = resultSet.getInt("pin");

                                        System.out.println("Enter your PIN: ");
                                        int enteredPin = sc.nextInt();

                                        if (enteredPin == storedPin) {
                                                System.out.println("Logged in successfully! 🎉");
                                                accountNumber = storedAccountNumber;
                                                return;
                                        } else {
                                                System.out.println("Incorrect PIN! Please try again. 👎");
                                        }
                                } else {
                                        System.out.println("Username not found! Please try again.");
                                }
                        } catch (SQLException e) {
                                e.printStackTrace();
                        }
                }
        }
}
