/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entites.Reservation;
import entites.Vol;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.ReservationService;
import service.VolService;

/**
 * FXML Controller class
 *
 * @author ahmedshil
 */
public class AjoutReservationController implements Initializable {
   @FXML
    private TableView<Vol> voltab;
    @FXML
    private TableColumn<Vol, Integer> id;
    @FXML
    private TableColumn<Vol, Integer> facture;
    @FXML
    private TableColumn<Vol, String> lieudepart;
    @FXML
    private TableColumn<Vol, String> lieuarrive;
    @FXML
    private TableColumn<Vol, Timestamp> datedepart;
    @FXML
    private TableColumn<Vol, Timestamp> datearrive;
    @FXML
    private TableColumn<Vol, Double> montant;
    @FXML
    private TableColumn<Vol, Integer> fact;
    @FXML
    private DatePicker recherchedate;
    @FXML
    private TextField chercherlieu;
     @FXML
    private TextField nbrp;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        lieudepart.setCellValueFactory(new PropertyValueFactory<>("lieuDepart"));
        lieuarrive.setCellValueFactory(new PropertyValueFactory<>("lieuArrive"));
        datedepart.setCellValueFactory(new PropertyValueFactory<>("dateDepart"));
        datearrive.setCellValueFactory(new PropertyValueFactory<>("dateArrivee"));
        montant.setCellValueFactory(new PropertyValueFactory<>("montant"));
        fact.setCellValueFactory(new PropertyValueFactory<>("facture"));
         try {
             voltab.setItems(getVols());
         } catch (SQLException ex) {
             Logger.getLogger(VolController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(VolController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    
    @FXML
    public ObservableList<Vol> getVols() throws SQLException, ClassNotFoundException{
        ObservableList<Vol> vols = FXCollections.observableArrayList();
        VolService vs = new VolService();
        for(Vol v: vs.afficherVol()){
            Vol spp=new Vol(v.getId(),v.getDateDepart(),v.getLieuDepart(),v.getLieuArrive(),v.getDateArrivee(),v.getMontant(),v.getFacture());
            vols.add(spp);
        }
          return vols;
      }
    @FXML
    void chercherdate(ActionEvent event) throws ClassNotFoundException, SQLException {
        if(Date.valueOf(recherchedate.getValue()).toInstant()!=null)
        {
            Date Ddebt = new Date(Date.valueOf(recherchedate.getValue()).getTime());
        System.out.println(Ddebt);
       ObservableList<Vol> vols = FXCollections.observableArrayList();
        VolService vs = new VolService();
        for(Vol v: vs.findbydate(Ddebt)){
            Vol spp=new Vol(v.getId(),v.getDateDepart(),v.getLieuDepart(),v.getLieuArrive(),v.getDateArrivee(),v.getMontant(),v.getFacture());
            vols.add(spp);
        }
        voltab.getItems().clear();
        voltab.setItems(vols); 
        }
        else{
            voltab.setItems(getVols());
        }
       
    }

    @FXML
    void rechercheparlieu(ActionEvent event) throws ClassNotFoundException, SQLException {
  if(!chercherlieu.getText().equals(""))
        {
      
       ObservableList<Vol> vols = FXCollections.observableArrayList();
        VolService vs = new VolService();
        for(Vol v: vs.findbylieu(chercherlieu.getText())){
            Vol spp=new Vol(v.getId(),v.getDateDepart(),v.getLieuDepart(),v.getLieuArrive(),v.getDateArrivee(),v.getMontant(),v.getFacture());
            vols.add(spp);
        }
        voltab.getItems().clear();
        voltab.setItems(vols); 
        }
  else {
            voltab.setItems(getVols());
        }
    }
     @FXML
    void AjouterReservationVol(ActionEvent event) throws ClassNotFoundException, SQLException, IOException, Exception {
    VolService vs = new VolService();
    ReservationService rs= new ReservationService();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);          
        alert.setTitle("Agance");
        alert.setHeaderText("Reserver un vol");
    if(voltab.getSelectionModel().getSelectedItem()!=null){
        Vol vol = voltab.getSelectionModel().getSelectedItem();
        Reservation rv = new Reservation(1,vol,vol.getDateDepart(),Integer.parseInt(nbrp.getText()));
        if((rs.ajouterReservationVol(rv, vol.getId()))&&(Integer.parseInt(nbrp.getText())>0))
        {
            alert.setContentText("Reservation ajouté avec succès !");
            alert.showAndWait();
        Parent affichage = FXMLLoader
        .load(getClass().getResource("../View/Vol.fxml"));
        Scene affichageConsultationScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageConsultationScene);
        window.show();
        }
        else{
            alert.setContentText("Vous devez Ajouter le nombre de personne pour ce vol");
            alert.showAndWait();
        }
    }
        else{
            alert.setContentText("Vous devez choisir un vol");
            alert.showAndWait();
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
}
