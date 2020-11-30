package fr.eql.ai108.annuaire.ihm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class BoutonPannel extends GridPane {
	private Button btnVisualiserAnnuaire = new Button();
	private TablePannel tp = new TablePannel();

	public BoutonPannel() {
		btnVisualiserAnnuaire = new Button("Visualiser l'Annuaire");
		btnVisualiserAnnuaire.setPrefSize(200,100);
		addRow(0, btnVisualiserAnnuaire);

		setVgap(20);
		setHgap(10);
		setPadding(new Insets(20.));

		btnVisualiserAnnuaire.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// Trier la tableView par ordre alphabetique (Nom)
				MainPanel root = (MainPanel) getScene().getRoot();
				root.setRight(tp);    //Affichage de la tableView				
			}
		});
	}

	public Button getBtnVisualiserTable() {
		return btnVisualiserAnnuaire;
	}

	public void setBtnVisualiserTable(Button btnVisualiserTable) {
		this.btnVisualiserAnnuaire = btnVisualiserTable;
	}






}
