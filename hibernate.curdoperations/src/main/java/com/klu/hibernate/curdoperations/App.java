package com.klu.hibernate.curdoperations;

import com.klu.model.Department;
import com.klu.model.Employee;
import com.klu.util.HibernateUtil;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {

    static SessionFactory factory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n------ MAIN MENU ------");
            System.out.println("1. Insert Employee");
            System.out.println("2. Display Employee");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertEmployee(sc);
                    break;
                case 2:
                    displayEmployee(sc);
                    break;
                case 3:
                    updateEmployee(sc);
                    break;
                case 4:
                    deleteEmployee(sc);
                    break;
                case 5:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        factory.close();
        sc.close();
    }

    // ---------- INSERT ----------
    private static void insertEmployee(Scanner sc) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Department Name: ");
        String deptname = sc.next();

        Department dept = new Department();
        dept.setDeptname(deptname);

        System.out.print("Enter Employee Name: ");
        String empname = sc.next();

        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee();
        emp.setEmpname(empname);
        emp.setEmpsalary(salary);
        emp.setDepartment(dept);

        session.persist(dept);
        session.persist(emp);

        tx.commit();
        session.close();

        System.out.println("Employee inserted successfully!");
    }

    // ---------- DISPLAY ----------
    private static void displayEmployee(Scanner sc) {

        Session session = factory.openSession();

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee emp = session.get(Employee.class, id);

        if (emp != null) {
            System.out.println("Employee ID : " + emp.getEmpid());
            System.out.println("Name        : " + emp.getEmpname());
            System.out.println("Salary      : " + emp.getEmpsalary());
            System.out.println("Department  : " + emp.getDepartment().getDeptname());
        } else {
            System.out.println("Employee not found!");
        }

        session.close();
    }

    // ---------- UPDATE ----------
    private static void updateEmployee(Scanner sc) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee emp = session.get(Employee.class, id);

        if (emp != null) {
            System.out.print("Enter new Salary: ");
            emp.setEmpsalary(sc.nextDouble());
            tx.commit();
            System.out.println("Salary updated successfully!");
        } else {
            System.out.println("Employee not found!");
            tx.rollback();
        }

        session.close();
    }

    // ---------- DELETE ----------
    private static void deleteEmployee(Scanner sc) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee emp = session.get(Employee.class, id);

        if (emp != null) {
            session.remove(emp);
            tx.commit();
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee not found!");
            tx.rollback();
        }

        session.close();
    }
}