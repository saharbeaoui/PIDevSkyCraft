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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.VolService;

/**
 * FXML Controller class
 *
 * @author yosr
 */
public class VolController implements Initializable {

    @FXML
    private TableView<Vol> voltab;
    @FXML
    private TableColumn<Vol, Integer> id;
    @FXML
    private TableColumn<Vol, String> lieudepart;
    @FXML
    private TableColumn<Vol, String> lieuarrive;
    @FXML
    private TableColumn<Vol, Timestamp> datedepart;
    @FXML
    private TableColumn<Vol, Timestamp> datearrivee;
    @FXML
    private TableColumn<Vol, Double> montant;
    @FXML
    private TableColumn<Vol, Integer> fact;
    @FXML
    private Button btnreserver;
    @FXML
    private Button btnsupprimer;
    @FXML
    private Button btnajouter;
    @FXML
    private DatePicker recherchedate;
    @FXML
    private TextField chercherlieu;
    @FXML
    private DatePicker datedepart1;
    @FXML
    private DatePicker datearrive1;

    @FXML
    private TextField heuredepart;

    @FXML
    private TextField minutedepart;

    @FXML
    private TextField heurearrive;

    @FXML
    private TextField minutearrive;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        lieudepart.setCellValueFactory(new PropertyValueFactory<>("lieuDepart"));
        lieuarrive.setCellValueFactory(new PropertyValueFactory<>("lieuArrive"));
        datedepart.setCellValueFactory(new PropertyValueFactory<>("dateDepart"));
        datearrivee.setCellValueFactory(new PropertyValueFactory<>("dateArrivee"));
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
         if(recherchedate.getValue()!=null)
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
    void SupprimerVol(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
    VolService vs = new VolService();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);          
        alert.setTitle("Agance");
        alert.setHeaderText("Supprission de vol");
    if(voltab.getSelectionModel().getSelectedItem()!=null){
        Vol vol = voltab.getSelectionModel().getSelectedItem();
        if(vs.supprimerVol(vol.getId()))
        {
            alert.setContentText("Vol supprimé avec succès !");
            alert.showAndWait();
        Parent affichage = FXMLLoader
        .load(getClass().getResource("../View/Vol.fxml"));
        Scene affichageConsultationScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageConsultationScene);
        window.show();
        }
        else{
            alert.setContentText("Vous devez choisir un Vol");
            alert.showAndWait();
        }
    }
        else{
            alert.setContentText("Vous devez choisir un Vol");
            alert.showAndWait();
        }
    }
    @FXML
    void AjouterVol(ActionEvent event) throws IOException {
Parent affichage = FXMLLoader
        .load(getClass().getResource("../View/AjoutVol.fxml"));
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
    @FXML
    void GoAjoutReservation(ActionEvent event) throws IOException {
        Parent affichage = FXMLLoader
        .load(getClass().getResource("../View/AjoutReservation.fxml"));
        Scene affichageConsultationScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageConsultationScene);
        window.show();
    }
    @FXML
    void ModifierVol(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
    VolService vs = new VolService();
       /*  Timestamp depart = new Timestamp(datedepart.getValue().getYear(),datedepart.getValue().getMonthValue()
                 , datedepart.getValue().getDayOfMonth(), Integer.valueOf(heuredepart.getText()),
                 Integer.valueOf(minutedepart.getText()) , 0, 0);
         
         System.out.println(datedepart.getValue().getYear());
         Timestamp arrive = new Timestamp(datearrive.getValue().getYear(),datearrive.getValue().getMonthValue()
                 , datearrive.getValue().getDayOfMonth(), Integer.valueOf(heurearrive.getText()),
                 Integer.valueOf(minutearrive.getText()) , 0, 0);*/
       Alert alert = new Alert(Alert.AlertType.INFORMATION);          
        alert.setTitle("Agance");
        alert.setHeaderText("Modification du vol");
       Timestamp depart = new Timestamp(Date.valueOf(datedepart1.getValue()).getTime());
       depart.setHours(Integer.valueOf(heuredepart.getText()));
       depart.setMinutes(Integer.valueOf(minutedepart.getText()));
       Timestamp arrive = new Timestamp(Date.valueOf(datearrive1.getValue()).getTime());
       arrive.setHours(Integer.valueOf(heurearrive.getText()));
       arrive.setMinutes(Integer.valueOf(minutearrive.getText()));
    if(voltab.getSelectionModel().getSelectedItem()!=null){
        Vol vol = voltab.getSelectionModel().getSelectedItem();
        
        if(vs.updateJour(vol.getId(),depart,arrive))
        {
            alert.setContentText("Vol modifié avec succès !");
            alert.showAndWait();
        Parent affichage = FXMLLoader
        .load(getClass().getResource("../View/Vol.fxml"));
        Scene affichageConsultationScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageConsultationScene);
        window.show();
        }
        else{
            alert.setContentText("Vous devez choisir un Vol");
            alert.showAndWait();
        }
    }
        else{
            alert.setContentText("Vous devez choisir un Vol");
            alert.showAndWait();
        }
    
    }
   
}
