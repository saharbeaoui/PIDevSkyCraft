
package skycraft.hotel.tests;


import Entities.ReservationHotel;
import Services.HotelServices;
import skycraft.hotel.tools.MaConnexion;
    
public class Main {


    public static void main(String[] args) {
        MaConnexion m = MaConnexion.getInstance();
        ReservationHotel R=new ReservationHotel(3606, "16 février", "10h","15 jours");
        HotelServices HS = new HotelServices();
        R.ajouterReservationHotel(R);
        System.out.println(HS.afficherReservationHotel());
    }
    
}
