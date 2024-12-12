package application;


import javafx.application.Application;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class Administrateur extends  Application {



	@FXML
	private TextField pointsField;

	@FXML
	private ComboBox<String> recompenseCombo;

	@FXML
	private Label recompenseLabel;

	private ObservableList<String> recompense = FXCollections.observableArrayList();

	public void initialize(URL url, ResourceBundle resourceBundle) {
		// Connexion à la base de données
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/poo", "root", " ");
			// Récupération des récompenses enregistrées
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT desc_recomp FROM recompense");
			while (rs.next()) {
				recompense.add(rs.getString("desc_recomp"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		recompenseCombo.setItems(recompense);
	}

	@FXML
	private void gererRecompense() {
		int point = Integer.parseInt(pointsField.getText());
		String recompense = recompenseCombo.getSelectionModel().getSelectedItem();

		// Enregistrement de la récompense dans la base de données
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/poo", "root", "");
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO recompense (desc_recomp, point) VALUES (?, ?)");
			pstmt.setString(1, recompense);
			pstmt.setInt(2, point);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}

		// Mise à jour de l'affichage
		recompenseLabel.setText("Récompense attribuée : " + recompense);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub

	}

}



