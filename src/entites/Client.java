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
public class Client {
    private int id_client,id;
    private String nom,prenom,adresse_mail,nationalite;

    public Client(int id_client, int id, String nom, String prenom, String adresse_mail, String nationalite) {
        this.id_client = id_client;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse_mail = adresse_mail;
        this.nationalite = nationalite;
    }

    public int getId_client() {
        return id_client;
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

    public String getAdresse_mail() {
        return adresse_mail;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
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

    public void setAdresse_mail(String adresse_mail) {
        this.adresse_mail = adresse_mail;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    @Override
    public String toString() {
        return "Client{" + "id_client=" + id_client + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse_mail=" + adresse_mail + ", nationalite=" + nationalite + '}';
    }
    
    
    
}
