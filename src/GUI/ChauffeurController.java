/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Services.ChauffeurService;
import entites.Chauffeur;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author sahar
 */
public class ChauffeurController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfCin;
    @FXML
    private TextField tfTel;
    @FXML
    private TextField tfEmail;
    
    @FXML
    private TextField tfBan;
    @FXML
    private Button btnajouterchauff;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterChauffeur(ActionEvent event) {
        
        String nom_chauffeur = tfNom.getText();
        
        String prenom_chauffeur = tfPrenom.getText();
        String cin_chauffeur = tfCin.getText();
        String num_tel_chauffeur = tfTel.getText();
        
        String email_chauffeur = tfEmail.getText();
        String num_compte_bancaire = tfBan.getText();
       
        Chauffeur c = new Chauffeur(nom_chauffeur,prenom_chauffeur,cin_chauffeur,num_tel_chauffeur,email_chauffeur,num_compte_bancaire);
        c.setNom_chauffeur(nom_chauffeur);
        c.setPrenom_chauffeur(prenom_chauffeur);
        c.setCin_chauffeur(cin_chauffeur);
        c.setNum_tel_chauffeur(num_tel_chauffeur);
        c.setEmail_chauffeur(email_chauffeur);
        c.setNum_compte_bancaire(num_compte_bancaire);
        System.out.println(c.getNom_chauffeur());
        ChauffeurService cs = new ChauffeurService();
        cs.ajouterChauffeur(c);
        
    }
    
}
