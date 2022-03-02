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
public class Chambre {
    private int id;
    private String type;
    private int num_cham;

    public Chambre(int id, String type, int num_cham) {
        this.id = id;
        this.type = type;
        this.num_cham = num_cham;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getNum_cham() {
        return num_cham;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNum_cham(int num_cham) {
        this.num_cham = num_cham;
    }

    @Override
    public String toString() {
        return "Chambre{" + "id=" + id + ", type=" + type + ", num_cham=" + num_cham + '}';
    }
    
    
    
    
    
}
