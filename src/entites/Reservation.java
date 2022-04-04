/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
    
    private int id;
    private Vol vol;
    private Volgenerique volgenerique;
    private int nbr;
    private Timestamp date_reservation;
    private int iduser;

    public Reservation( int iduser, Vol vol, Timestamp date_reservation,int nbr) {
        this.iduser = iduser;
        this.vol = vol;
        this.date_reservation = date_reservation;
        this.nbr = nbr;
    }

    public Reservation(Volgenerique volgenerique, int nbr, Timestamp date_reservation, int iduser) {
        this.volgenerique = volgenerique;
        this.nbr = nbr;
        this.date_reservation = date_reservation;
        this.iduser = iduser;
    }

    public Reservation(int id, Vol vol, Volgenerique volgenerique, int nbr, Timestamp date_reservation, int iduser) {
        this.id = id;
        this.vol = vol;
        this.volgenerique = volgenerique;
        this.nbr = nbr;
        this.date_reservation = date_reservation;
        this.iduser = iduser;
    }
    
    

    public Reservation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vol getVol() {
        return vol;
    }

    public void setVol(Vol vol) {
        this.vol = vol;
    }

    public Timestamp getDate_reservation() {
        return date_reservation;
    }

    public void setDate_reservation(Timestamp date_reservation) {
        this.date_reservation = date_reservation;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public Volgenerique getVolgenerique() {
        return volgenerique;
    }

    public void setVolgenerique(Volgenerique volgenerique) {
        this.volgenerique = volgenerique;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", vol=" + vol + ", nbr=" + nbr + ", date_reservation=" + date_reservation + '}';
    }
    
    

    
    
}