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
public class Client {
    private int id_client;
    private String nom;
    private String prenom;
    private int num;
    private String adresse_mail;
    private String nationalite;

    public Client(int id_client, String nom, String prenom, int num, String adresse_mail, String nationalite) {
        this.id_client = id_client;
        this.nom = nom;
        this.prenom = prenom;
        this.num = num;
        this.adresse_mail = adresse_mail;
        this.nationalite = nationalite;
    }

    public Client() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_client() {
        return id_client;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getNum() {
        return num;
    }

    public String getAdresse_mail() {
        return adresse_mail;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setAdresse_mail(String adresse_mail) {
        this.adresse_mail = adresse_mail;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    @Override
    public String toString() {
        return "Client{" + "id_client=" + id_client + ", nom=" + nom + ", prenom=" + prenom + ", num=" + num + ", adresse_mail=" + adresse_mail + ", nationalite=" + nationalite + '}';
    }

    public void setId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
