/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//*package connexionskycraft;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnexionSkyCraft {
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
         try{ ste=cnx.createStatement();
              String query ="INSERT INTO `abscence` (`id_ab`,`date_ab`) VALUES ('1','14/02/2022')";
            ste=cnx.createStatement();
           ste.executeUpdate(query); 
           System.out.println("Abscence Ajoutée");
          /* String ="select * from abscence"; 
           ResultSet result=ste.executeQuery(sql);
           while(result.next()){
               int id =result.getInt("id");
               String nom=result.getString(2);
               String prenom= result.getString("prenom");
               System.out.println("ID : "+id+"\nNom : "+nom+"\nPrenom : "+prenom);
            */   
           //}
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
}
