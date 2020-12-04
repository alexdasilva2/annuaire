package fr.eql.ai108.annuaire.ihm;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import fr.eql.ai108.annuaire.model.Noeud3;
import fr.eql.ai108.annuaire.model.Stagiaire;
import fr.eql.ai108.annuaire.model.StagiaireDao;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class BoutonPannel extends GridPane {
	private Button btnVisualiserAnnuaire = new Button();
	private TablePannel tp = new TablePannel();
	private Button btnCreation = new Button();
	private Label chemin = new Label("L'annuaire a bien été créé sur votre bureau \nC:/Users/formation/Desktop/annuaireArbreBinaire.txt");
	private static List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();

	public BoutonPannel() {
		
		btnVisualiserAnnuaire = new Button("Visualiser l'annuaire");
		btnVisualiserAnnuaire.setPrefSize(150,75);
		btnCreation = new Button("Créer l'annuaire");
		btnCreation.setPrefSize(150,75);
		addRow(0, btnCreation, btnVisualiserAnnuaire);
		
		chemin.setPadding(new Insets(15, 15, 500, 15));
		chemin.setStyle("-fx-font-size: 15");

		setVgap(20);
		setHgap(10);
		setPadding(new Insets(20.));

		btnVisualiserAnnuaire.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// Trier la tableView par ordre alphabetique (Nom)
				//stagiaires = StagiaireDao.trierRaf();
				MainPanel root = (MainPanel) getScene().getRoot();
				//root.setTp(tp);
				root.setRight(tp); //affichage de la tableview
			}
		});
		
		
		btnCreation.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				tp.getDao().compterChar();
				List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
				stagiaires = tp.getDao().stagiaireTrimFromTextFile();
				List<Noeud3> noeuds = new ArrayList<Noeud3>();
				Noeud3 racine = new Noeud3(stagiaires.get(0), null, null);
				noeuds.add(racine);
				for (int i =1; i < stagiaires.size(); i++) {
					Noeud3 noeud = new Noeud3(stagiaires.get(i), null, null);
					Noeud3.ajouterNoeud3(noeud, racine);
					noeuds.add(noeud);
				}
				tp.getDao().ecrireFichier(noeuds);
				MainPanel root = (MainPanel) getScene().getRoot();
				root.getLp().setBottom(chemin);

			}
		});

	}


	public Label getChemin() {
		return chemin;
	}


	public void setChemin(Label chemin) {
		this.chemin = chemin;
	}


	public Button getBtnCreation() {
		return btnCreation;
	}

	public void setBtnCreation(Button btnCreation) {
		this.btnCreation = btnCreation;
	}

	public Button getBtnVisualiserTable() {
		return btnVisualiserAnnuaire;
	}

	public void setBtnVisualiserTable(Button btnVisualiserTable) {
		this.btnVisualiserAnnuaire = btnVisualiserTable;
	}


	public Button getBtnVisualiserAnnuaire() {
		return btnVisualiserAnnuaire;
	}


	public void setBtnVisualiserAnnuaire(Button btnVisualiserAnnuaire) {
		this.btnVisualiserAnnuaire = btnVisualiserAnnuaire;
	}


	public TablePannel getTp() {
		return tp;
	}


	public void setTp(TablePannel tp) {
		this.tp = tp;
	}


	public static List<Stagiaire> getStagiaires() {
		return stagiaires;
	}


	public static void setStagiaires(List<Stagiaire> stagiaires) {
		BoutonPannel.stagiaires = stagiaires;
	}


	
	






}
