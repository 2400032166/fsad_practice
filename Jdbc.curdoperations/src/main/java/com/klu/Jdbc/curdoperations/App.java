package com.klu.Jdbc.curdoperations;
import java.sql.*;
import java.util.Scanner;

public class App {

	static final String URL =
			"jdbc:mysql://localhost:3306/Curdjdbc?useSSL=false&allowPublicKeyRetrieval=true";
			static final String USER = "root";
			static final String PASSWORD = "Ruthwika@25";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 

        while (true) {
            System.out.println("\n--- STUDENT CRUD MENU ---");
            System.out.println("1. Insert Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: insertStudent(sc); break;
                case 2: displayStudents(); break;
                case 3: updateStudent(sc); break;
                case 4: deleteStudent(sc); break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // INSERT
    public static void insertStudent(Scanner sc) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Name: ");
            String name = sc.next();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            String sql = "INSERT INTO students VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setInt(3, age);

            pst.executeUpdate();
            System.out.println("Inserted Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DISPLAY
    public static void displayStudents() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

            String sql = "SELECT * FROM students";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\nID\tName\tAge");
            System.out.println("---------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getInt(1) + "\t" +
                    rs.getString(2) + "\t" +
                    rs.getInt(3)
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public static void updateStudent(Scanner sc) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.print("Enter Student ID to Update: ");
            int id = sc.nextInt();

            System.out.print("Enter New Name: ");
            String name = sc.next();

            System.out.print("Enter New Age: ");
            int age = sc.nextInt();

            String sql = "UPDATE students SET name=?, age=? WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setInt(2, age);
            pst.setInt(3, id);

            int rows = pst.executeUpdate();
            if (rows > 0)
                System.out.println("Updated Successfully!");
            else
                System.out.println("No record found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteStudent(Scanner sc) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.print("Enter Student ID to Delete: ");
            int id = sc.nextInt();

            String sql = "DELETE FROM students WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            int rows = pst.executeUpdate();
            if (rows > 0)
                System.out.println("Deleted Successfully!");
            else
                System.out.println("No record found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
