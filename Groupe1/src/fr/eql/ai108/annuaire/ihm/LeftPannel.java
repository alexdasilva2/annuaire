package fr.eql.ai108.annuaire.ihm;

import javafx.scene.layout.BorderPane;


public class LeftPannel extends BorderPane {
	private BoutonPannel bp = new BoutonPannel();
	private FormPannel fp = new FormPannel();
	
	public LeftPannel() {
		setTop(bp);
		setBottom(fp);
	}

	public BoutonPannel getBp() {
		return bp;
	}

	public void setBp(BoutonPannel bp) {
		this.bp = bp;
	}

	public FormPannel getFp() {
		return fp;
	}

	public void setFp(FormPannel fp) {
		this.fp = fp;
	}
	
	

}
