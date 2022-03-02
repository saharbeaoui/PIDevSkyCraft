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
public class Hotel {
    private int id_hotel;
    private String libelle,local,caracteristique;

    public Hotel(int id_hotel, String libelle, String local, String caracteristique) {
        this.id_hotel = id_hotel;
        this.libelle = libelle;
        this.local = local;
        this.caracteristique = caracteristique;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getLocal() {
        return local;
    }

    public String getCaracteristique() {
        return caracteristique;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setCaracteristique(String caracteristique) {
        this.caracteristique = caracteristique;
    }

    @Override
    public String toString() {
        return "Hotel{" + "id_hotel=" + id_hotel + ", libelle=" + libelle + ", local=" + local + ", caracteristique=" + caracteristique + '}';
    }
    
    
    
}
