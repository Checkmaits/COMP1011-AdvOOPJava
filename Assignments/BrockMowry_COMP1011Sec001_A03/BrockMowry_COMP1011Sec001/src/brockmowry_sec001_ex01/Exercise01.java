package brockmowry_sec001_ex01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Exercise01 extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		var loader = new FXMLLoader(getClass().getResource("exercise01.fxml"));
		var root = (Parent) loader.load();
		stage.setTitle("Exercise 01");
		stage.setResizable(false);
		stage.setScene(new Scene(root));
		stage.show();
	}
	
	public static void main(String[] args) { launch(args); }
	
}