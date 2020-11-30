package fr.eql.ai108.annuaire.ihm;

import javafx.scene.layout.BorderPane;

public class MainPanel extends BorderPane {
	private LeftPannel lp = new LeftPannel();
	private TablePannel tp = new TablePannel();
	
	public MainPanel() {
		setLeft(lp);
		setRight(tp);
	}
 
	public LeftPannel getLp() {
		return lp;
	}

	public void setLp(LeftPannel lp) {
		this.lp = lp;
	}

	public TablePannel getTp() {
		return tp;
	}

	public void setTp(TablePannel tp) {
		this.tp = tp;
	}
	
	

}
