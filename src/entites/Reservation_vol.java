/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author sahar
 */
public class Reservation_vol {
    
    
    private int id_reservation_vol,id_passager,id_facture_volid_client,id_vol;
    private String date_reservation,heure_reservation;

    public Reservation_vol(int id_reservation_vol, int id_passager, int id_facture_volid_client, int id_vol, String date_reservation, String heure_reservation) {
        this.id_reservation_vol = id_reservation_vol;
        this.id_passager = id_passager;
        this.id_facture_volid_client = id_facture_volid_client;
        this.id_vol = id_vol;
        this.date_reservation = date_reservation;
        this.heure_reservation = heure_reservation;
    }

    public int getId_reservation_vol() {
        return id_reservation_vol;
    }

    public int getId_passager() {
        return id_passager;
    }

    public int getId_facture_volid_client() {
        return id_facture_volid_client;
    }

    public int getId_vol() {
        return id_vol;
    }

    public String getDate_reservation() {
        return date_reservation;
    }

    public String getHeure_reservation() {
        return heure_reservation;
    }

    public void setId_reservation_vol(int id_reservation_vol) {
        this.id_reservation_vol = id_reservation_vol;
    }

    public void setId_passager(int id_passager) {
        this.id_passager = id_passager;
    }

    public void setId_facture_volid_client(int id_facture_volid_client) {
        this.id_facture_volid_client = id_facture_volid_client;
    }

    public void setId_vol(int id_vol) {
        this.id_vol = id_vol;
    }

    public void setDate_reservation(String date_reservation) {
        this.date_reservation = date_reservation;
    }

    public void setHeure_reservation(String heure_reservation) {
        this.heure_reservation = heure_reservation;
    }

    @Override
    public String toString() {
        return "Reservation_vol{" + "id_reservation_vol=" + id_reservation_vol + ", id_passager=" + id_passager + ", id_facture_volid_client=" + id_facture_volid_client + ", id_vol=" + id_vol + ", date_reservation=" + date_reservation + ", heure_reservation=" + heure_reservation + '}';
    }
    
    
}
