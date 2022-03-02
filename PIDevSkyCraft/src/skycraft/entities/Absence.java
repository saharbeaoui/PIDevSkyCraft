/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skycraft.entities;

import java.sql.Date;
import skycraft.entities.enums.etat_ab;

public class Absence {
    private int id_ab;
      private int id;
private Date date_ab ;
    private etat_ab etat_ab;

    public Absence(int id_ab, int id, Date date_ab, etat_ab etat_ab) {
        this.id_ab = id_ab;
        this.id = id;
        this.date_ab = date_ab;
        this.etat_ab = etat_ab;
    }

    public Absence(int id_ab, Date date_ab, etat_ab etat_ab) {
        this.id_ab = id_ab;
        this.date_ab = date_ab;
        this.etat_ab = etat_ab;
    }

    public Absence(Date date_ab, etat_ab etat_ab) {
        this.date_ab = date_ab;
        this.etat_ab = etat_ab;
    }

   // public Absence() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    public Absence() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   

   
    


    public int getId_ab() {
        return id_ab;
    }

    public void setId_ab(int id_ab) {
        this.id_ab = id_ab;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_ab() {
        return date_ab;
    }

    public void setDate_ab(Date date_ab) {
        this.date_ab = date_ab;
    }

    public etat_ab getEtat_ab() {
        return etat_ab;
    }

    public void setEtat_ab(etat_ab etat_ab) {
        this.etat_ab = etat_ab;
    }

    @Override
    public String toString() {
        return "Absence{" + "id_ab=" + id_ab + ", date_ab=" + date_ab + ", etat_ab=" + etat_ab + '}';
    }


    
   

}