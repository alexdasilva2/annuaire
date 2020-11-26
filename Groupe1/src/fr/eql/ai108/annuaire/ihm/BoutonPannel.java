package fr.eql.ai108.annuaire.ihm;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class BoutonPannel extends GridPane {
	private Button btnVisualiserAnnuaire = new Button();

	public BoutonPannel() {
		btnVisualiserAnnuaire = new Button("Visualiser l'Annuaire");
		btnVisualiserAnnuaire.setPrefSize(200,100);
		addRow(0, btnVisualiserAnnuaire);
		
		setVgap(20);
		setHgap(10);
		setPadding(new Insets(20.));
	}

	public Button getBtnVisualiserTable() {
		return btnVisualiserAnnuaire;
	}

	public void setBtnVisualiserTable(Button btnVisualiserTable) {
		this.btnVisualiserAnnuaire = btnVisualiserTable;
	}

	
	
	

	
}
