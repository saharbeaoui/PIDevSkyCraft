/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import connexion.Connexion;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import tools.MaConnexion;

/**
 * FXML Controller class
 *
 * @author sahar
 */
public class AfficherVoitureController implements Initializable {

    @FXML
    private ListView<String> tfListeV;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       MaConnexion c = new MaConnexion();
        Connection cnx = c.getCnx();
        String req = "SELECT * from voiture";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                String matricule = rs.getString("matricule");
                String couleur = rs.getString("couleur");
                String marque = rs.getString("marque");
                String list = marque + "/" + matricule + "/" + couleur ;
                tfListeV.getItems().add(list);
            }

      } catch (SQLException ex) {
            System.out.println(ex.getMessage());;
        }

    }
}