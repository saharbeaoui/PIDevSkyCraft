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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.ReservationService;
import service.VolService;

/**
 * FXML Controller class
 *
 * @author ahmedshil
 */
public class ReservationController implements Initializable {
@FXML
    private TableView<Reservation> voltab;
    @FXML
    private TableColumn<Reservation, Integer> id;
    @FXML
    private TableColumn<Reservation, Integer> nbr;
    @FXML
    private TableColumn<Reservation, Timestamp> date_reservation;
    @FXML
    private TableColumn<Reservation, Integer> iduser;
    @FXML
    private TableColumn<Reservation, Integer> vol;
    @FXML
    private TableColumn<Reservation, Integer> volgenerique;
    
    @FXML
    private DatePicker recherchedate;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nbr.setCellValueFactory(new PropertyValueFactory<>("nbr"));
        date_reservation.setCellValueFactory(new PropertyValueFactory<>("date_reservation"));
        iduser.setCellValueFactory(new PropertyValueFactory<>("iduser"));
        vol.setCellValueFactory(new PropertyValueFactory<>("vol"));
        volgenerique.setCellValueFactory(new PropertyValueFactory<>("volgenerique"));
            try {
             voltab.setItems(getReservationss());
         } catch (SQLException ex) {
             Logger.getLogger(VolController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(VolController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
            @FXML
    public ObservableList<Reservation> getReservationss() throws SQLException, ClassNotFoundException{
        ObservableList<Reservation> reservations = FXCollections.observableArrayList();
        ReservationService rs = new ReservationService();
        for(Reservation r: rs.afficherReservation()){
            Reservation spp=new Reservation(r.getId(),r.getVol(),r.getVolgenerique(),r.getNbr(),r.getDate_reservation(),r.getIduser());
            reservations.add(spp);
        }
          return reservations;
      }
    
      @FXML
    void chercherdate(ActionEvent event) throws ClassNotFoundException, SQLException {
        if(recherchedate.getValue()!=null)
        {
            Date Ddebt = new Date(Date.valueOf(recherchedate.getValue()).getTime());
        System.out.println(Ddebt);
       ObservableList<Reservation> reservations = FXCollections.observableArrayList();
       ReservationService rs = new ReservationService();
        for(Reservation r: rs.findbydate(Ddebt)){
             Reservation spp=new Reservation(r.getId(),r.getVol(),r.getVolgenerique(),r.getNbr(),r.getDate_reservation(),r.getIduser());
            reservations.add(spp);
        }
        voltab.getItems().clear();
        voltab.setItems(reservations); 
        }
        else{
            voltab.setItems(getReservationss());
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
    

