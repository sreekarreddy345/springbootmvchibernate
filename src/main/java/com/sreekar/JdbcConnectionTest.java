/*
package com.sreekar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcConnectionTest {

    public static void main(String[] args) throws Exception {
        String username = "xglmhsdz";
        String password = "PdfaOxQmkLpXxcp9EPZFljg_5vTbi6aQ";
        String url = "jdbc:postgresql://xglmhsdz:PdfaOxQmkLpXxcp9EPZFljg_5vTbi6aQ@salt.db.elephantsql.com:5432/xglmhsdz";
        Class.forName("org.postgresql.Driver").newInstance();
        Connection con = DriverManager.getConnection(url, username, password);
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("select sysdate from dual");
        if (resultSet.next()) {
            System.out.println(resultSet.getObject(1));
        }
        resultSet.close();
        statement.close();
        con.close();
    }
}
*/
