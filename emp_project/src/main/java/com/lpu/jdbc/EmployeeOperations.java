package com.lpu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeOperations {

    private static Connection con;

    public static void createConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://localhost:5432/LPU";
        String user = "postgres";
        String password = "lilly@2808";

        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(url, user, password);
        System.out.println("Database connected");
    }

    public static void saveEmployee() throws SQLException {
        Statement stm = con.createStatement();
        String sql = "INSERT INTO employee (name, email, salary, phone) " +
                     "VALUES ('Rahul Jain', 'rahul.jain@lpu.in', 65000, '9000011111')";
        stm.executeUpdate(sql);
        System.out.println("Employee inserted");
    }
    public static void updateEmployee() throws SQLException {
        Statement stm = con.createStatement();
        String sql = "UPDATE employee SET salary = 72000 WHERE email = 'rahul.jain@lpu.in'";
        stm.executeUpdate(sql);
        System.out.println("Employee updated");
    }

    public static void deleteEmployee() throws SQLException {
        Statement stm = con.createStatement();
        String sql = "DELETE FROM employee WHERE email = 'rahul.jain@lpu.in'";
        stm.executeUpdate(sql);
        System.out.println("Employee deleted");
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
        con.close();
        System.out.println("Connection closed");
    }

    // MAIN
    public static void main(String[] args) {
        try {
            createConnection();   // one connection
            saveEmployee();
            updateEmployee();
            deleteEmployee();
            fetchEmployees();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

