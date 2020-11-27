package fr.eql.ai108.annuaire.ihm;

import java.io.RandomAccessFile;

import fr.eql.ai108.annuaire.model.Stagiaire;
import fr.eql.ai108.annuaire.model.StagiaireDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class TablePannel extends AnchorPane {
	private static  StagiaireDao dao = new StagiaireDao();
	private static ObservableList<Stagiaire> observableStagiaires;
	private static TableView<Stagiaire> tableView;
	private static RandomAccessFile raf;
	
	@SuppressWarnings("unchecked")
	public TablePannel() {
		observableStagiaires = FXCollections.observableArrayList(dao.stagiaireFromBinaryFile(raf)); //écrire la méthode getAll()
		tableView = new TableView<>(observableStagiaires);
		TableColumn<Stagiaire, String> colNom = new TableColumn<>("Nom");
		colNom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
		colNom.setStyle("-fx-alignment : CENTER");
		TableColumn<Stagiaire, String> colPrenom = new TableColumn<>("Prenom");
		colPrenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
		colPrenom.setStyle("-fx-alignment : CENTER");
		TableColumn<Stagiaire, Integer> colDepartement = new TableColumn<>("Departement");
		colDepartement.setCellValueFactory(new PropertyValueFactory<>("Departement"));
		colDepartement.setStyle("-fx-alignment : CENTER");
		TableColumn<Stagiaire, String> colNomPromo = new TableColumn<>("Promotion");
		colNomPromo.setCellValueFactory(new PropertyValueFactory<>("Promotion"));
		colNomPromo.setStyle("-fx-alignment : CENTER");
		TableColumn<Stagiaire, Integer> colAnnee = new TableColumn<Stagiaire, Integer>("Annee");
		colAnnee.setCellValueFactory(new PropertyValueFactory<>("Annee"));
		colAnnee.setStyle("-fx-alignment : CENTER");
		
		tableView.getColumns().addAll(colNom, colPrenom, colDepartement, colNomPromo, colAnnee);
		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		getChildren().add(tableView);
		
		setPrefSize(1000, 500);
		AnchorPane.setTopAnchor(tableView, 5.);
		AnchorPane.setBottomAnchor(tableView, 5.);
		AnchorPane.setRightAnchor(tableView, 5.);
		AnchorPane.setLeftAnchor(tableView, 5.);
	}

	public static StagiaireDao getDao() {
		return dao;
	}

	public static void setDao(StagiaireDao dao) {
		TablePannel.dao = dao;
	}

	public static ObservableList<Stagiaire> getObservableStagiaires() {
		return observableStagiaires;
	}

	public static void setObservableStagiaires(ObservableList<Stagiaire> observableStagiaires) {
		TablePannel.observableStagiaires = observableStagiaires;
	}

	public static TableView<Stagiaire> getTableView() {
		return tableView;
	}

	public static void setTableView(TableView<Stagiaire> tableView) {
		TablePannel.tableView = tableView;
	}

	public static RandomAccessFile getRaf() {
		return raf;
	}

	public static void setRaf(RandomAccessFile raf) {
		TablePannel.raf = raf;
	}

	
	
	
}
