package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Citoyen {
	
	 private final IntegerProperty id ;
	    private final StringProperty nom;
	    private final IntegerProperty  tel;
	    private final StringProperty adresse;
	    private final IntegerProperty  point;
	    
	    public int getId() {
	        return id.get();
	    }
	    
	    public IntegerProperty  idProperty() {
			return id;
		}

	    public String getNom() {
	        return nom.get();
	    }

	    public StringProperty nomProperty() {
	        return nom;
	    }
	    public int getTel() {
	        return tel.get();
	    }

		public IntegerProperty telProperty() {
			return tel;
		}
		  public String getAdresse()  {
		        return adresse.get();
		    }

		public StringProperty adresseProperty() {
			return adresse;
		}

		  public int getPoint() {
		        return point.get();
		    }
		public IntegerProperty pointProperty() {
			return point;
		}

	    
	    public Citoyen(int id, String nom,int tel, String adresse,int point) {
	        this.id = new SimpleIntegerProperty(id);
	        this.nom = new SimpleStringProperty(nom);
	        this.tel= new SimpleIntegerProperty(tel);
	        this.adresse = new SimpleStringProperty(adresse);
	        this.point = new SimpleIntegerProperty(point);
	    }
	    
}
