/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skycraft.hotel.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


    public class MaConnexion {
    public String url="jdbc:mysql://localhost:3306/esprit3A9";
    public String user="zeineb";
    public String pwd="zeineb";
    public static MaConnexion macn;
    private Connection cnx;
    private MaConnexion(){
        try {
            cnx=DriverManager.getConnection(url, user, pwd);
            System.out.println("Connexion etablie");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static MaConnexion getInstance(){
        if(macn!=null) {
        } else {
            macn= new MaConnexion();
        }
            return macn;
      
    }

    public Connection getCnx() {
        return cnx;
    }
    
}
