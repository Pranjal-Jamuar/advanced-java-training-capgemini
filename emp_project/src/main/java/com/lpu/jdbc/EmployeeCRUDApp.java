package com.lpu.jdbc;

import java.sql.*;
import java.util.Scanner;

public class EmployeeCRUDApp {

    private static Connection con;
    private static Scanner sc = new Scanner(System.in);

    // 1️⃣ Connection
    public static void createConnection() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/LPU";
        String user = "postgres";
        String password = "lilly@2808";

        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(url, user, password);
        System.out.println("Database connected");
    }

    // 2️⃣ SAVE (INSERT) + FETCH
    public static void saveEmployee() throws SQLException {
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        String sql = "INSERT INTO employee (name, email, salary, phone) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setDouble(3, salary);
        ps.setString(4, phone);

        ps.executeUpdate();
        System.out.println("Employee inserted");

//        findAll(); // fetch after insert
    }

    // 3️⃣ UPDATE
    public static void updateEmployee() throws SQLException {
        System.out.print("Enter employee ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        String sql = "UPDATE employee SET salary = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setDouble(1, salary);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Employee updated" : "Employee not found");
    }

    // 4️⃣ DELETE
    public static void deleteEmployee() throws SQLException {
        System.out.print("Enter employee ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        String sql = "DELETE FROM employee WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        System.out.println(rows > 0 ? "Employee deleted" : "Employee not found");
    }

    // 5️⃣ FIND ALL
    public static void findAll() throws SQLException {
        String sql = "SELECT * FROM employee";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        System.out.println("\n---- Employee Records ----");
        while (rs.next()) {
            System.out.println(
                rs.getInt("id") + " | " +
                rs.getString("name") + " | " +
                rs.getString("email") + " | " +
                rs.getBigDecimal("salary") + " | " +
                rs.getString("phone")
            );
        }
    }

    // 6️⃣ FIND BY ID
    public static void findById() throws SQLException {
        System.out.print("Enter employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        String sql = "SELECT * FROM employee WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println(
                rs.getInt("id") + " | " +
                rs.getString("name") + " | " +
                rs.getString("email") + " | " +
                rs.getBigDecimal("salary") + " | " +
                rs.getString("phone")
            );
        } else {
            System.out.println("Employee not found");
        }
    }

    // 7️⃣ MAIN (Menu)
    public static void main(String[] args) {

        try {
            createConnection();

            int choice;
            do {
                System.out.println("""
                1. Save Employee
                2. Update Employee
                3. Delete Employee
                4. Find All Employees
                5. Find Employee By ID
                6. Exit
                """);

                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> saveEmployee();
                    case 2 -> updateEmployee();
                    case 3 -> deleteEmployee();
                    case 4 -> findAll();
                    case 5 -> findById();
                    case 6 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice");
                }

            } while (choice != 6);

            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
