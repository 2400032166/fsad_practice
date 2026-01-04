package com.klu.jdbc.example2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class App {

    public static void main(String[] args) {

        try {
            // 1️⃣ Connect to MySQL (no DB first)
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/",
                "root",
                "Ruthwika@25"
            );

            Statement stmt = con.createStatement();

            // 2️⃣ Create Database if not exists
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS companydb");

            // 3️⃣ Use Database
            stmt.executeUpdate("USE companydb");

            // 4️⃣ Create Department table
            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS department (" +
                "dept_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "dept_name VARCHAR(50))"
            );

            // 5️⃣ Create Employee table with Foreign Key
            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS employee (" +
                "emp_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "emp_name VARCHAR(50), " +
                "salary DOUBLE, " +
                "dept_id INT, " +
                "FOREIGN KEY (dept_id) REFERENCES department(dept_id))"
            );

            // 6️⃣ Insert Department
            stmt.executeUpdate(
                "INSERT INTO department(dept_name) VALUES('IT')"
            );

            // 7️⃣ Insert Multiple Employees
            stmt.executeUpdate(
                "INSERT INTO employee(emp_name, salary, dept_id) VALUES " +
                "('Ruthwika', 50000, 1), " +
                "('Neelima', 45000, 1), " +
                "('Anusha', 48000, 1)"
            );

            System.out.println(" Database, tables & data created successfully");

            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


