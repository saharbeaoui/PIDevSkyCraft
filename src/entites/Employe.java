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
public class Employe {
    
    private int id_emp,id;
    private String nom,prenom,adresse_mail_emp,nationalite_emp;

    public Employe(int id_emp, int id, String nom, String prenom, String adresse_mail_emp, String nationalite_emp) {
        this.id_emp = id_emp;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse_mail_emp = adresse_mail_emp;
        this.nationalite_emp = nationalite_emp;
    }

    public int getId_emp() {
        return id_emp;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse_mail_emp() {
        return adresse_mail_emp;
    }

    public String getNationalite_emp() {
        return nationalite_emp;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse_mail_emp(String adresse_mail_emp) {
        this.adresse_mail_emp = adresse_mail_emp;
    }

    public void setNationalite_emp(String nationalite_emp) {
        this.nationalite_emp = nationalite_emp;
    }

    @Override
    public String toString() {
        return "Employe{" + "id_emp=" + id_emp + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse_mail_emp=" + adresse_mail_emp + ", nationalite_emp=" + nationalite_emp + '}';
    }
    
    
}
