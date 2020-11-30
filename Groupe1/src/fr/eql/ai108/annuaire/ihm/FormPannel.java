package fr.eql.ai108.annuaire.ihm;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FormPannel extends VBox {
	private VBox vBoxFormulaire = new VBox(100);
	private Label lblNom;
	private TextField tfNom;
	private Label lblPrenom;
	private TextField tfPrenom;
	private Label lblDepartement;
	private TextField tfDepartement;
	private Label lblPromo;
	private TextField tfPromo;
	private Label lblAnnee;
	private TextField tfAnnee;
	private HBox hBoxNom;
	private HBox hBoxPrenom;
	private HBox hBoxDepartement;
	private HBox hBoxPromo;
	private HBox hBoxAnnee;

	public FormPannel() {
		hBoxNom = new HBox(92);
		lblNom = new Label("Nom :");
		tfNom = new TextField("");
		tfNom.setPrefSize(150, 5);
		hBoxNom.getChildren().addAll(lblNom, tfNom);
		
		hBoxPrenom = new HBox(78);
		lblPrenom = new Label("Prénom :");
		tfPrenom = new TextField("");
		tfPrenom.setPrefSize(150, 5);
		hBoxPrenom.getChildren().addAll(lblPrenom, tfPrenom);
		
		hBoxDepartement = new HBox(50);
		lblDepartement = new Label("Département :");
		tfDepartement = new TextField("");
		tfDepartement.setPrefSize(150, 5);
		hBoxDepartement.getChildren().addAll(lblDepartement, tfDepartement);
		
		hBoxPromo = new HBox(64);
		lblPromo = new Label("Promotion :");
		tfPromo = new TextField("");
		tfPromo.setPrefSize(150, 5);
		hBoxPromo.getChildren().addAll(lblPromo, tfPromo);
		
		hBoxAnnee = new HBox(10);
		lblAnnee = new Label("Année de promotion :");
		tfAnnee = new TextField("");
		tfAnnee.setPrefSize(150, 5);
		hBoxAnnee.getChildren().addAll(lblAnnee, tfAnnee);
		
		getChildren().addAll(hBoxNom, hBoxPrenom, hBoxDepartement, hBoxPromo, hBoxAnnee);
		setPadding(new Insets(15, 15, 50, 15));
		setSpacing(10);
	}


	public VBox getvBoxFormulaire() {
		return vBoxFormulaire;
	}


	public void setvBoxFormulaire(VBox vBoxFormulaire) {
		this.vBoxFormulaire = vBoxFormulaire;
	}


	public Label getLblNom() {
		return lblNom;
	}


	public void setLblNom(Label lblNom) {
		this.lblNom = lblNom;
	}


	public TextField getTfNom() {
		return tfNom;
	}


	public void setTfNom(TextField tfNom) {
		this.tfNom = tfNom;
	}


	public Label getLblPrenom() {
		return lblPrenom;
	}


	public void setLblPrenom(Label lblPrenom) {
		this.lblPrenom = lblPrenom;
	}


	public TextField getTfPrenom() {
		return tfPrenom;
	}


	public void setTfPrenom(TextField tfPrenom) {
		this.tfPrenom = tfPrenom;
	}


	public Label getLblDepartement() {
		return lblDepartement;
	}


	public void setLblDepartement(Label lblDepartement) {
		this.lblDepartement = lblDepartement;
	}


	public TextField getTfDepartement() {
		return tfDepartement;
	}


	public void setTfDepartement(TextField tfDepartement) {
		this.tfDepartement = tfDepartement;
	}


	public Label getLblPromo() {
		return lblPromo;
	}


	public void setLblPromo(Label lblPromo) {
		this.lblPromo = lblPromo;
	}


	public TextField getTfPromo() {
		return tfPromo;
	}


	public void setTfPromo(TextField tfPromo) {
		this.tfPromo = tfPromo;
	}


	public Label getLblAnnee() {
		return lblAnnee;
	}


	public void setLblAnnee(Label lblAnnee) {
		this.lblAnnee = lblAnnee;
	}


	public TextField getTfAnnee() {
		return tfAnnee;
	}


	public void setTfAnnee(TextField tfAnnee) {
		this.tfAnnee = tfAnnee;
	}


	public HBox gethBoxNom() {
		return hBoxNom;
	}


	public void sethBoxNom(HBox hBoxNom) {
		this.hBoxNom = hBoxNom;
	}


	public HBox gethBoxPrenom() {
		return hBoxPrenom;
	}


	public void sethBoxPrenom(HBox hBoxPrenom) {
		this.hBoxPrenom = hBoxPrenom;
	}


	public HBox gethBoxDepartement() {
		return hBoxDepartement;
	}


	public void sethBoxDepartement(HBox hBoxDepartement) {
		this.hBoxDepartement = hBoxDepartement;
	}


	public HBox gethBoxPromo() {
		return hBoxPromo;
	}


	public void sethBoxPromo(HBox hBoxPromo) {
		this.hBoxPromo = hBoxPromo;
	}


	public HBox gethBoxAnnee() {
		return hBoxAnnee;
	}


	public void sethBoxAnnee(HBox hBoxAnnee) {
		this.hBoxAnnee = hBoxAnnee;
	}

}
