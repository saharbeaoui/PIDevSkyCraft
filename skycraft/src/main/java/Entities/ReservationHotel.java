
package Entities;
        


public class ReservationHotel {
    private int id;
    private String datereservation,heurereservation,dureesejour;
    
    public ReservationHotel(){
    }
    public ReservationHotel(int id, String datereservation, String heurereservation, String dureesejour){
        this.id = id;
        this.datereservation = datereservation;
        this.heurereservation = heurereservation;
        this.dureesejour = dureesejour;
    }
    @Override
    public String toString() {
        return "ReservationHotel{" + "id=" + id + ", datereservation=" + datereservation + ", heurereservation=" + heurereservation + ", dureesejour=" + dureesejour + '}' ;
              
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatereservation() {
        return datereservation;
    }

    public void setDatereservation(String datereservation) {
        this.datereservation = datereservation;
    }

    public String getHeurereservation() {
        return heurereservation;
    }

    public void setHeurereservation(String heurereservation) {
        this.heurereservation = heurereservation;
    }
    public String getDureesejour() {
        return dureesejour;
    }

    public void setDureesejour(String dureesejour) {
        this.dureesejour = dureesejour;
    }

    public void ajouterReservationHotel(ReservationHotel R) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
