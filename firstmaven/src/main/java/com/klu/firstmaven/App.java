package com.klu.firstmaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class App {

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student1",
                "root",
                "Ruthwika@25"
            );

            Statement stmt = con.createStatement();

            String sql = "INSERT INTO student(name, age) VALUES('Ruthwika', 21)";
            stmt.executeUpdate(sql);

            System.out.println(" One student record inserted successfully");

            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
