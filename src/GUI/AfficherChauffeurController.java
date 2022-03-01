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
public class AfficherChauffeurController implements Initializable {

    @FXML
    private ListView<String> tfListeV;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       MaConnexion c = new MaConnexion();
        Connection cnx = c.getCnx();
        String req = "SELECT * from chauffeur";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                String nom_chauffeur = rs.getString("nom_chauffeur");
                String prenom_chauffeur = rs.getString("prenom_chauffeur");
                int cin_chauffeur = rs.getInt("cin_chauffeur");
                int num_tel_chauffeur = rs.getInt("num_tel_chauffeur");
                String email_chauffeur = rs.getString("email_chauffeur");
                String num_compte_bancaire = rs.getString("num_compte_bancaire");

                String list = nom_chauffeur + "/" + prenom_chauffeur + "/" + cin_chauffeur+"/"+num_tel_chauffeur+"/"+email_chauffeur+"/"+num_compte_bancaire ;
                tfListeV.getItems().add(list);
            }

      } catch (SQLException ex) {
            System.out.println(ex.getMessage());;
        }

    }
}