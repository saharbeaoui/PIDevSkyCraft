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
public class reservation_e {
    
    private int id_re, id_client, id_facture_ev, id_even, id_offre;

    public reservation_e(int id_re, int id_client, int id_facture_ev, int id_even, int id_offre) {
        this.id_re = id_re;
        this.id_client = id_client;
        this.id_facture_ev = id_facture_ev;
        this.id_even = id_even;
        this.id_offre = id_offre;
    }

    public int getId_re() {
        return id_re;
    }

    public int getId_client() {
        return id_client;
    }

    public int getId_facture_ev() {
        return id_facture_ev;
    }

    public int getId_even() {
        return id_even;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_re(int id_re) {
        this.id_re = id_re;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setId_facture_ev(int id_facture_ev) {
        this.id_facture_ev = id_facture_ev;
    }

    public void setId_even(int id_even) {
        this.id_even = id_even;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    @Override
    public String toString() {
        return "reservation_e{" + "id_re=" + id_re + ", id_client=" + id_client + ", id_facture_ev=" + id_facture_ev + ", id_even=" + id_even + ", id_offre=" + id_offre + '}';
    }
    
    
    
}
