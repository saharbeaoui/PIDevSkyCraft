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
public class Facture_ev {
    
    
   private int id_facture_ev;

    public Facture_ev(int id_facture_ev) {
        this.id_facture_ev = id_facture_ev;
    }

    public int getId_facture_ev() {
        return id_facture_ev;
    }

    public void setId_facture_ev(int id_facture_ev) {
        this.id_facture_ev = id_facture_ev;
    }

    @Override
    public String toString() {
        return "Facture_ev{" + "id_facture_ev=" + id_facture_ev + '}';
    }
    
    
}
