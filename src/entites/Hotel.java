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
public class Hotel {
    
    private int id_hotel;
    private String libelle,locale,caracteristique;

    public Hotel(int id_hotel, String libelle, String locale, String caracteristique) {
        this.id_hotel = id_hotel;
        this.libelle = libelle;
        this.locale = locale;
        this.caracteristique = caracteristique;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getLocale() {
        return locale;
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

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void setCaracteristique(String caracteristique) {
        this.caracteristique = caracteristique;
    }

    @Override
    public String toString() {
        return "Hotel{" + "id_hotel=" + id_hotel + ", libelle=" + libelle + ", locale=" + locale + ", caracteristique=" + caracteristique + '}';
    }
    
    
}
