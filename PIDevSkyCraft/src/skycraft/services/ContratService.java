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
import skycraft.entities.Contrat;
import skycraft.entities.enums.type;
import skycraft.tools.MaConnexion;
import skycraft.entities.enums.poste;

/**
 *
 * @author sinad
 */
public class ContratService {
      Connection cnx;
    PreparedStatement ste;

    public ContratService() {
        cnx = MaConnexion.getInstance().getCnx();
    }
 public void ajouterContrat(Contrat contrat) {
        String sql = "insert into contrat (id,type,poste,duree_contrat )  Values(?,?,?,?)";
        try {
            ste = cnx.prepareStatement(sql);
           // ste.setInt(1, contrat.getId_contrat());
             ste.setInt(1, contrat.getId());
            ste.setString(2, contrat.getType().toString());
            ste.setString(3, contrat.getPoste().toString());
            ste.setInt(4, contrat.getDuree_contrat());
            ste.executeUpdate();
            System.out.println("Contrat Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
  public List<Contrat> afficherContrat() {
        List<Contrat> Contrat = new ArrayList<>();
        String sql = "select * from contrat";
        try {
            ste = cnx.prepareStatement(sql);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                  Contrat cn=new Contrat();
                           cn.setId_contrat(rs.getInt("id_contrat"));
                            cn.setId(rs.getInt("id"));
                            cn.setType(type.valueOf(rs.getString("type")));
                             cn.setPoste(poste.valueOf(rs.getString("poste")));
                cn.setDuree_contrat(rs.getInt("duree_contrat"));
                        Contrat.add(cn);
            }
            return Contrat;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return Contrat;
    }
    public boolean ModifierContrat(Contrat contrat){
           String sql = "UPdate contrat set id=?, type=?,poste=? ,duree_contrat=? where id_contrat=? ";
        try {
            ste = cnx.prepareStatement(sql);
         
             ste.setInt(1, contrat.getId());
            ste.setString(2, contrat.getType().toString());
            ste.setString(3, contrat.getPoste().toString());
            ste.setInt(4, contrat.getDuree_contrat());
            ste.setInt(5, contrat.getId_contrat());
             ste.executeUpdate();
            System.out.println(ste);
            
            if (ste.executeUpdate()>0){
                System.out.println("Contrat modifier");
                 return true;
            }else{
                System.out.println("contrat non modifier");
                return false;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

} public void supprimerContrat(int id_contrat){
        String sql = "delete from contrat where id_contrat=? ";
        try {
            ste = cnx.prepareStatement(sql);
            ste.setInt(1,id_contrat);
            ste.executeUpdate();
            System.out.println(ste);
            System.out.println("Contrat supprimer");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           
        }

//    }public List<Contrat> Recherche(int id_contrat) {
//        List<Contrat> myList = new ArrayList<>();
//
//        try {
//            String sql = "SELECT * From contrat  where id like '%" + id_contrat + "%'";
//           ste=cnx.prepareStatement(sql);
//            ResultSet rs = ste.executeQuery(sql);
//            while (rs.next()) {
//                Contrat contrat = new Contrat();
//                      contrat.setId_contrat(rs.getInt("id_contrat"));
//                            contrat.setId(rs.getInt("id"));
//                            contrat.setType(type.valueOf(rs.getString("type")));
//                            contrat.setPoste(poste.valueOf(rs.getString("poste")));
//                contrat.setDuree_contrat(rs.getInt("duree_contrat"));
//                
//
//                myList.add(contrat);
//
//            }
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//
//        }
//        return myList;

    }
//  public ResultSet AfficherContratFiltre(int keyword) {
//        try {
//            String sql = "SELECT * FROM contrat WHERE duree_contrat LIKE '%" + keyword + "%'";
//            ste= (PreparedStatement) cnx.createStatement();
//            ResultSet rs = ste.executeQuery(sql);
//            return rs;
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            return null;
//        }
//    }
//    public List<Evenement> trierEvenement(){
//        List<Evenement> evenement = new ArrayList<>();
//        String sql="select * from evenement ORDER BY id DESC";
//        try {
//           ste=cnx.prepareStatement(sql);
//            ResultSet rs = ste.executeQuery(sql);
//           while(rs.next()){
//               Evenement e = new Evenement();
//                e.setId(rs.getInt("id"));
//                e.setdetail(rs.getString("detail"));
//                e.setcommentaire(rs.getString("commentaire"));
//                e.setdate_debut(rs.getString("date_debut"));
//                e.setdate_fin(rs.getString("date_fin"));
//               
//                
//
//               evenement.add(e);
//               System.out.println(e.toString());
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        
//        return evenement;
//    }
}