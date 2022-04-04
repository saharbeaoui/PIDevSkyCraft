/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entites.Vol;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.VolService;

/**
 * FXML Controller class
 *
 * @author ahmedshil
 */
public class AjoutVolController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    

    @FXML
    private TextField lieudepart;

    @FXML
    private TextField lieuarrive;

    @FXML
    private TextField montant;
    @FXML
    private DatePicker datedepart;
    @FXML
    private DatePicker datearrive;

    @FXML
    private TextField heuredepart;

    @FXML
    private TextField minutedepart;

    @FXML
    private TextField heurearrive;

    @FXML
    private TextField minutearrive;
    @FXML
    private TextField designation;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    void AjouterVol(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
    VolService vs = new VolService();
       /*  Timestamp depart = new Timestamp(datedepart.getValue().getYear(),datedepart.getValue().getMonthValue()
                 , datedepart.getValue().getDayOfMonth(), Integer.valueOf(heuredepart.getText()),
                 Integer.valueOf(minutedepart.getText()) , 0, 0);
         
         System.out.println(datedepart.getValue().getYear());
         Timestamp arrive = new Timestamp(datearrive.getValue().getYear(),datearrive.getValue().getMonthValue()
                 , datearrive.getValue().getDayOfMonth(), Integer.valueOf(heurearrive.getText()),
                 Integer.valueOf(minutearrive.getText()) , 0, 0);*/
       Timestamp depart = new Timestamp(Date.valueOf(datedepart.getValue()).getTime());
       depart.setHours(Integer.valueOf(heuredepart.getText()));
       depart.setMinutes(Integer.valueOf(minutedepart.getText()));
       Timestamp arrive = new Timestamp(Date.valueOf(datearrive.getValue()).getTime());
       arrive.setHours(Integer.valueOf(heurearrive.getText()));
       arrive.setMinutes(Integer.valueOf(minutearrive.getText()));
    String ldepart = lieudepart.getText();
    String larrive = lieuarrive.getText();
    int dsgn = Integer.valueOf(designation.getText());
    Double mtn = Double.valueOf(montant.getText());
    
    Vol vol = new Vol(depart,ldepart,larrive,arrive,mtn);
    System.out.println(vol.toString());
    vs.ajouterVol(vol, dsgn);
            Parent affichage = FXMLLoader
        .load(getClass().getResource("../View/Vol.fxml"));
        Scene affichageConsultationScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageConsultationScene);
        window.show();
    
    }
         @FXML
    void GoVolgenerique(ActionEvent event) throws IOException {
        Parent affichage = FXMLLoader
        .load(getClass().getResource("../View/VolGenerique.fxml"));
        Scene affichageConsultationScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageConsultationScene);
        window.show();
    }
     @FXML
    void GoVol(ActionEvent event) throws IOException {
        Parent affichage = FXMLLoader
        .load(getClass().getResource("../View/Vol.fxml"));
        Scene affichageConsultationScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageConsultationScene);
        window.show();
    }
     @FXML
    void GoReservation(ActionEvent event) throws IOException {
        Parent affichage = FXMLLoader
        .load(getClass().getResource("../View/Reservation.fxml"));
        Scene affichageConsultationScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageConsultationScene);
        window.show();
    }
    @FXML
     void GoFacture(ActionEvent event) throws IOException {
        Parent affichage = FXMLLoader
        .load(getClass().getResource("../View/Facture.fxml"));
        Scene affichageConsultationScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageConsultationScene);
        window.show();
    }
}
