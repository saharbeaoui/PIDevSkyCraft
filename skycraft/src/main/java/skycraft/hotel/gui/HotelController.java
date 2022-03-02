/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skycraft.hotel.gui;

import Entities.Hotel;
import Services.HotelServices;
import java.io.PrintStream;
import java.net.URL;
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
public class HotelController implements Initializable {

    @FXML
    private TextField tfid;
    @FXML
    private TextField tflibellé;
    @FXML
    private TextField tfCaractéristiques;
    @FXML
    private Button btnajouterhotel;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterHotel(ActionEvent event) {
        
        String id_hotel = tfid.getText();
        
        String libellé_hotel = tflibellé.getText();
        String caractéristiques_hotel;
        caractéristiques_hotel = tfcaractéristiques.getText();
       
        Hotel h = new Hotel(id_hotel,libellé_hotel,caractéristiques_hotel);
        h.setid_hotel(id_hotel);
        h.setlibellé_hotel(libellé_hotel);
        h.setcaractéristiques_hotel(caractéristiques_hotel);
        PrintStream println = System.out.println(h.getid_hotel());
        HotelServices hs = new HotelServices();
        hs.ajouterChauffeur(h);
        
    }
}
    

