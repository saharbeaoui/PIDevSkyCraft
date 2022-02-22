/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import entites.Chauffeur;
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


public class ChauffeurService {
    Connection mc;
    PreparedStatement ste;

    public ChauffeurService() {
        mc=MaConnexion.getInstance().getCnx();
    }
    
    public void ajouterChauffeur(Chauffeur C){
        String sql ="insert into chauffeur(nom_chauffeur,prenom_chauffeur,cin_chauffeur,num_tel_chauffeur,email_chauffeur,date_naissance_chauffeur,num_compte_bancaire) Values(?,?,?,?,?,?,?)";
        try {
            ste=mc.prepareStatement(sql);
            ste.setString(1, C.getNom_chauffeur());
            ste.setString(2, C.getPrenom_chauffeur());
            ste.setString(3, C.getCin_chauffeur());
            ste.setInt(4, C.getNum_tel_chauffeur());
            ste.setString(5, C.getEmail_chauffeur());
            ste.setString(6, C.getDate_naissance_chauffeur());
            ste.setString(7, C.getNum_compte_bancaire());
            
            ste.executeUpdate();
            System.out.println("Chauffeur ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    public List<Chauffeur> afficherChauffeur(){
        List<Chauffeur> chauffeurs = new ArrayList<>();
        String sql="select * from chauffeur";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Chauffeur c = new Chauffeur();
                c.setId_chauffeur(rs.getInt("id"));
                c.setNom_chauffeur(rs.getString("nom"));
                c.setPrenom_chauffeur(rs.getString("prenom"));
                c.setCin_chauffeur(rs.getString("cin"));
                c.setNum_tel_chauffeur(rs.getInt("Tel"));
                c.setEmail_chauffeur(rs.getString("Email"));
                c.setDate_naissance_chauffeur(rs.getString("Date"));
                c.setNum_compte_bancaire(rs.getString("num compte"));

                chauffeurs.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return chauffeurs;
    }    
}
