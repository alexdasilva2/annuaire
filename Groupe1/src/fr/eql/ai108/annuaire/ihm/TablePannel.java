package fr.eql.ai108.annuaire.ihm;

import fr.eql.ai108.annuaire.model.Stagiaire;
import fr.eql.ai108.annuaire.model.StagiaireDao;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class TablePannel extends AnchorPane {
	private StagiaireDao dao = new StagiaireDao();
	private ObservableList<Stagiaire> observableStagiaires;
	private TableView<Stagiaire> tableView;
	
	public TablePannel() {
		super();
		
	}

	public StagiaireDao getDao() {
		return dao;
	}

	public void setDao(StagiaireDao dao) {
		this.dao = dao;
	}

	public ObservableList<Stagiaire> getObservableStagiaires() {
		return observableStagiaires;
	}

	public void setObservableStagiaires(ObservableList<Stagiaire> observableStagiaires) {
		this.observableStagiaires = observableStagiaires;
	}

	public TableView<Stagiaire> getTableView() {
		return tableView;
	}

	public void setTableView(TableView<Stagiaire> tableView) {
		this.tableView = tableView;
	}
	
	

}
