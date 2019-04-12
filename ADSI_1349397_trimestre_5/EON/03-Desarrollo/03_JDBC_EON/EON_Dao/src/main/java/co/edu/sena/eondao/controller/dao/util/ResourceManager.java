/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.eondao.controller.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author EON_Project
 */
public class ResourceManager {
    private static final String EON_URL = "jdbc:mysql://192.168.2.46:4306/EON";
    private static final String EON_USER = "eon";
    private static final String EON_PASSWORD = "123456";

    public static synchronized Connection getConnection()
            throws SQLException {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(EON_URL, EON_USER, EON_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Failed to initialise JDBC driver");
            e.printStackTrace();
        }
        return conexion;
    }

    public static void close(Connection conec) {
        try {
            if (conec != null) {
                conec.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public static void close(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
