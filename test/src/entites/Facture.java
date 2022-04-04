package entites;
public class Facture {
   private int id ;
   private  int designation ;
   private int nbr;
   private  double prix_unitaire ;
   private  double prix_total ;  

    public Facture()  {

    }

    public Facture(int designation, double prix_unitaire) {
        this.designation = designation;
        this.prix_unitaire = prix_unitaire;
    }

    public Facture(int id, int designation, int nbr, double prix_unitaire, double prix_total) {
        this.id = id;
        this.designation = designation;
        this.nbr = nbr;
        this.prix_unitaire = prix_unitaire;
        this.prix_total = prix_total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDesignation() {
        return designation;
    }

    public void setDesignation(int designation) {
        this.designation = designation;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public double getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(double prix_total) {
        this.prix_total = prix_total;
    }

    @Override
    public String toString() {
        return "Facture{" + "id=" + id + ", designation=" + designation + ", nbr=" + nbr + ", prix_unitaire=" + prix_unitaire + ", prix_total=" + prix_total + '}';
    }

}