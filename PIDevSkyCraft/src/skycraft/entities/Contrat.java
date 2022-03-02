/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skycraft.entities;
import skycraft.entities.enums.poste;
import skycraft.entities.enums.type;
import skycraft.entities.User;

/**
 *
 * @author sinad
 */
public class Contrat {
    private int id_contrat;
    private int id;
    private type type;
    private poste poste;
    private int duree_contrat;

    public Contrat(int id_contrat, int id, type type, poste poste, int duree_contrat) {
        this.id_contrat = id_contrat;
        this.id = id;
        this.type = type;
        this.poste = poste;
        this.duree_contrat = duree_contrat;
    }

    public Contrat(int id, type type, poste poste, int duree_contrat) {
        this.id = id;
        this.type = type;
        this.poste = poste;
        this.duree_contrat = duree_contrat;
    }

    public Contrat() {
    }

    public Contrat(int id_contrat) {
        this.id_contrat = id_contrat;
    }
    

    public Contrat(type type, poste poste, int duree_contrat) {
        this.type = type;
        this.poste = poste;
        this.duree_contrat = duree_contrat;
    }

    public Contrat(String id, String type, String post, String duree) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
 

    public int getId_contrat() {
        return id_contrat;
    }

    public void setId_contrat(int id_contrat) {
        this.id_contrat = id_contrat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public type getType() {
        return type;
    }

    public void setType(type type) {
        this.type = type;
    }

    public poste getPoste() {
        return poste;
    }

    public void setPoste(poste poste) {
        this.poste = poste;
    }

    public int getDuree_contrat() {
        return duree_contrat;
    }

    public void setDuree_contrat(int duree_contrat) {
        this.duree_contrat = duree_contrat;
    }

    @Override
    public String toString() {
        return "Contrat{" + "id_contrat=" + id_contrat + ", id=" + id + ", type=" + type + ", poste=" + poste + ", duree_contrat=" + duree_contrat + '}';
    }

    
    
    
}
