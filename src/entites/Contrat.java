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
public class Contrat {
    
    private int id_contrat,id_emp;
    private String type,poste;

    public Contrat(int id_contrat, int id_emp, String type, String poste) {
        this.id_contrat = id_contrat;
        this.id_emp = id_emp;
        this.type = type;
        this.poste = poste;
    }

    public int getId_contrat() {
        return id_contrat;
    }

    public int getId_emp() {
        return id_emp;
    }

    public String getType() {
        return type;
    }

    public String getPoste() {
        return poste;
    }

    public void setId_contrat(int id_contrat) {
        this.id_contrat = id_contrat;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    @Override
    public String toString() {
        return "Contrat{" + "id_contrat=" + id_contrat + ", id_emp=" + id_emp + ", type=" + type + ", poste=" + poste + '}';
    }
    
    
}
