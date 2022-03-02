package skycraft.tests;

//import edu.esprit.entities.Personne;
//import edu.esprit.services.PersonneService;
import java.sql.Date;
import skycraft.tools.MaConnexion;
import skycraft.entities.Absence;
import skycraft.entities.Conge;
import skycraft.entities.Contrat;
import skycraft.services.ContratService;


import skycraft.entities.enums.etat_ab;
import skycraft.entities.enums.poste;
import skycraft.entities.enums.type;
import skycraft.services.AbsenceService;
import skycraft.services.CongeService;

public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MaConnexion cm = MaConnexion.getInstance();
     // AbsenceService absenceService = new AbsenceService();
        //test ajoute_absence
 //Absence absence = new Absence(1, new Date(2022,1,1),etat_ab.NonJustifier );
  //absenceService.ajouterAbsence(absence);
        //test affichage_absence
       //  System.out.println(absenceService.afficherAbsence());
        //modifier absence
//          Absence absence2 = new Absence(2, new Date(2022,1,2),etat_ab.NonJustifier);
//  absence2.setEtat_ab(etat_ab.NonJustifier);
//  absenceService.ModifierAbsence(absence2);
//supprimer absence
//Absence absence2 = new Absence(1, new Date(2022,1,1),etat_ab.justifier);
//absenceService.supprimerAbsence(1);


//ContratService contratService=new ContratService();
//contratService.AfficherAbsenceFiltre(2);
              //test ajoute contrat 
              //Contrat contrat=new Contrat(1,type.CS,poste.car,2);
              //contratService.ajouterContrat(contrat);
              //test affichage_contrat
              //System.out.println(contratService.afficherContrat());
              
                     //modifier contrat
//                           Contrat contrat2 = new Contrat(3, 1,type.CS,poste.car,3);
//  contrat2.setPoste(poste.hotel);
//  contratService.ModifierContrat(contrat2);
////supprimer contrat
//Contrat contrat2 = new Contrat(4);
//contratService.supprimerContrat(4);
//recherche contrat
//contratService.Recherche(3);
//System.out.println(contratService.Recherche(3));
//contratService.trierContrat.
    CongeService congeService=new CongeService();
//    Conge conge=new Conge(1,10,"10/10/2010");
//              congeService.ajouterConge(conge);
System.out.println(congeService.afficherConge());
    }
}
