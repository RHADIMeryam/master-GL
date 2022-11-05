package sample;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.util.Scanner; // Imp

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller_config implements Initializable  {
	
	@FXML private TextArea f1,f2,f3,d1,d2,d3;
	public void toConfig() {
		// TODO Auto-generated method stub
		
	}
	public void WriteintoConfigText() throws URISyntaxException {
		
		
		 URL res1 = getClass().getClassLoader().getResource("fileR/config.txt");
		 File myObj1 = Paths.get(res1.toURI()).toFile();
		String source = "F:"+f1.getText()+":"+f2.getText()+":"+f3.getText()+"\n"+"F:"+d1.getText()+":"+d2.getText()+":"+d3.getText() ; 
		FileWriter f2;

		try {
		    f2 = new FileWriter(myObj1,false);
		    f2.write(source);
		    /*for (int i=0; i<source.length();i++)
		    {
		        if(source.charAt(i)=='\n')
		            f2.append(System.getProperty("line.separator"));
		        f2.append(source.charAt(i));
		    }*/
		    f2.close();
		} catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		}           
		
	}
	  public void toMain(ActionEvent event) throws IOException, URISyntaxException {
	       
		  
		  WriteintoConfigText() ;
		  
		  
		  
		  
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes_XML/Main.fxml"));
	        Parent secondParent = loader.load();
	        Scene secondScene= new Scene(secondParent);
	       
	        Controller_Main sec = loader.<Controller_Main>getController();
	        
	        sec.getfromConfig();
	        
	        Stage window =  (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
	        window.setResizable(false);
	        window.setScene(secondScene);
	        window.show();
	    
	    }
	  
	 @Override
	    public void initialize(URL url, ResourceBundle resourceBundle) {
	        String facile,difficile;
	        
		     
		 try {
			 URL res = getClass().getClassLoader().getResource("fileR/config.txt");
			 File myObj = Paths.get(res.toURI()).toFile();
		     
		      Scanner myReader = new Scanner(myObj);
		      String data = myReader.nextLine();
		      facile = data ;
		      data = myReader.nextLine();
		      difficile = data ;
		      String[] pairf = facile.split(":");
		      String[] paird = difficile.split(":");
		      
		     
		    f1.setText(pairf[1]);
		    f2.setText(pairf[2]);
		    f3.setText(pairf[3]);
		    d1.setText(paird[1]);
		    d2.setText(paird[2]);
		    d3.setText(paird[3]);
		   
		    
		      
		      
		      
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    } catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		
}
