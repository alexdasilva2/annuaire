package fr.eql.ai108.annuaire.ihm;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

import javafx.scene.layout.VBox;

public class FormPannel extends VBox {
	private Label lbl = new Label();

	public FormPannel() {
		super();
	}

	public Label getLbl() {
		return lbl;
	}


	public void setLbl(Label lbl) {
		this.lbl = lbl;
	}



}
