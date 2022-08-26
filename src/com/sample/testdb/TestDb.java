package com.sample.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/testdb")
public class TestDb extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //setup connection variable
        String user = "springstudent";
        String pass = "springstudent";
        String jdbcUrl = "jdbc:sqlserver://localhost;database=Web_customer_tracker";
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            PrintWriter out = resp.getWriter();
            out.println("connecting to DB"+jdbcUrl);
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(jdbcUrl,user,pass);
            out.println("Connection successful");
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
