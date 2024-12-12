package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class connexion extends Application{
	
	@FXML
	private Button conect;
	
	@FXML
	public void connexionAdmin(ActionEvent e) {
		Stage  stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		stage.close();
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("Menu.css").toExternalForm());
			Stage  primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.setTitle("Admin_Space");
			primaryStage.show();
		}catch(IOException ev) {
			ev.getMessage();
		}
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	
	}

}
