package service;
import entites.* ;
import service.FactureService;
import tools.DataBase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VolService {

// Attributes
    Connection mc ;
    PreparedStatement ste ;
   
    public VolService() throws ClassNotFoundException, SQLException {
        mc=DataBase.getInstance().getConnection();      
    }
   
    // Insert Into DB
    public void ajouterVol(Vol vol, int designation){
   
       FactureService fs = new FactureService();
        String sql ="insert into vol (date_depart,date_arrivee ,montant ,facture_id ,lieu_arrive,lieu_depart) values(?,?,?,?,?,?)" ;
        try {
       Facture fact = new Facture(designation,vol.getMontant());
       fs.ajouterFacture(fact);
       Facture facture = fs.afficherFacturebydesignation(designation);
            System.out.println(facture.toString());
            System.out.println(fact.toString());
       
            ste=mc.prepareStatement(sql);
           
            ste.setTimestamp(1, vol.getDateDepart());
            ste.setTimestamp(2, vol.getDateArrivee());
            ste.setDouble(3,vol.getMontant());
            ste.setInt(4, facture.getId());
            ste.setString(5,vol.getLieuDepart());
            ste.setString(6,vol.getLieuArrive());
            ste.executeUpdate();
            System.out.println("Vol Generique ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
   
       
    }
   
    // Delete All
    public void supprimerLesVols()
    {
    this.afficherVol()
    .stream()
    .map(vol -> vol.getId())
    .forEach(id -> this.supprimerVol(id));
    System.out.println("All flights have been deleted");
    }
   
   
    //Delete One
     public Boolean supprimerVol(int idVol){
 String sql = "delete from vol where id=? ";
        try {
           
           
           ste = mc.prepareStatement(sql);
           ste.setInt(1, idVol);
           ste.executeUpdate();
           System.out.println(ste);
           System.out.println("Vol ID : "+idVol+" supprimé");
         
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           
        }  
       return true;
     }
           public boolean updateJour(int id , Timestamp depart, Timestamp arrive  ){
           String sql = "update vol set date_depart = ?,date_arrivee=? where id=? ";
        try {
           ste = mc.prepareStatement(sql);
           ste.setTimestamp(1, depart);
           ste.setTimestamp(2,arrive);
           ste.setInt(3, id);
            ste.executeUpdate();
           
           
            if (ste.executeUpdate()>0){
                System.out.println("date vol modifié");
                 return true;
            }else{
                System.out.println("date vol non modifié");
                return false;
            }
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
      }  
    //Display
    public List<Vol> afficherVol(){
   
       FactureService fs = new FactureService();
        List<Vol> listeVol= new ArrayList<>();
        String sql="select * from vol";
        try {
           ste=mc.prepareStatement(sql);
           ResultSet rs=ste.executeQuery();
           while(rs.next()){
               Vol newV= new  Vol ();
               newV.setId(rs.getInt("id"));
               newV.setMontant(rs.getDouble("montant"));
               newV.setDateDepart(rs.getTimestamp("date_depart"));
               newV.setDateArrivee(rs.getTimestamp("date_arrivee"));
               newV.setLieuDepart(rs.getString("lieu_arrive"));
               newV.setLieuArrive(rs.getString("lieu_depart"));
               newV.setFacture(fs.afficherFacturebyid(rs.getInt("facture_id")));
             
               listeVol.add(newV);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        return listeVol;
    }   
      public Vol afficherVolById(int id){
    Vol newV= new  Vol ();
       FactureService fs = new FactureService();
        String sql="select * from vol where id = ?";
        try {
           ste=mc.prepareStatement(sql);
            ste.setInt(1, id);
           ResultSet rs=ste.executeQuery();
              while(rs.next()){
               newV.setId(rs.getInt("id"));
               newV.setMontant(rs.getDouble("montant"));
               newV.setDateDepart(rs.getTimestamp("date_depart"));
               newV.setDateArrivee(rs.getTimestamp("date_arrivee"));
               newV.setLieuDepart(rs.getString("lieu_arrive"));
               newV.setLieuArrive(rs.getString("lieu_depart"));
               newV.setFacture(fs.afficherFacturebyid(rs.getInt("facture_id")));
             
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        return newV;
    }   
        public List<Vol> findbydate(Date datet) throws SQLException {
    List<Vol> vols =new ArrayList<>();
    FactureService fs = new FactureService();
    Vol v= new Vol();
        String sql="select * from vol";
          ste=mc.prepareStatement(sql);
           ResultSet rs=ste.executeQuery();
                while (rs.next()) {  
               
    int id=rs.getInt("id");
    Timestamp ddepart =rs.getTimestamp("date_depart");
    Timestamp darrive=rs.getTimestamp("date_arrivee");
    String ldepart=rs.getString("lieu_depart");
    String larrive=rs.getString("lieu_arrive");
    Double prix=rs.getDouble("montant");
    Facture f= fs.afficherFacturebyid(rs.getInt("facture_id"));
     v= new Vol(id, ddepart,ldepart,larrive,darrive,prix,f);
    if((ddepart.getDate()==datet.getDate())&&(ddepart.getMonth()==datet.getMonth())&&(ddepart.getYear()==datet.getYear())
           ){
           vols.add(v); 
        } }
    return vols;}
        
        
      public List<Vol> findbylieu(String lieu) throws SQLException {
   FactureService fs = new FactureService();
        List<Vol> listeVol= new ArrayList<>();
        String sql="select * from vol where lieu_arrive = ? OR lieu_depart = ?";
        try {
           ste=mc.prepareStatement(sql);
           ste.setString(1, lieu);
           ste.setString(2, lieu);
           ResultSet rs=ste.executeQuery();
           while(rs.next()){
               Vol newV= new  Vol ();
               newV.setId(rs.getInt("id"));
               newV.setMontant(rs.getDouble("montant"));
               newV.setDateDepart(rs.getTimestamp("date_depart"));
               newV.setDateArrivee(rs.getTimestamp("date_arrivee"));
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