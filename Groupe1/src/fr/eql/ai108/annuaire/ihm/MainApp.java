package fr.eql.ai108.annuaire.ihm;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	
	public static void main(String[] args) {
		launch(args);
	}

	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		MainPanel root = new MainPanel();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setTitle("Programme annuaire");
		primaryStage.show();
		
		
	}
}
