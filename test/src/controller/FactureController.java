/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entites.Facture;
import entites.Vol;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.FactureService;
import service.VolService;

/**
 * FXML Controller class
 *
 * @author ahmedshil
 */
public class FactureController implements Initializable {
@FXML
    private TableView<Facture> voltab;
    @FXML
    private TableColumn<Facture, Integer> id;
    @FXML
    private TableColumn<Facture, Integer> designation;
    @FXML
    private TableColumn<Facture, Integer> nbr;
    @FXML
    private TableColumn<Facture, Double> prix_unitaire;
    @FXML
    private TableColumn<Facture, Double> prix_total;
    @FXML
    private TextField chercherdesignation;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         id.setCellValueFactory(new PropertyValueFactory<>("id"));
        designation.setCellValueFactory(new PropertyValueFactory<>("designation"));
        nbr.setCellValueFactory(new PropertyValueFactory<>("nbr"));
        prix_unitaire.setCellValueFactory(new PropertyValueFactory<>("prix_unitaire"));
        prix_total.setCellValueFactory(new PropertyValueFactory<>("prix_total"));
        
    try {
        voltab.setItems(getFactures());
    } catch (SQLException ex) {
        Logger.getLogger(FactureController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(FactureController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
@FXML
    public ObservableList<Facture> getFactures() throws SQLException, ClassNotFoundException{
        ObservableList<Facture> factures = FXCollections.observableArrayList();
        FactureService fs = new FactureService();
        for(Facture f : fs.afficherFacture()){
            Facture facture=new Facture(f.getId(),f.getDesignation(),f.getNbr(),f.getPrix_unitaire(),f.getPrix_total());
            factures.add(facture);
        }
          return factures;
      }
@FXML
    void recherchedesignation(ActionEvent event) throws ClassNotFoundException, SQLException {
  if(!chercherdesignation.getText().equals(""))
        {
      
       ObservableList<Facture> factures = FXCollections.observableArrayList();
        FactureService fs = new FactureService();
       
            Facture facture=fs.afficherFacturebydesignation(Integer.valueOf(chercherdesignation.getText()));
            factures.add(facture);
        
        voltab.getItems().clear();
        voltab.setItems(factures); 
        }
  else {
            voltab.setItems(getFactures());
        }
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
     @FXML
    void GoFactureReservation(ActionEvent event) throws IOException {
        Parent affichage = FXMLLoader
        .load(getClass().getResource("../View/AffichageReservationFacture.fxml"));
        Scene affichageFactureReservationScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageFactureReservationScene);
        window.show();
    }
}
