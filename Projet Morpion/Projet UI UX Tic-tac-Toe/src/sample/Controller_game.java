package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller_game implements Initializable {

	public void getfromApprentiss() {
		// TODO Auto-generated method stub
		
	}
	public void toMain(ActionEvent event) throws IOException {
	       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes_XML/Main.fxml"));
        Parent secondParent = loader.load();
        Scene secondScene= new Scene(secondParent);
       
        Controller_Main sec = loader.<Controller_Main>getController();
        
        sec.getfromGame();
        
        Stage window =  (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        window.setResizable(false);
        window.setScene(secondScene);
        window.show();
    
    }
 @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
		
    }
}
