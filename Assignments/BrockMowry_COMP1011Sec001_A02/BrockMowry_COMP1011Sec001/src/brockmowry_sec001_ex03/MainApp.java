package brockmowry_sec001_ex03;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		var loader = new FXMLLoader(getClass().getResource("exercise3.fxml"));
		var root = (Parent) loader.load();
		var scene = new Scene(root, 590, 200);
		primaryStage.setTitle("Exercise 3 App");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) { launch(args); }
	
}