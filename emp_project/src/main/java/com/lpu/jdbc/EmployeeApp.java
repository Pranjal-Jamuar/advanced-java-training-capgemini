package com.lpu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeApp {

    private static Connection con;

    public static void createConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://localhost:5432/LPU";
        String user = "postgres";
        String password = "lilly@2808";

        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(url, user, password);

        System.out.println("Database connected");
    }

    public static void insertEmployee() throws SQLException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();
        sc.nextLine(); // consume newline

        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        String sql = "INSERT INTO employee (name, email, salary, phone) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setDouble(3, salary);
        ps.setString(4, phone);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Employee inserted successfully.");
        } else {
            System.out.println("Insert failed.");
        }

        sc.close();
    }
    
    public static void fetchEmployees() throws SQLException {
        Statement stm = con.createStatement();
        String sql = "SELECT id, name, email, salary, phone FROM employee";

        ResultSet rs = stm.executeQuery(sql);

        System.out.println("---- Employee Records ----");
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

    public static void closeConnection() throws SQLException {
        if (con != null) {
            con.close();
            System.out.println("Connection closed");
        }
    }

    public static void main(String[] args) {

        try {
            createConnection();
            insertEmployee();
            fetchEmployees();
            closeConnection();
            System.out.println("Program terminated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
