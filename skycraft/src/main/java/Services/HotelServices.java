
package Services;
import skycraft.hotel.tools.MaConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entities.ReservationHotel;

public class HotelServices {
    Connection mc;
    PreparedStatement ste;

    public HotelServices() {
        mc=MaConnexion.getInstance().getCnx();
    }
  
    public void ajouterReservationHotel(ReservationHotel R){
        String sql ="insert into reservationhotel(datereservation,heurereservation,dureesejour) Values(?,?)";
        try {
            ste=mc.prepareStatement(sql);
            ste.setString(1, R.getDatereservation());
            ste.setString(2, R.getHeurereservation());
            ste.setString(3, R.getDureesejour());
            ste.executeUpdate();
            System.out.println("Rervation Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        public void UpdateReservationHotel(ReservationHotel R)
    {
        String sql ="update ReservationHotel set Dureesejour = ? , Datereservation = ? ,Heurereservation =? where id = ? ";
        try {
            ste=mc.prepareStatement(sql);
            ste.setString(1,R.getDureesejour());
            ste.setString(2,R.getHeurereservation() );
            ste.setString(3,R.getDatereservation());
            ste.setInt(4,R.getId());
            ste.executeUpdate();
            System.out.println("ReservationHotel modifiée");
            ste.close();
      
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    
    }
    
      
    /**
     *
     * @param R
     
     */
public void supprimerReservationHotel(ReservationHotel R){
        String sql ="delete from hotel where Id = ?";
        try{
        ste=mc.prepareStatement(sql);
        ste.setInt(1,R.getId());
        ste.executeUpdate();
        System.out.println("Réservation supprimeée");
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());  
        }
    }
public List<ReservationHotel> ReservationHotel(){
        List<ReservationHotel> ReservationHotel;
        ReservationHotel = new ArrayList<>();
        String sql="select * from ReservationHotel";
        try {
            ste=mc.prepareStatement(sql);
            ResultSet rs=ste.executeQuery();
            while(rs.next()){
                ReservationHotel R = new ReservationHotel();
                
                
                ReservationHotel.add(R);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return ReservationHotel;
    }    

    public boolean afficherReservationHotel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
