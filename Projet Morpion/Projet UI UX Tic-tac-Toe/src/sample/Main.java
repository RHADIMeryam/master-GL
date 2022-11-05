package sample;
import sample.Controller_Main;	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
	        
	        Parent root =FXMLLoader.load(getClass().getResource("../Scenes_XML/Main.fxml")); 
			primaryStage.setTitle("Tic-Tac-Toe");
			primaryStage.setScene(new Scene(root, 533, 601));
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
