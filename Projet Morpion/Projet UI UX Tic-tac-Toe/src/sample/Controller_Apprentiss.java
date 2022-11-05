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

public class Controller_Apprentiss implements Initializable  {

	
	
	public void toAivsH(ActionEvent event) throws IOException {
	       
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes_XML/gameB.fxml"));
        Parent secondParent = loader.load();
        Scene secondScene= new Scene(secondParent);
       
        Controller_game sec = loader.<Controller_game>getController();
        
        sec.getfromApprentiss();
        
        Stage window =  (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        window.setResizable(false);
        window.setScene(secondScene);
        window.show();
    
    }
 @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
		
    }
public void toApprentiss() {
	// TODO Auto-generated method stub
	
}
}
