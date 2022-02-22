/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;
import java.time.LocalDate;
import java.time.LocalTime;


public class Vol {
    private int idVol;
    private LocalTime heureDepart ;
    private LocalTime heureArrivee ;
    private int montant ;
    private int idVolGenerique ;
    
    
    public Vol(int idVol, LocalTime heureDepart, LocalTime arrivee, int montant, int idVolGenerique) {
        this.idVol = idVol;
        this.heureDepart = heureDepart;
        this.heureArrivee = heureArrivee;
        this.montant = montant;
        this.idVolGenerique = idVolGenerique;
    }

    public int getIdVol() {
        return idVol;
    }

    public LocalTime getHeureDepart() {
        return heureDepart;
    }

    public LocalTime getHeureArrivee() {
        return heureArrivee;
    }

    public int getMontant() {
        return montant;
    }

    public int getIdVolGenerique() {
        return idVolGenerique;
    }

    public void setIdVol(int idVol) {
        this.idVol = idVol;
    }

    public void setHeureDepart(LocalTime heureDepart) {
        this.heureDepart = heureDepart;
    }

    public void setHeureArrivee(LocalTime heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public void setIdVolGenerique(int idVolGenerique) {
        this.idVolGenerique = idVolGenerique;
    }

    @Override
    public String toString() {
        return "Vol{" + "idVol=" + idVol + ", heureDepart=" + heureDepart + ", heureArrivee=" + heureArrivee + ", montant=" + montant + ", idVolGenerique=" + idVolGenerique + '}';
    }
    
    
}