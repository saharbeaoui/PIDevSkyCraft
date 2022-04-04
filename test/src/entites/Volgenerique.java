package entites;
import java.sql.Timestamp;

public class Volgenerique {
   private int id ;
   private  Timestamp heureDepart ;
   private  Timestamp heurearrivee ;
     private String lieuDepart;
    private String lieuArrive;
      private double montant ;
    private Facture facture ;
 

    public Volgenerique() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(Timestamp heureDepart) {
        this.heureDepart = heureDepart;
    }

    public Timestamp getHeurearrivee() {
        return heurearrivee;
    }

    public void setHeurearrivee(Timestamp heurearrivee) {
        this.heurearrivee = heurearrivee;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Volgenerique(Timestamp heureDepart, Timestamp heurearrivee, String lieuDepart, String lieuArrive, double montant, Facture facture) {
        this.heureDepart = heureDepart;
        this.heurearrivee = heurearrivee;
        this.lieuDepart = lieuDepart;
        this.lieuArrive = lieuArrive;
        this.montant = montant;
        this.facture = facture;
    }

    public Volgenerique(int id, Timestamp heureDepart, Timestamp heurearrivee, String lieuDepart, String lieuArrive, double montant, Facture facture) {
        this.id = id;
        this.heureDepart = heureDepart;
        this.heurearrivee = heurearrivee;
        this.lieuDepart = lieuDepart;
        this.lieuArrive = lieuArrive;
        this.montant = montant;
        this.facture = facture;
    }

    public Volgenerique( Timestamp heureDepart, Timestamp heurearrivee, String lieuDepart, String lieuArrive, double montant) {
 
        this.heureDepart = heureDepart;
        this.heurearrivee = heurearrivee;
        this.lieuDepart = lieuDepart;
        this.lieuArrive = lieuArrive;
        this.montant = montant;
    }
    

    public String getLieuDepart() {
        return lieuDepart;
    }

    public void setLieuDepart(String lieuDepart) {
        this.lieuDepart = lieuDepart;
    }

    public String getLieuArrive() {
        return lieuArrive;
    }

    public void setLieuArrive(String lieuArrive) {
        this.lieuArrive = lieuArrive;
    }

    @Override
    public String toString() {
        return "Volgenerique{" + "id=" + id + ", heureDepart=" + heureDepart + ", heurearrivee=" + heurearrivee + ", lieuDepart=" + lieuDepart + ", lieuArrive=" + lieuArrive + ", montant=" + montant + ", facture=" + facture + '}';
    }

  
    
 
}