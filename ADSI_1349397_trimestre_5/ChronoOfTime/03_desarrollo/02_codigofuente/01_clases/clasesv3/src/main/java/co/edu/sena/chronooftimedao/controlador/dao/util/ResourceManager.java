/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.chronooftimedao.controlador.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 1349397
 */
public class ResourceManager {

    private final static String JDBC_URL = "jdbc:mysql://localhost:4306/COT";
    private final static String JDBC_USER = "root";
    private final static String JDBC_PASSWORD = "123456789";

    public static synchronized Connection getConnection() throws SQLException {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

        } catch (SQLException e) {
            System.out.println("Failed to initialise JDBC driver");
            e.printStackTrace();
        }

        return conexion;
    }

    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public static void close(PreparedStatement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
