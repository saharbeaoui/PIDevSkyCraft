/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skycraft.entities;

/**
 *
 * @author sinad
 */
public class Voiture {
    private int id;
    private String marque;
    private String matricule;
    private String couoleur;

    public Voiture(int id, String marque, String matricule, String couoleur) {
        this.id = id;
        this.marque = marque;
        this.matricule = matricule;
        this.couoleur = couoleur;
    }

    public Voiture() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public String getMarque() {
        return marque;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getCouoleur() {
        return couoleur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setCouoleur(String couoleur) {
        this.couoleur = couoleur;
    }

    @Override
    public String toString() {
        return "Voiture{" + "id=" + id + ", marque=" + marque + ", matricule=" + matricule + ", couoleur=" + couoleur + '}';
    }    
}
