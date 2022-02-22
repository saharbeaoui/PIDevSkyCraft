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
public class Chauffeur {
    
    private int id_chauffeur,num_tel_chauffeur;
    private String nom_chauffeur,prenom_chauffeur,cin_chauffeur,email_chauffeur,date_naissance_chauffeur,num_compte_bancaire;

    public Chauffeur(int id_chauffeur, int num_tel_chauffeur, String nom_chauffeur, String prenom_chauffeur, String cin_chauffeur, String email_chauffeur, String date_naissance_chauffeur, String num_compte_bancaire) {
        this.id_chauffeur = id_chauffeur;
        this.num_tel_chauffeur = num_tel_chauffeur;
        this.nom_chauffeur = nom_chauffeur;
        this.prenom_chauffeur = prenom_chauffeur;
        this.cin_chauffeur = cin_chauffeur;
        this.email_chauffeur = email_chauffeur;
        this.date_naissance_chauffeur = date_naissance_chauffeur;
        this.num_compte_bancaire = num_compte_bancaire;
    }

    

    public Chauffeur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_chauffeur() {
        return id_chauffeur;
    }

    public int getNum_tel_chauffeur() {
        return num_tel_chauffeur;
    }

    public String getNom_chauffeur() {
        return nom_chauffeur;
    }

    public String getPrenom_chauffeur() {
        return prenom_chauffeur;
    }

    public String getCin_chauffeur() {
        return cin_chauffeur;
    }

    public String getEmail_chauffeur() {
        return email_chauffeur;
    }

   

    public String getDate_naissance_chauffeur() {
        return date_naissance_chauffeur;
    }

    public String getNum_compte_bancaire() {
        return num_compte_bancaire;
    }

    public void setId_chauffeur(int id_chauffeur) {
        this.id_chauffeur = id_chauffeur;
    }

    public void setNum_tel_chauffeur(int num_tel_chauffeur) {
        this.num_tel_chauffeur = num_tel_chauffeur;
    }

    public void setNom_chauffeur(String nom_chauffeur) {
        this.nom_chauffeur = nom_chauffeur;
    }

    public void setPrenom_chauffeur(String prenom_chauffeur) {
        this.prenom_chauffeur = prenom_chauffeur;
    }

    public void setCin_chauffeur(String cin_chauffeur) {
        this.cin_chauffeur = cin_chauffeur;
    }

    public void setEmail_chauffeur(String email_chauffeur) {
        this.email_chauffeur = email_chauffeur;
    }

   

    public void setDate_naissance_chauffeur(String date_naissance_chauffeur) {
        this.date_naissance_chauffeur = date_naissance_chauffeur;
    }

    public void setNum_compte_bancaire(String num_compte_bancaire) {
        this.num_compte_bancaire = num_compte_bancaire;
    }

    @Override
    public String toString() {
        return "Chauffeur{" + "id_chauffeur=" + id_chauffeur + ", num_tel_chauffeur=" + num_tel_chauffeur + ", nom_chauffeur=" + nom_chauffeur + ", prenom_chauffeur=" + prenom_chauffeur + ", cin_chauffeur=" + cin_chauffeur + ", email_chauffeur=" + email_chauffeur + ", date_naissance_chauffeur=" + date_naissance_chauffeur + ", num_compte_bancaire=" + num_compte_bancaire + '}';
    }

    
    
        
    
}
