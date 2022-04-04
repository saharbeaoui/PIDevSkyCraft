package service;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import entites.*;
import tools.DataBase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import tools.Mail;
/**
 *
 * @author user
 */
public class ReservationService {
    Connection mc ;
    PreparedStatement ste ;
    
     public ReservationService() {
        mc=DataBase.getInstance().getConnection();
    }
    // Insert Into DB
    public Boolean ajouterReservationVol(Reservation rv,int idvol) throws SQLException, ClassNotFoundException, Exception{
        FactureService fs = new FactureService();
        VolService vs = new VolService();
        Vol vol = vs.afficherVolById(idvol);
        System.out.println("-------------"+vol.toString());
        
        System.out.println("-------------"+vol.getFacture().toString());
        String sql ="insert into reservation (date_reservation ,iduser ,nbr ,vol_id ,volgenerique_id) values(?,?,?,?,?)" ;
        try {
            fs.modifierFacture(vol.getFacture(), rv.getNbr());
            ste=mc.prepareStatement(sql);
            ste.setTimestamp(1, rv.getDate_reservation());
            ste.setInt(2,rv.getIduser());
            ste.setInt(3,rv.getNbr());
            ste.setInt(4,idvol);
            ste.setInt(5,0);
            ste.executeUpdate();
            fs.modifierFacture(vol.getFacture(), rv.getNbr());
             Mail mail=new Mail("spring.test1997@gmail.com", "springboot-123","spring.test1997@gmail.com", "Reservation", "Reservation du vol "+vol.getLieuDepart()+" à "+
                     vol.getLieuArrive()+" le "+vol.getDateDepart()+" et de nombre de personne "+rv.getNbr()+"au prix total de "+(rv.getNbr()*vol.getMontant()));
            System.out.println(" Reservation Vol ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }
    public Boolean ajouterReservationVolGenerique(Reservation rv,int idvol) throws Exception{
         FactureService fs = new FactureService();
        VolGeneriqueService vs = new VolGeneriqueService();
        Volgenerique vol = vs.afficherVolGeneriqueById(idvol);
        String sql ="insert into reservation (date_reservation ,iduser ,nbr ,vol_id ,volgenerique_id) values(?,?,?,?,?)" ;
        try {
            ste=mc.prepareStatement(sql);
            ste.setTimestamp(1, rv.getDate_reservation());
            ste.setInt(2,rv.getIduser());
            ste.setInt(3,rv.getNbr());
            ste.setInt(4,0);
            ste.setInt(5,idvol);
            ste.executeUpdate();
            fs.modifierFacture(vol.getFacture(), rv.getNbr());
             Mail mail=new Mail("spring.test1997@gmail.com", "springboot-123","spring.test1997@gmail.com", "Reservation", "Reservation du vol "+vol.getLieuDepart()+" à "+
                     vol.getLieuArrive()+" le "+vol.getHeureDepart()+" et de nombre de personne "+rv.getNbr()+"au prix total de "+(rv.getNbr()*vol.getMontant()));
            System.out.println(" Reservation Vol ajouté");
            System.out.println(" Reservation Vol ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }
    
    
     //Delete
     public void supprimerReservationVol(int idRV){
        String sql = "delete from reservation where id=? ";
        try {
            ste = mc.prepareStatement(sql);
            ste.setInt(1, idRV);
            ste.executeUpdate();
            System.out.println(ste);
                System.out.println("Vol  ID : "+idRV+" supprimer");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           
        }   
     }
     // Modify 
     
     public boolean modifierReservation_vol(Reservation v,Timestamp date_reservation)
    {
         String sql = "update reservation set date_reservation = ? where id =? ";
        try {
              ste = mc.prepareStatement(sql);
               
               ste.setTimestamp(1,date_reservation);
               ste.setInt(2,v.getId());
              ste.executeUpdate();
           
            
            if (ste.executeUpdate()>0){
                System.out.println("Reservation modifier");
                 return true;
            }else{
                System.out.println("Reservation non modifier");
                return false;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    //Display
    public List<Reservation> afficherReservation() throws ClassNotFoundException, SQLException{
        VolService vs= new VolService();
        VolGeneriqueService vgs= new VolGeneriqueService();
        List<Reservation> listeReservation = new ArrayList<>();
        String sql="select * from reservation";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Reservation rv = new Reservation();
                
                rv.setId(rs.getInt(1));
                rv.setDate_reservation(rs.getTimestamp("date_reservation"));
                if(rs.getInt("vol_id")>0){
                    
                rv.setVol(vs.afficherVolById(rs.getInt("vol_id")));
                }
                else if(rs.getInt("volgenerique_id")>0){
                     rv.setVolgenerique(vgs.afficherVolGeneriqueById(rs.getInt("volgenerique_id")));
                }
                rv.setIduser(rs.getInt("iduser"));
                rv.setNbr(rs.getInt("nbr"));
                
                listeReservation.add(rv);
                
                
            }
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return listeReservation;
    }      
    public List<Reservation> afficherReservationbyFacture(int id) throws ClassNotFoundException, SQLException{
        VolService vs= new VolService();
        VolGeneriqueService vgs= new VolGeneriqueService();
        List<Reservation> listeReservation = new ArrayList<>();
        String sql="SELECT r.id , r.date_reservation , r.iduser , r.nbr, r.vol_id , r.volgenerique_id FROM `reservation` r JOIN `vol` v ON r.vol_id= v.id WHERE v.facture_id = ? UNION SELECT r.id , r.date_reservation , r.iduser , r.nbr, r.vol_id , r.volgenerique_id FROM `reservation` r JOIN `volgenerique` vg ON vg.id=r.volgenerique_id WHERE vg.facture_id = ?";
        try {
            ste=mc.prepareStatement(sql);
             ste.setInt(1,id);
             ste.setInt(2,id);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                Reservation rv = new Reservation();
                
                rv.setId(rs.getInt("id"));
                rv.setDate_reservation(rs.getTimestamp("date_reservation"));
                if(rs.getInt("vol_id")>0){
                    
                rv.setVol(vs.afficherVolById(rs.getInt("vol_id")));
                }
                else if(rs.getInt("volgenerique_id")>0){
                     rv.setVolgenerique(vgs.afficherVolGeneriqueById(rs.getInt("volgenerique_id")));
                }
                rv.setIduser(rs.getInt("iduser"));
                rv.setNbr(rs.getInt("nbr"));
                System.out.println(rv.toString());
                listeReservation.add(rv);
                
                
            }
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return listeReservation;
    }
    public List<Reservation> findbydate(Date datet) throws SQLException, ClassNotFoundException {
     List<Reservation> listeReservation = new ArrayList<>();
    Reservation r= new Reservation();
    VolService vs = new VolService();
    VolGeneriqueService vgs = new VolGeneriqueService();
         String sql="SELECT * FROM `reservation`";
           ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                
               int id=rs.getInt("id");
    Timestamp dreservation =rs.getTimestamp("date_reservation");
    int iduser=rs.getInt("iduser");
    int nbr=rs.getInt("nbr");
    int idvol=rs.getInt("vol_id");
    int idvolgenerique=rs.getInt("volgenerique_id");
     r= new Reservation(id, vs.afficherVolById(idvol),vgs.afficherVolGeneriqueById(idvolgenerique),nbr,dreservation,iduser);
    if((dreservation.getDate()==datet.getDate())&&(dreservation.getMonth()==datet.getMonth())&&(dreservation.getYear()==datet.getYear())
           ){
           listeReservation.add(r);
        }  
    }
        return listeReservation;
    }
}