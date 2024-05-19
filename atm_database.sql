-- Create Database
CREATE DATABASE atm_database;

-- Use the Database
USE atm_database;

-- Create Users Table
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    pin INT NOT NULL,
    amount INT NOT NULL
);

-- Create Accounts Table
CREATE TABLE accounts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_number INT NOT NULL,
    balance INT NOT NULL
);

-- Insert Sample Data into Users Table
INSERT INTO users (username, pin, amount) VALUES
('Sarves', 1234, 2000),
('Vengatesh', 5678, 1000),
('gokul', 9087, 7000);

-- Insert Sample Data into Accounts Table
INSERT INTO accounts (account_number, balance) VALUES
(1001, 2000),
(1002, 1000),
(1003, 7000);

SELECT * FROM users;
SELECT * FROM accounts;
