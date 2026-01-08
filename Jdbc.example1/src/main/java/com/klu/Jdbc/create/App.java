package com.klu.Jdbc.create;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class App {

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/companydb",
                "root",
                "Ruthwika@25"
            );

            Statement stmt = con.createStatement();

            // Insert multiple employees for dept_id = 1
            stmt.executeUpdate(
                "INSERT INTO employee(emp_name, salary, dept_id) " +
                "VALUES('Ruthwika', 50000, 1)"
            );

            stmt.executeUpdate(
                "INSERT INTO employee(emp_name, salary, dept_id) " +
                "VALUES('Neelima', 45000, 1)"
            );

            stmt.executeUpdate(
                "INSERT INTO employee(emp_name, salary, dept_id) " +
                "VALUES('Anusha', 48000, 1)"
            );

            System.out.println(" Multiple employees inserted successfully");

            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
