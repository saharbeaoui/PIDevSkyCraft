
package Services;

import entites.Client;
import connexion.Connexion;
import tools.MaConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientService {
    Connection mc;
    PreparedStatement ste;

    public ClientService() {
        mc=MaConnexion.getInstance().getCnx();
    }
    
    public void ajouterClient(Client C){
        String sql ="insert into client(nom,prenom,adresse_mail,nationalite) Values(?,?,?,?)";
        try {
            ste=mc.prepareStatement(sql);
            ste.setString(1, C.getNom());
            ste.setString(2, C.getPrenom());
            ste.setString(3, C.getAdresse_mail());
            ste.setString(4, C.getNationalite());
            
            ste.executeUpdate();
            System.out.println("Client ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    public List<Client> afficherClient(){
        List<Client> clients = new ArrayList<>();
        String sql="select * from client";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Client c = new Client();
                c.setId(rs.getInt("id"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setAdresse_mail(rs.getString("mail"));
                c.setNationalite(rs.getString("nationalite"));
                clients.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return clients;
    }    
}
