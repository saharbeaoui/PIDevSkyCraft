
package Entities;


public class Hotel {
    private int id;
    private String libellé,caractéristiques;
    
public Hotel() {
    
}
    public Hotel(int id, String libellé,String caractéristiques) {
        this.id = id;
        this.libellé = libellé;
        this.caractéristiques = caractéristiques;
} 

    public Hotel(String id_hotel, String libellé_hotel, String caractéristiques_hotel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
  public String toString() {
        return "Hotel{" + "id=" + id + ", libellé=" + libellé + ", caractéristiques=" + caractéristiques + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibellé() {
        return libellé;
    }

    public void setLibellé(String libellé) {
        this.libellé = libellé;
    }

    public String getCaractéristiques() {
        return caractéristiques;
    }

    public void setCaractéristiques(String caractéristiques) {
        this.caractéristiques = caractéristiques;
    }

    public void setid_hotel(String id_hotel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setlibellé_hotel(String libellé_hotel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setcaractéristiques_hotel(String caractéristiques_hotel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean getNom_chauffeur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
