/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skycraft.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import skycraft.entities.Conge;
import skycraft.tools.MaConnexion;

/**
 *
 * @author sinad
 */
public class CongeService {
      Connection cnx;
    PreparedStatement ste;

    public CongeService() {
        cnx = MaConnexion.getInstance().getCnx();
    }
 public void ajouterConge(Conge conge) {
        String sql = "insert into conge (id,nb_jour,date_conge )  Values(?,?,?)";
        try {
            ste = cnx.prepareStatement(sql);
           // ste.setInt(1, contrat.getId_contrat());
             ste.setInt(1, conge.getId());
            ste.setInt(2, conge.getNb_jour());
            ste.setString(3, conge.getDate_conge());
            
            ste.executeUpdate();
            System.out.println("Conge Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
  public List<Conge> afficherConge() {
        List<Conge> Conge = new ArrayList<>();
        String sql = "select * from conge";
        try {
            ste = cnx.prepareStatement(sql);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                  Conge cn=new Conge();
                           cn.setId_conge(rs.getInt("id_conge"));
                            cn.setId(rs.getInt("id"));
                            cn.setNb_jour(rs.getInt("nb_jour"));
                             cn.setDate_conge(rs.getString("date_conge"));
                
                        Conge.add(cn);
            }
            return Conge;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return Conge;
    }
    public boolean ModifierConge(Conge conge){
           String sql = "UPdate conge set id=?, nb_jour=?,date_conge=?  where id_conge=? ";
        try {
            ste = cnx.prepareStatement(sql);
         
             ste.setInt(1, conge.getId());
             ste.setInt(2, conge.getNb_jour());
             ste.setString(3, conge.getDate_conge());
             ste.setInt(4, conge.getId_conge());
             ste.executeUpdate();
            System.out.println(ste);
            
            if (ste.executeUpdate()>0){
                System.out.println("Conge modifier");
                 return true;
            }else{
                System.out.println("conge non modifier");
                return false;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

} public void supprimerConge(int id_conge){
        String sql = "delete from conge where id_conge=? ";
        try {
            ste = cnx.prepareStatement(sql);
            ste.setInt(1,id_conge);
            ste.executeUpdate();
            System.out.println(ste);
            System.out.println("Conge supprimer");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           
        }
    
}}
