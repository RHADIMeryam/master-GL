package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller_Main implements Initializable {
	Stage primaryStage ; 
	@FXML private javafx.scene.control.Button close;

	
	  public void Show_AI(ActionEvent event) throws IOException {
	       
		  FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes_XML/Apprentissage.fxml"));
	        Parent secondParent = loader.load();
	        Scene config_scene= new Scene(secondParent);
	       
	        Controller_Apprentiss sec = loader.<Controller_Apprentiss>getController();
	        
	        sec.toApprentiss();
	        
	        Stage window =  (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
	        window.setResizable(false);
	        window.setScene(config_scene);
	        window.show();

	    }
	  public void show_Config(ActionEvent event) throws IOException {
	       
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes_XML/Config.fxml"));
	        Parent secondParent = loader.load();
	        Scene config_scene= new Scene(secondParent);
	       
	        Controller_config sec = loader.<Controller_config>getController();
	        
	        sec.toConfig();
	        
	        Stage window =  (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
	        window.setResizable(false);
	        window.setScene(config_scene);
	        window.show();

	    }
	  public void show_model(ActionEvent event) throws IOException {
	       
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes_XML/model.fxml"));
	        Parent secondParent = loader.load();
	        Scene secondScene= new Scene(secondParent);
	       
	        Controller_model sec = loader.<Controller_model>getController();
	        
	        sec.toModel();
	        
	        Stage window =  (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
	        window.setResizable(false);
	        window.setScene(secondScene);
	        window.show();
	       
	    }
	  public void show_PvP(ActionEvent event) throws IOException {
	       
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes_XML/gameH.fxml"));
	        Parent secondParent = loader.load();
	        Scene secondScene= new Scene(secondParent);
	       
	        Controller_gameH sec = loader.<Controller_gameH>getController();
	        
	        sec.toPVP();
	        
	        Stage window =  (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
	        window.setResizable(false);
	        window.setScene(secondScene);
	        window.show();

	    }
	  public void exit(ActionEvent event) throws IOException {
		  Stage stage = (Stage) close.getScene().getWindow();
		    // do what you have to do
		    stage.close();
	        

	    }

	    @Override
	    public void initialize(URL url, ResourceBundle resourceBundle) {
	        
			
	    }
		public void getfromConfig() {
			// TODO Auto-generated method stub
			
		}
		public void getfromModel() {
			// TODO Auto-generated method stub
			
		}
		public void getfromGameH() {
			// TODO Auto-generated method stub
			
		}
		public void getfromGame() {
			// TODO Auto-generated method stub
			
		}
		
	
	
	

}
