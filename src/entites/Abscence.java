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
public class Abscence {
    
    private int id_ab,id_emp;
    private String date_ab;

    public Abscence(int id_ab, int id_emp, String date_ab) {
        this.id_ab = id_ab;
        this.id_emp = id_emp;
        this.date_ab = date_ab;
    }

    public int getId_ab() {
        return id_ab;
    }

    public int getId_emp() {
        return id_emp;
    }

    public String getDate_ab() {
        return date_ab;
    }

    public void setId_ab(int id_ab) {
        this.id_ab = id_ab;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    public void setDate_ab(String date_ab) {
        this.date_ab = date_ab;
    }

    @Override
    public String toString() {
        return "Abscence{" + "id_ab=" + id_ab + ", id_emp=" + id_emp + ", date_ab=" + date_ab + '}';
    }
    
    
    
    
}
