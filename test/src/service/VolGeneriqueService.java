package service;
import entites.Facture;
import entites.Volgenerique ;
import tools.DataBase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate ;
import java.time.LocalTime;

public class VolGeneriqueService {
   
    // Attributes
    Connection mc ;
    PreparedStatement ste ;
   
     public VolGeneriqueService() {
        mc=DataBase.getInstance().getConnection();
    }
     
     
    // Insert Into DB
    public void ajouterVolGenerique(Volgenerique vg, int designation){
        FactureService fs = new FactureService();
        String sql ="insert into volgenerique (heure_depart,heurearrivee ,montant ,facture_id ,lieu_arrive,lieu_depart) values(?,?,?,?,?,?)" ;
        try {
       Facture fact = new Facture(designation,vg.getMontant());
       fs.ajouterFacture(fact);
       Facture facture = fs.afficherFacturebydesignation(designation);
       
       
            ste=mc.prepareStatement(sql);
           
            ste.setTimestamp(1, vg.getHeureDepart());
            ste.setTimestamp(2, vg.getHeurearrivee());
            ste.setDouble(3,vg.getMontant());
            ste.setInt(4, facture.getId());
            ste.setString(5,vg.getLieuDepart());
            ste.setString(6,vg.getLieuArrive());
            ste.executeUpdate();
            System.out.println("Vol Generique ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
    // Delete
     public Boolean supprimerVolGenerique(int idVG){
     
        String sql = "delete from volgenerique where id=? ";
        try {
           
           
           ste = mc.prepareStatement(sql);
           ste.setInt(1, idVG);
           ste.executeUpdate();
           System.out.println(ste);
           System.out.println("Vol genrique ID : "+idVG+" supprimé");
         
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           
        }  
        return true;
     }
     
    //update Vol generique
      public boolean updateJour(int id , Timestamp depart, Timestamp arrive  ){
           String sql = "update volgenerique set heure_depart = ?,heurearrivee=? where id=? ";
        try {
           ste = mc.prepareStatement(sql);
           ste.setTimestamp(1, depart);
           ste.setTimestamp(2,arrive);
           ste.setInt(3, id);
            ste.executeUpdate();
           
           
            if (ste.executeUpdate()>0){
                System.out.println("date vol generique modifié");
                 return true;
            }else{
                System.out.println("date vol generique non modifié");
                return false;
            }
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
      }  
     
     
    // Display
    public List<Volgenerique> afficherVolGenerique(){
        FactureService fs = new FactureService();
        List<Volgenerique> listeVolGenerique = new ArrayList<>();
        String sql="select * from volgenerique";
        try {
           ste=mc.prepareStatement(sql);
           ResultSet rs=ste.executeQuery();
           while(rs.next()){
               Volgenerique newVG= new  Volgenerique ();
               newVG.setId(rs.getInt("id"));
               newVG.setMontant(rs.getDouble("montant"));
               newVG.setHeureDepart(rs.getTimestamp("heure_depart"));
               newVG.setHeurearrivee(rs.getTimestamp("heurearrivee"));
               newVG.setLieuDepart(rs.getString("lieu_arrive"));
               newVG.setLieuArrive(rs.getString("lieu_depart"));
               newVG.setFacture(fs.afficherFacturebyid(rs.getInt("facture_id")));
             
               listeVolGenerique.add(newVG);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        return listeVolGenerique;
    }    
      public Volgenerique afficherVolGeneriqueById(int id){
    Volgenerique newVG= new  Volgenerique ();
       FactureService fs = new FactureService();
        String sql="select * from volgenerique where id = ?";
        try {
           ste=mc.prepareStatement(sql);
            ste.setInt(1, id);
           ResultSet rs=ste.executeQuery();
              
             while(rs.next()){
               newVG.setId(rs.getInt("id"));
               newVG.setMontant(rs.getDouble("montant"));
               newVG.setHeureDepart(rs.getTimestamp("heure_depart"));
               newVG.setHeurearrivee(rs.getTimestamp("heurearrivee"));
               newVG.setLieuDepart(rs.getString("lieu_arrive"));
               newVG.setLieuArrive(rs.getString("lieu_depart"));
               newVG.setFacture(fs.afficherFacturebyid(rs.getInt("facture_id")));
             
            
            }
           
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        return newVG;
    }   
         public List<Volgenerique> findbydate(Date datet) throws SQLException {
    List<Volgenerique> vols =new ArrayList<>();
    FactureService fs = new FactureService();
    Volgenerique v= new Volgenerique();
         String sql="SELECT * FROM `volgenerique`";
        ste=mc.prepareStatement(sql);
           ResultSet rs=ste.executeQuery();
                while (rs.next()) {  
               
    int id=rs.getInt("id");
    Timestamp ddepart =rs.getTimestamp("heure_depart");
    Timestamp darrive=rs.getTimestamp("heurearrivee");
    String ldepart=rs.getString("lieu_depart");
    String larrive=rs.getString("lieu_arrive");
    Double prix=rs.getDouble("montant");
    Facture f= fs.afficherFacturebyid(rs.getInt("facture_id"));
     v= new Volgenerique(id, ddepart,darrive,ldepart,larrive,prix,f);
    if((ddepart.getDate()==datet.getDate())&&(ddepart.getMonth()==datet.getMonth())&&(ddepart.getYear()==datet.getYear())
            ){
           vols.add(v); 
        } }
    return vols;}
      public List<Volgenerique> findbylieu(String lieu) throws SQLException {
   FactureService fs = new FactureService();
        List<Volgenerique> listeVol= new ArrayList<>();
        String sql="select * from volgenerique where lieu_arrive = ? OR lieu_depart = ?";
        try {
           ste=mc.prepareStatement(sql);
           ste.setString(1, lieu);
           ste.setString(2, lieu);
           ResultSet rs=ste.executeQuery();
           while(rs.next()){
               Volgenerique newV= new  Volgenerique ();
               newV.setId(rs.getInt("id"));
               newV.setMontant(rs.getDouble("montant"));
               newV.setHeureDepart(rs.getTimestamp("heureDepart"));
               newV.setHeurearrivee(rs.getTimestamp("heurearrivee"));
               newV.setLieuDepart(rs.getString("lieu_arrive"));
               newV.setLieuArrive(rs.getString("lieu_depart"));
               newV.setFacture(fs.afficherFacturebyid(rs.getInt("facture_id")));
             
               listeVol.add(newV);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        return listeVol;}
}