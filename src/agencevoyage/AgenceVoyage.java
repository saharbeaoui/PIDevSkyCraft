/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */

package agencevoyage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ahmedshil
 */
public class AgenceVoyage extends Application {

    @Override
    public void start(Stage stage) throws Exception {
      FXMLLoader loader= new FXMLLoader(getClass().getResource("../View/Vol.fxml"));
        Parent root= loader.load();
        Scene scene= new Scene(root);
        
        stage.setTitle("Vols");
        stage.setScene(scene);
        stage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}