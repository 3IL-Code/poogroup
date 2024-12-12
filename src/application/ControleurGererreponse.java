package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class ControleurGererreponse {

    @FXML
    private BorderPane Recompense;

    @FXML
    private Button idajout;

    @FXML
    private TextField idcat;

    @FXML
    private Button idmodi;

    @FXML
    private Button idsuprime;

    @FXML
    void gererRecompense(ActionEvent event) {

    }

}
//	    	int point = Integer.parseInt(Point3D.getText());
//			String recompense = application.Recompense.getSelectionModel().getSelectedItem();
//
//			// Enregistrement de la récompense dans la base de données
//			Connection conn = null;
//			try {
//				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/poo", "root", "");
//				PreparedStatement pstmt = conn.prepareStatement("INSERT INTO recompense (desc_recomp, point) VALUES (?, ?)");
//				pstmt.setString(1, recompense);
//				pstmt.setInt(2, point);
//				pstmt.executeUpdate();
//				pstmt.close();
//			} catch (SQLException e) {
//				System.err.println(e.getMessage());
//			} finally {
//				try {
//					if (conn != null) {
//						conn.close();
//					}
//				} catch (SQLException e) {
//					System.err.println(e.getMessage());
//				}
//			}
//
//			// Mise à jour de l'affichage
//			recompenseLabel.setText("Récompense attribuée : " + recompense);
//		}

	    

	


