package ATMJDBC;

import java.sql.*;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/atm_database";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "sarvesvar";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static int getBalance(int accountNumber) {
        int balance = 0;
        String query = "SELECT balance FROM accounts WHERE account_number = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, accountNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                balance = resultSet.getInt("balance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return balance;
    }

    public static boolean updateBalance(int accountNumber, int newBalance) {
        String query = "UPDATE accounts SET balance = ? WHERE account_number = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, newBalance);
            preparedStatement.setInt(2, accountNumber);

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getBalance(String username) {
        int balance = 0;
        String query = "SELECT amount FROM users WHERE username = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                balance = resultSet.getInt("amount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return balance;
    }

    public static boolean updateBalance(String username, int newBalance) {
        String query = "UPDATE users SET amount = ? WHERE username = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, newBalance);
            preparedStatement.setString(2, username);

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
