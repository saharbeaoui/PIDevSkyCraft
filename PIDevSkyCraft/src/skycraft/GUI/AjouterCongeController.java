/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skycraft.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import skycraft.entities.Conge;
import skycraft.services.CongeService;
/**
 * FXML Controller class
 *
 * @author sinad
 */
public class AjouterCongeController implements Initializable {

    @FXML
    private TextField txtid;
    @FXML
    private TextField txtnbr_jour;
    @FXML
    private TextField txtdate_conge;
    @FXML
    private Button btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addconge(ActionEvent event) {
        String id=txtid.getText();
        String nbr_jour=txtnbr_jour.getText();
        String date_conge=txtdate_conge.getText();
        Conge conge=new Conge(1,1,5,date_conge);
        CongeService congeService=new CongeService();
        congeService.ajouterConge(conge);
        
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("AfficherConge.fxml"));
            Parent root=loader.load();
            AfficherCongeController ac=loader.getController();
            ac.setList(congeService.afficherConge().toString());
            txtid.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
