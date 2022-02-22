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
public class Reservation_h {
    
    private int id_rh, duree,id_client,id_cham,id_facture_hot;
    private String date_rh,heure_rh;

    public Reservation_h(int id_rh, int duree, int id_client, int id_cham, int id_facture_hot, String date_rh, String heure_rh) {
        this.id_rh = id_rh;
        this.duree = duree;
        this.id_client = id_client;
        this.id_cham = id_cham;
        this.id_facture_hot = id_facture_hot;
        this.date_rh = date_rh;
        this.heure_rh = heure_rh;
    }

    public int getId_rh() {
        return id_rh;
    }

    public int getDuree() {
        return duree;
    }

    public int getId_client() {
        return id_client;
    }

    public int getId_cham() {
        return id_cham;
    }

    public int getId_facture_hot() {
        return id_facture_hot;
    }

    public String getDate_rh() {
        return date_rh;
    }

    public String getHeure_rh() {
        return heure_rh;
    }

    public void setId_rh(int id_rh) {
        this.id_rh = id_rh;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setId_cham(int id_cham) {
        this.id_cham = id_cham;
    }

    public void setId_facture_hot(int id_facture_hot) {
        this.id_facture_hot = id_facture_hot;
    }

    public void setDate_rh(String date_rh) {
        this.date_rh = date_rh;
    }

    public void setHeure_rh(String heure_rh) {
        this.heure_rh = heure_rh;
    }

    @Override
    public String toString() {
        return "Reservation_h{" + "id_rh=" + id_rh + ", duree=" + duree + ", id_client=" + id_client + ", id_cham=" + id_cham + ", id_facture_hot=" + id_facture_hot + ", date_rh=" + date_rh + ", heure_rh=" + heure_rh + '}';
    }
    
    
}
