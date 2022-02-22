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
public class Passager {
    
    private int id_passager;
    private String nom,adresse_mail_pass;

    public Passager(int id_passager, String nom, String adresse_mail_pass) {
        this.id_passager = id_passager;
        this.nom = nom;
        this.adresse_mail_pass = adresse_mail_pass;
    }

    public int getId_passager() {
        return id_passager;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse_mail_pass() {
        return adresse_mail_pass;
    }

    public void setId_passager(int id_passager) {
        this.id_passager = id_passager;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse_mail_pass(String adresse_mail_pass) {
        this.adresse_mail_pass = adresse_mail_pass;
    }

    @Override
    public String toString() {
        return "Passager{" + "id_passager=" + id_passager + ", nom=" + nom + ", adresse_mail_pass=" + adresse_mail_pass + '}';
    }
    
    
    
}
