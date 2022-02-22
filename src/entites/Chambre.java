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
public class Chambre {
    
    private int id_cham,id_hotel,num_chamb;
    private String type;

    public Chambre(int id_cham, int id_hotel, int num_chamb, String type) {
        this.id_cham = id_cham;
        this.id_hotel = id_hotel;
        this.num_chamb = num_chamb;
        this.type = type;
    }

    public int getId_cham() {
        return id_cham;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public int getNum_chamb() {
        return num_chamb;
    }

    public String getType() {
        return type;
    }

    public void setId_cham(int id_cham) {
        this.id_cham = id_cham;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public void setNum_chamb(int num_chamb) {
        this.num_chamb = num_chamb;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Chambre{" + "id_cham=" + id_cham + ", id_hotel=" + id_hotel + ", num_chamb=" + num_chamb + ", type=" + type + '}';
    }
    
    
    
}
