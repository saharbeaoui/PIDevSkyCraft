
package connexion;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connexion {
    static Connection cnx;
    static String url ="jdbc:mysql://localhost:3306/skycraft";
    static String user="root";
    static String pwd="";
    static Statement ste;

    public static void main(String[] args) {
        try {
            cnx=DriverManager.getConnection(url, user, pwd);
            System.out.println("Connexion etablie");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
}
