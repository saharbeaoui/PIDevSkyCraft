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
public class Evenement {
    
    private int id_even;
    private String detail,date_debut_ev,duree_ev;

    public Evenement(int id_even, String detail, String date_debut_ev, String duree_ev) {
        this.id_even = id_even;
        this.detail = detail;
        this.date_debut_ev = date_debut_ev;
        this.duree_ev = duree_ev;
    }

    public int getId_even() {
        return id_even;
    }

    public String getDetail() {
        return detail;
    }

    public String getDate_debut_ev() {
        return date_debut_ev;
    }

    public String getDuree_ev() {
        return duree_ev;
    }

    public void setId_even(int id_even) {
        this.id_even = id_even;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setDate_debut_ev(String date_debut_ev) {
        this.date_debut_ev = date_debut_ev;
    }

    public void setDuree_ev(String duree_ev) {
        this.duree_ev = duree_ev;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id_even=" + id_even + ", detail=" + detail + ", date_debut_ev=" + date_debut_ev + ", duree_ev=" + duree_ev + '}';
    }
    
    
    
}
