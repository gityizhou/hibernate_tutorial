package com.zhouyi.jdbc;
import java.sql.*;

public class TestJdbc {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false" +
                "&serverTimezone=UTC";
        String user = "root";
        String password = "zhouyi1992";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to db " + url);
            Connection conn = DriverManager.getConnection(url,user,password);
            System.out.println("connected to db");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
