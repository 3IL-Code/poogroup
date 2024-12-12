package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


public class Menuprincipal extends Application{
	


	    @FXML
	    private Button consulter;

	    @FXML
	    private Button gererCollecteur;

	    @FXML
	    private Button gererRecomp;

	    @FXML
	    private Button gererRequet;

	    @FXML
	    private Button idcitoyen;

	    @FXML
	    private StackPane root;

	    @FXML
	    private Button sortir;

	    @FXML
	    private BorderPane collecteur;



	    @FXML
	    private BorderPane Recompense;

	    @FXML
	    private Pane Citoyen;
	    @FXML
	    private BorderPane Requette;

	    @FXML
	public void gererCollecteur(ActionEvent e) throws IOException {
		collecteur = FXMLLoader.load(getClass().getResource("gererCollecteur.fxml"));
		if(root.getChildren().isEmpty()) {
			 root.getChildren().add(collecteur);
		} else {
			root.getChildren().clear();
			root.getChildren().add(collecteur);
		}
	}
	
	@FXML
	public void gererRecompense(ActionEvent e) throws IOException{
		Recompense = FXMLLoader.load(getClass().getResource("gererRecompense.fxml"));
		if(root.getChildren().isEmpty()) {
			 root.getChildren().add(Recompense);
		} else {
			root.getChildren().clear();
			root.getChildren().add(Recompense);
		}
	}
	
	@FXML
	public void gererRequette(ActionEvent e) throws IOException{
		Requette = FXMLLoader.load(getClass().getResource("gererRequette.fxml"));
		if(root.getChildren().isEmpty()) {
			 root.getChildren().add(Requette);
		} else {
			root.getChildren().clear();
			root.getChildren().add(Requette);
		}
	}
	public void gerercitoyen(ActionEvent e) throws IOException{
		Citoyen = FXMLLoader.load(getClass().getResource("gererCitoyen.fxml"));
		if(root.getChildren().isEmpty()) {
			 root.getChildren().add(Citoyen);
		} else {
			root.getChildren().clear();
			root.getChildren().add(Citoyen);
		}
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
