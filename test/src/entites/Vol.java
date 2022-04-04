/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;
import java.sql.Timestamp;


public class Vol {
    private int id;
    private Timestamp dateDepart ;
    private String lieuDepart;
    private String lieuArrive;
    private Timestamp dateArrivee ;
    private double montant ;
    private Facture facture ;
    
    public Vol()
    {
    }

    public Vol(Timestamp dateDepart, String lieuDepart, String lieuArrive, Timestamp dateArrivee, double montant, Facture facture) {
        this.dateDepart = dateDepart;
        this.lieuDepart = lieuDepart;
        this.lieuArrive = lieuArrive;
        this.dateArrivee = dateArrivee;
        this.montant = montant;
        this.facture = facture;
    }

    public Vol(int id, Timestamp dateDepart, String lieuDepart, String lieuArrive, Timestamp dateArrivee, double montant, Facture facture) {
        this.id = id;
        this.dateDepart = dateDepart;
        this.lieuDepart = lieuDepart;
        this.lieuArrive = lieuArrive;
        this.dateArrivee = dateArrivee;
        this.montant = montant;
        this.facture = facture;
    }

    public Vol(Timestamp dateDepart, String lieuDepart, String lieuArrive, Timestamp dateArrivee, double montant) {
        this.dateDepart = dateDepart;
        this.lieuDepart = lieuDepart;
        this.lieuArrive = lieuArrive;
        this.dateArrivee = dateArrivee;
        this.montant = montant;
    }
    

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Timestamp dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Timestamp getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Timestamp dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    @Override
    public String toString() {
        return "Vol{" + "id=" + id + ", dateDepart=" + dateDepart + ", lieuDepart=" + lieuDepart + ", lieuArrive=" + lieuArrive + ", dateArrivee=" + dateArrivee + ", montant=" + montant + ", facture=" + facture + '}';
    }

    public String getLieuDepart() {
        return lieuDepart;
    }

    public void setLieuDepart(String lieuDepart) {
        this.lieuDepart = lieuDepart;
    }

    public String getLieuArrive() {
        return lieuArrive;
    }

    public void setLieuArrive(String lieuArrive) {
        this.lieuArrive = lieuArrive;
    }

   
    
    
    
    
}
