package dao;

import java.sql.*;

public class ConnectionFactory {

    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/hospitaldb";
    private static String USER = "root";
    private static String PASSWORD = "felipedarosa123";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL + "?verifyServerCertificate=false"
                    + "&useSSL=false"
                    + "&requireSSL=false"
                    + "&USER=" + USER + "&password" + PASSWORD + "&serverTimezone=UTC");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void closeConnection(Connection conexao, PreparedStatement instrucao, ResultSet resultado) {
        if(resultado != null) {
            try {
                resultado.close();
                conexao.close();
                instrucao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else if (instrucao != null) {
            try {
                instrucao.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else{
            try{
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
