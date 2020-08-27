/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

/**
 *
 * @author Joy-Laptp
 */
import java.io.File;
import java.sql.*;

public class DBConnect {

    private Connection conn = null;

    public DBConnect() {//or you can use a filename as a parameter
        try {
            
            String filename = (new File("HospitalDB.accdb")).getAbsolutePath();

            conn = DriverManager.getConnection("jdbc:ucanaccess://" + filename);

            System.out.println("Connection successful");
        } catch (SQLException ex) {
            System.out.println("got exception " + ex.getMessage());
        }

    }

    ResultSet queryTbl(String sqlStmt) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sqlStmt);
        
        return rs;
    }

    public void updateTbl(String update) throws SQLException {
        Statement stmt = conn.createStatement();
        
        stmt.execute(update);
        stmt.close();

    }

}
