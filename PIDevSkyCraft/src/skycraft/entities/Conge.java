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
public class Conge {
    private int id_conge,id,nb_jour;
    private String date_conge;

    public Conge(int id_conge, int id, int nb_jour, String date_conge) {
        this.id_conge = id_conge;
        this.id = id;
        this.nb_jour = nb_jour;
        
        this.date_conge = date_conge;
    } 

    public Conge(int id, int nb_jour, String date_conge) {
        this.id = id;
        this.nb_jour = nb_jour;
        this.date_conge = date_conge;
    }
    

    public Conge() {
    }

   
    public int getId_conge() {
        return id_conge;
    }

    public int getId() {
        return id;
    }

    public int getNb_jour() {
        return nb_jour;
    }

   
    public String getDate_conge() {
        return date_conge;
    }

    public void setId_conge(int id_conge) {
        this.id_conge = id_conge;
    }

    public void setId(int id) {
        this.id= id;
    }

    public void setNb_jour(int nb_jour) {
        this.nb_jour = nb_jour;
    }

  
    public void setDate_conge(String date_conge) {
        this.date_conge = date_conge;
    }

    @Override
    public String toString() {
        return "Conge{" + "id_conge=" + id_conge + ", id=" + id + ", nb_jour=" + nb_jour + ", date_conge=" + date_conge + '}';
    }

    
    
    
}
