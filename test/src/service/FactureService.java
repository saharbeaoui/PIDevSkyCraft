package service;
import entites.* ;
import tools.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FactureService {
    
    //Attributes
    Connection mc ;
    PreparedStatement ste ;
    
     public FactureService() {
        mc=DataBase.getInstance().getConnection();
    }
    //Insert Into DB
    public void ajouterFacture(Facture fc){
        String sql ="insert into facture (designation , nbr ,prix_total ,prix_unitaire) values(?,?,?,?)" ;
        try {
            ste=mc.prepareStatement(sql);
            ste.setInt(1,fc.getDesignation());
            ste.setInt(2,fc.getNbr());
            ste.setDouble(3,0);
            ste.setDouble(4,fc.getPrix_unitaire());
            
            ste.executeUpdate();
            System.out.println("Facture ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //Delete
    public void supprimerFacture(int idFV){
        String sql = "delete from facture where id=? ";
        try {
            ste = mc.prepareStatement(sql);
            ste.setInt(1, idFV);
            ste.executeUpdate();
            System.out.println(ste);
                System.out.println("Facture ID : "+idFV+" supprimer");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           
        }   
     }
    //update
    public boolean modifierFacture(Facture v, int nbr)
    {
        System.out.println(v.toString());
        System.out.println("-----------------"+nbr);
         String sql = "UPDATE facture SET nbr = ? , prix_total = ? where id = ? ";
        try {
              ste = mc.prepareStatement(sql);
               ste.setInt(1,v.getNbr()+nbr);
               ste.setDouble(2,v.getPrix_total()+(v.getPrix_unitaire()*nbr));
              ste.setInt(3,v.getId());
           
            
            if (ste.executeUpdate()>0){
                System.out.println("Facture modifier");
                 return true;
            }else{
                System.out.println("Facture non modifier");
                return false;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    //Display
    public List<Facture> afficherFacture(){
        List<Facture> listeFacture = new ArrayList<>();
        String sql="select * from facture";
        try{
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Facture newFC = new Facture ();
                
                newFC.setId(rs.getInt("id"));
                newFC.setDesignation(rs.getInt("designation"));
                newFC.setNbr(rs.getInt("nbr"));
                newFC.setPrix_unitaire(rs.getDouble("prix_unitaire"));
                newFC.setPrix_total(rs.getDouble("prix_total"));
                
                listeFacture.add(newFC);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
        
        return listeFacture;
    }
     public Facture afficherFacturebydesignation(int d) throws SQLException{
           System.out.println("----------------- bdeeeeeet");
        String sql="select * from facture where `designation` = ?";
         Facture newFC = new Facture ();
        
            ste=mc.prepareStatement(sql);
            ste.setInt(1, d);
            ResultSet rs=ste.executeQuery();
            
               
                 while(rs.next()){
                newFC.setId(rs.getInt("id"));
                newFC.setDesignation(rs.getInt("designation"));
                newFC.setNbr(rs.getInt("nbr"));
                newFC.setPrix_unitaire(rs.getDouble("prix_unitaire"));
                newFC.setPrix_total(rs.getDouble("prix_total"));
                System.out.println("-----------------"+rs.getInt("id"));
                 }
     
        
        return newFC;
    }
      public Facture afficherFacturebyid(int d){
        String sql="select * from facture where id = ?";
         Facture newFC = new Facture ();
        try{
            ste=mc.prepareStatement(sql);
            ste.setInt(1, d);
            ResultSet rs=ste.executeQuery();
            
               
                
                while(rs.next()){
                newFC.setId(rs.getInt("id"));
                newFC.setDesignation(rs.getInt("designation"));
                newFC.setNbr(rs.getInt("nbr"));
                newFC.setPrix_unitaire(rs.getDouble("prix_unitaire"));
                newFC.setPrix_total(rs.getDouble("prix_total"));
                System.out.println("-----------------"+rs.getInt("id"));
                 }
                
            }
         catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
        
        return newFC;
    }
}