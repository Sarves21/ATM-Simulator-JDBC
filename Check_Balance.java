package ATMJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Check_Balance {
    // Method to check the balance
    void checkBalance(int accountNumber) {
        try {
            // Get connection from DatabaseConnector
            Connection connection = DatabaseConnector.getConnection();

            // Prepare SQL query to fetch balance from accounts table
            String query = "SELECT balance FROM accounts WHERE account_number = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, accountNumber);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Check if result set has data
            if (resultSet.next()) {
                int balance = resultSet.getInt("balance");
                System.out.println("Current balance: " + balance);
            } else {
                System.out.println("Error: Account not found.");
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
