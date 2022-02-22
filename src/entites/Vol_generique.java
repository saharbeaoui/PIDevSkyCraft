/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 *
 * @author user
 */
public class Vol_generique {
   private int idVolGenerique ;
   private LocalDate jour ;
   private  LocalTime heureDepart ;
   private  LocalTime heure_arrivee ;

    public Vol_generique(int idVolGenerique, LocalDate jour, LocalTime heureDepart, LocalTime heure_arrivee) {
        this.idVolGenerique = idVolGenerique;
        this.jour = jour;
        this.heureDepart = heureDepart;
        this.heure_arrivee = heure_arrivee;
    }

    public int getIdVolGenerique() {
        return idVolGenerique;
    }

    public LocalDate getJour() {
        return jour;
    }

    public LocalTime getHeureDepart() {
        return heureDepart;
    }

    public LocalTime getHeure_arrivee() {
        return heure_arrivee;
    }

    public void setIdVolGenerique(int idVolGenerique) {
        this.idVolGenerique = idVolGenerique;
    }

    public void setJour(LocalDate jour) {
        this.jour = jour;
    }

    public void setHeureDepart(LocalTime heureDepart) {
        this.heureDepart = heureDepart;
    }

    public void setHeure_arrivee(LocalTime heure_arrivee) {
        this.heure_arrivee = heure_arrivee;
    }

    @Override
    public String toString() {
        return "VolGenerique{" + "idVolGenerique=" + idVolGenerique + ", jour=" + jour + ", heureDepart=" + heureDepart + ", heure_arrivee=" + heure_arrivee + '}';
    }
    

   public int getDureeHours(){
      return this.heure_arrivee.getHour()-this.heureDepart.getHour();
 
   }
   
   public int getDureeMinutes(){
      return this.heure_arrivee.getMinute()-this.heureDepart.getMinute();}
}