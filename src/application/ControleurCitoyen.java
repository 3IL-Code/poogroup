package application;



import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Button;


public class ControleurCitoyen {
	 @FXML
	    private TableView<Citoyen> tableview;
	@FXML
    private TableColumn<Citoyen, String> colAdress;

    @FXML
    private TableColumn<Citoyen, Integer> colid;

    @FXML
    private TableColumn<Citoyen, String> colnom;

    @FXML
    private TableColumn<Citoyen, Integer> colpoint;

    @FXML
    private TableColumn<Citoyen, Integer> coltel;
    @FXML
    private TextField adresse;

    @FXML
    private Button idaffect;

    @FXML
    private Button idajout;
    
    @FXML
    private TextField idnom;

    @FXML
    private TextField idcat;

    @FXML
    private Button idmod;

    @FXML
    private Button idsprim;

    @FXML
    private TextField point;

    @FXML
    private TextField tel;
    
    private Connection connection;

    private ObservableList<Citoyen> data = FXCollections.observableArrayList();


    private Connection getConnection() throws SQLException {
        try {
            // Charger le driver JDBC pour MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/poo", "root", " ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


        // Méthode pour charger les utilisateurs dans la TableView
        private void loadData() {
            data.clear();
            try {
                connection = getConnection();
                String query = "SELECT * FROM citoyen";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    data.add(new Citoyen(
                            resultSet.getInt("id_citoyen"),
                            resultSet.getString("nom_cit"),
                            resultSet.getInt("tel_cit"),
                            resultSet.getString("adress_cit"),
                            resultSet.getInt("point")
                    ));
                }
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Méthode d'ajout d'un utilisateur
        @FXML
        private void handleAdd() {
            try {
                connection = getConnection();
                String query = "INSERT INTO citoyen (id_citoyen, nom_cit,tel_cit,adress_cit,point ) VALUES (?, ?, ?,?,?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, Integer.parseInt(idcat.getText()));
                statement.setString(2,idnom.getText());
                statement.setInt(3, Integer.parseInt( tel.getText()));
                statement.setString(4,adresse.getText());
                statement.setInt(5, Integer.parseInt(point .getText()));
                statement.executeUpdate();
                connection.close();
                loadData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Méthode pour modifier un utilisateur
        @FXML
        private void handleUpdate() {
            try {
                connection = getConnection();
                String query = "UPDATE citoyen SET id_citoyen = ?, nom_cit = ?, tel_cit = ?,adress_cit=?,point=? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, Integer.parseInt(idcat.getText()));
                statement.setString(2,idnom.getText());
                statement.setInt(3, Integer.parseInt( tel.getText()));
                statement.setString(4,adresse.getText());
                statement.setInt(5, Integer.parseInt(point .getText()));
                statement.executeUpdate();
                connection.close();
                loadData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Méthode pour supprimer un utilisateur
        @FXML
        private void handleDelete() {
            try {
                connection = getConnection();
                String query = "DELETE FROM citoyen WHERE id_citoyen = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, tableview.getSelectionModel().getSelectedItem().getId());
                statement.executeUpdate();
                connection.close();
                loadData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Initialiser la TableView et charger les données
        @FXML
        public void initialize() {
            loadData();
            
            colid.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
            colnom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
            coltel.setCellValueFactory(cellData -> cellData.getValue().telProperty().asObject());
            colAdress.setCellValueFactory(cellData -> cellData.getValue().adresseProperty());
            colpoint .setCellValueFactory(cellData -> cellData.getValue().pointProperty().asObject());

            tableview.setItems(data);
            
            idajout.setOnAction(event ->handleAdd());
            idmod.setOnAction(event -> handleUpdate());
            idsprim.setOnAction(event -> handleDelete());
        }
    

    @FXML
    void affecterRecompense(ActionEvent event) {

    }

  
    

   
   

 

  
}

// Méthode pour modifier une personne dans la base de données



//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//import java.sql.*;
//
//	import javafx.event.ActionEvent;
//	import javafx.fxml.FXML;
//	import javafx.scene.control.Button;
//	import javafx.scene.control.TextField;
//
//	public class ControleurCitoyen implements Initializable{
//
//	    @FXML
//	    private Button idaffect;
//
//	    @FXML
//	    private Button idajout;
//
//	    @FXML
//	    private TextField idcat;
//
//	    @FXML
//	    private Button idmod;
//
//	    @FXML
//	    private Button idsprim;
//
//	    @FXML
//	    void gererRecompense(ActionEvent event) {
//	    	
//
//	    }
//	  
//	   
//
//	        @FXML
//	        private TextField citoyenField;
//
//	        @FXML
//	        private Label pointsLabel;
//
//	        @FXML
//	        private Label recompenseLabel;
//
//	        private Connection conn;
//
//	        @Override
//	        public void initialize(URL url, ResourceBundle resourceBundle) {
//	            // Connexion à la base de données
//	            try {
//	                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/poo", "root", " ");
//	            } catch (SQLException e) {
//	                System.err.println(e.getMessage());
//	            }
//	        }
//
//	        @FXML
//	        private void handleRechercherCitoyen() {
//	            // Récupération des points du citoyen dans la base de données
//	            String citoyen = citoyenField.getText();
//	            int points = getPointsCitoyen(citoyen);
//
//	            // Affichage des points du citoyen
//	            pointsLabel.setText("Points : " + points);
//	        }
//
//	        private int getPointsCitoyen(String citoyen) {
//	            int points = 0;
//	            try {
//	                PreparedStatement pstmt = conn.prepareStatement("SELECT point FROM citoyen WHERE nom = ?");
//	                pstmt.setString(1, citoyen);
//	                ResultSet rs = pstmt.executeQuery();
//	                if (rs.next()) {
//	                    points = rs.getInt("points");
//	                }
//	                rs.close();
//	                pstmt.close();
//	            } catch (SQLException e) {
//	                System.err.println(e.getMessage());
//	            }
//	            return points;
//	        }
//
//	        @FXML
//	        private void handleAffecterRecompense() {
//	            // Récupération des points du citoyen
//	            int points = Integer.parseInt(pointsLabel.getText().split(" : ")[1]);
//
//	            // Récupération de la récompense
//	            String recompense = getRecompense(points);
//
//	            // Affichage de la récompense
//	            recompenseLabel.setText("Récompense : " + recompense);
//
//	            // Soustraction des points de la récompense
//	            int pointsRestants = points - getPointsRecompense(recompense);
//
//	            // Affichage des points restants
//	            pointsLabel.setText("Points restants : " + pointsRestants);
//
//	            // Affichage d'une boîte alerte
//	            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//	            alert.setTitle("Récompense");
//	            alert.setHeaderText("Vous avez gagné une récompense !");
//	            alert.setContentText("Récompense : " + recompense + "\nPoints restants : " + pointsRestants);
//	            alert.showAndWait();
//	        }
//
//	        private String getRecompense(int points) {
//	            String recompense = "";
//	            try {
//	                PreparedStatement pstmt = conn.prepareStatement("SELECT desc_recomp FROM recompense WHERE points >= 80 and point <=119");
//	                pstmt.setInt(1, points);
//	                ResultSet rs = pstmt.executeQuery();
//	                if (rs.next()) {
//	                    recompense = rs.getString("nom");
//	                }
//	                rs.close();
//	                pstmt.close();
//	            } catch (SQLException e) {
//	                System.err.println(e.getMessage());
//	            }
//	            return recompense;
//	        }
//
//	        private int getPointsRecompense(String recompense) {
//	            int points = 0;
//	            try {
//	                PreparedStatement pstmt = conn.prepareStatement("SELECT point FROM recompense WHERE nom = ?");
//	                pstmt.setString(1, recompense);
//	                ResultSet rs = pstmt.executeQuery();
//	                if (rs.next()) {
//	                    points = rs.getInt("point");
//	                }
//	                rs.close();
//	                pstmt.close();
//	            } catch (SQLException e) {
//	                System.err.println(e.getMessage());
//	            }
//	            return points;
//	        }
//	    

	


