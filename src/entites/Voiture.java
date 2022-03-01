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
public class Voiture {
    
    private int id_voiture;
    private String matricule,marque,couleur;

    public Voiture(int id_voiture, String matricule, String marque, String couleur) {
        this.id_voiture = id_voiture;
        this.matricule = matricule;
        this.marque = marque;
        this.couleur = couleur;
    }

    public Voiture() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Voiture(String matricule, String marque, String couleur) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getMarque() {
        return marque;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Voiture{" + "id_voiture=" + id_voiture + ", matricule=" + matricule + ", marque=" + marque + ", couleur=" + couleur + '}';
    }
    
    
    
}
