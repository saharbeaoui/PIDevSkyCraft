/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entites.Reservation;
import entites.Volgenerique;
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
import service.ReservationService;
import service.VolGeneriqueService;

/**
 * FXML Controller class
 *
 * @author ahmedshil
 */
public class AjoutReservationGeneriqueController implements Initializable {
    @FXML
    private TableView<Volgenerique> voltab;
 @FXML
    private TableColumn<Volgenerique, Integer> id;
 @FXML
    private TableColumn<Volgenerique, Integer> facture;
    @FXML
    private TableColumn<Volgenerique, String> lieudepart;

    @FXML
    private TableColumn<Volgenerique, String> lieuarrive;

    @FXML
    private TableColumn<Volgenerique, Timestamp> datedepart;

    @FXML
    private TableColumn<Volgenerique, Timestamp> datearrive;

    @FXML
    private TableColumn<Volgenerique, Double> montant;
    @FXML
    private TableColumn<Volgenerique, Integer> fact;

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
    private TextField nbrp;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                id.setCellValueFactory(new PropertyValueFactory<>("id"));
        lieudepart.setCellValueFactory(new PropertyValueFactory<>("lieuDepart"));
        lieuarrive.setCellValueFactory(new PropertyValueFactory<>("lieuArrive"));
        datedepart.setCellValueFactory(new PropertyValueFactory<>("heureDepart"));
        datearrive.setCellValueFactory(new PropertyValueFactory<>("heurearrivee"));
        montant.setCellValueFactory(new PropertyValueFactory<>("montant"));
        fact.setCellValueFactory(new PropertyValueFactory<>("facture"));
         try {
             voltab.setItems(getVols());
         } catch (SQLException ex) {
             Logger.getLogger(VolGeneriqueController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(VolGeneriqueController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    
    @FXML
    public ObservableList<Volgenerique> getVols() throws SQLException, ClassNotFoundException{
        ObservableList<Volgenerique> vols = FXCollections.observableArrayList();
        VolGeneriqueService vs = new VolGeneriqueService();
        for(Volgenerique v: vs.afficherVolGenerique()){
             Volgenerique spp=new Volgenerique(v.getId(),v.getHeureDepart(),v.getHeurearrivee(),v.getLieuDepart(),v.getLieuArrive(),v.getMontant(),v.getFacture());
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
       ObservableList<Volgenerique> vols = FXCollections.observableArrayList();
        VolGeneriqueService vs = new VolGeneriqueService();
        for(Volgenerique v: vs.findbydate(Ddebt)){
            Volgenerique spp=new Volgenerique(v.getId(),v.getHeureDepart(),v.getHeurearrivee(),v.getLieuDepart(),v.getLieuArrive(),v.getMontant(),v.getFacture());
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
      
       ObservableList<Volgenerique> vols = FXCollections.observableArrayList();
        VolGeneriqueService vs = new VolGeneriqueService();
        for(Volgenerique v: vs.findbylieu(chercherlieu.getText())){
            Volgenerique spp=new Volgenerique(v.getId(),v.getHeureDepart(),v.getHeurearrivee(),v.getLieuDepart(),v.getLieuArrive(),v.getMontant(),v.getFacture());
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
    VolGeneriqueService vs = new VolGeneriqueService();
    ReservationService rs= new ReservationService();
    Alert alert = new Alert(Alert.AlertType.INFORMATION);          
        alert.setTitle("Agance");
        alert.setHeaderText("Reserver un vol");
    if(voltab.getSelectionModel().getSelectedItem()!=null){
        Volgenerique vol = voltab.getSelectionModel().getSelectedItem();
        Reservation rv = new Reservation(vol,Integer.parseInt(nbrp.getText()),vol.getHeureDepart(),1);
        if((rs.ajouterReservationVolGenerique(rv, vol.getId()))&&(Integer.parseInt(nbrp.getText())>0))
        {
            alert.setContentText("Reservation ajouté avec succès !");
            alert.showAndWait();
        Parent affichage = FXMLLoader
        .load(getClass().getResource("../View/VolGenerique.fxml"));
        Scene affichageVolGeneriqueScene = new Scene(affichage);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(affichageVolGeneriqueScene);
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
