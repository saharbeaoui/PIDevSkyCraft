/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skycraft.services;

import skycraft.entities.Absence;


import skycraft.tools.MaConnexion;
import skycraft.entities.enums.etat_ab;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbsenceService {

    Connection cnx;
    PreparedStatement ste;

    public AbsenceService() {
        cnx = MaConnexion.getInstance().getCnx();
    }

    public void ajouterAbsence(Absence absence) {
        String sql = "insert into absence ( date_ab ,etat_ab)  Values(?,?)";
        try {
            ste = cnx.prepareStatement(sql);
            //ste.setInt(1, absence.getId_ab());
           //ste.setInt(2, absence.getId());
            ste.setDate(1, absence.getDate_ab());
            ste.setString(2, absence.getEtat_ab().toString());
            ste.executeUpdate();
            System.out.println("Absence Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
           

    public List<Absence> afficherAbsence() {
        List<Absence> Absence = new ArrayList<>();
        String sql = "select * from absence";
        try {
            ste = cnx.prepareStatement(sql);
            ResultSet rs = ste.executeQuery();
            while (rs.next()) {
                  Absence ab=new Absence();
                           ab.setId_ab(rs.getInt("id_ab"));
                      // rs.getInt("id"),
                       ab.setDate_ab(rs.getDate("Date_ab"));
                         ab.setEtat_ab(etat_ab.valueOf(rs.getString("etat_ab")) );               ;
                
                        Absence.add(ab);
            }
            return Absence;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return Absence;
    }
    public boolean ModifierAbsence(Absence absence){
           String sql = "UPdate absence set date_ab=?,etat_ab=? where id_ab=? ";
        try {
            ste = cnx.prepareStatement(sql);
            ste.setDate(1, absence.getDate_ab());
            ste.setString(2, absence.getEtat_ab().toString());
            
            ste.setInt(3,absence.getId_ab());
             ste.executeUpdate();
            System.out.println(ste);
            
            if (ste.executeUpdate()>0){
                System.out.println("Absence modifier");
                 return true;
            }else{
                System.out.println("Absence non modifier");
                return false;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        
        
    }
    public void supprimerAbsence(int id_ab){
        String sql = "delete from absence where id_ab=? ";
        try {
            ste = cnx.prepareStatement(sql);
            ste.setInt(1,id_ab);
            ste.executeUpdate();
            System.out.println(ste);
            System.out.println("Absence supprimer");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           
        }

    }
//    public ResultSet AfficherAbsenceFiltre(String keyword) {
//        try {
//            String sql = "SELECT * FROM absence WHERE etat_ab LIKE '%" + keyword + "%'";
//            ste= (PreparedStatement) cnx.createStatement();
//            ResultSet rs = ste.executeQuery(sql);
//            return rs;
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            return null;
//        }
//    }
    }
