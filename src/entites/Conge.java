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
public class Conge {
    
    private int id_conge,id_emp,nb_jour,solde_conge;
    private String date_debut;

    public Conge(int id_conge, int id_emp, int nb_jour, int solde_conge, String date_debut) {
        this.id_conge = id_conge;
        this.id_emp = id_emp;
        this.nb_jour = nb_jour;
        this.solde_conge = solde_conge;
        this.date_debut = date_debut;
    }

    public int getId_conge() {
        return id_conge;
    }

    public int getId_emp() {
        return id_emp;
    }

    public int getNb_jour() {
        return nb_jour;
    }

    public int getSolde_conge() {
        return solde_conge;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setId_conge(int id_conge) {
        this.id_conge = id_conge;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    public void setNb_jour(int nb_jour) {
        this.nb_jour = nb_jour;
    }

    public void setSolde_conge(int solde_conge) {
        this.solde_conge = solde_conge;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    @Override
    public String toString() {
        return "Conge{" + "id_conge=" + id_conge + ", id_emp=" + id_emp + ", nb_jour=" + nb_jour + ", solde_conge=" + solde_conge + ", date_debut=" + date_debut + '}';
    }
    
    
}
