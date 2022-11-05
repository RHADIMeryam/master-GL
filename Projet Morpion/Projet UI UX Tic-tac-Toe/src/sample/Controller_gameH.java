package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller_gameH implements Initializable{
	@FXML private javafx.scene.control.Button bt,rejou;
	@FXML private javafx.scene.control.Button bt1;
	@FXML private javafx.scene.control.Button bt2;
	@FXML private javafx.scene.control.Button bt3;
	@FXML private javafx.scene.control.Button bt4;
	@FXML private javafx.scene.control.Button bt5;
	@FXML private javafx.scene.control.Button bt6;
	@FXML private javafx.scene.control.Button bt7;
	@FXML private javafx.scene.control.Button bt8;
	@FXML private Pane panet1,panet2,panet3,panet4,panet5,panet6,panet7,panet8;
	@FXML private Label Xwin,Owin,ega1,ega2 , fin;
	private boolean tour = false ;
	@FXML private Pane x1,x2,x3,x4,x5,o1,o2,o3,o4,o5;
	String winner  = "none";
	int Xwins = 1 , Owins = 1 ;
	
	public void toPVP() {
		// TODO Auto-generated method stub
		
	}
	 public void toMain(ActionEvent event) throws IOException {
	       
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes_XML/Main.fxml"));
	        Parent secondParent = loader.load();
	        Scene secondScene= new Scene(secondParent);
	       
	        Controller_Main sec = loader.<Controller_Main>getController();
	        
	        sec.getfromGameH();
	        
	        Stage window =  (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
	        window.setResizable(false);
	        window.setScene(secondScene);
	        window.show();
	    
	    }
	 public void Played() {
		
		
		 if ( this.tour == false ) {
			 this.bt.setId("btn1X");
			 this.tour = true ; 
		 
		 } else {
			 this.bt.setId("btn1O");
			 this.tour = false ; }
		 Condition_win();
		 fin_game();
		 
		}
	 public void Played1() {
		 
		 if ( this.tour == false ) {
			 this.bt1.setId("btn2X");
			 this.tour = true ; 
		 
		 } else {
			 this.bt1.setId("btn2O");
			 this.tour = false ; }
		 Condition_win();
		 fin_game();
			
		}
	 public void Played2() {
		 
		 if ( this.tour == false ) {
			 this.bt2.setId("btn3X");
			 this.tour = true ; 
		 
		 } else {
			 this.bt2.setId("btn3O");
			 this.tour = false ; }
		 Condition_win();
		 fin_game();
		}
	 public void Played3() {
		
		 if ( this.tour == false ) {
			 this.bt3.setId("btn4X");
			 this.tour = true ; 
		 
		 } else {
			 this.bt3.setId("btn4O");
			 this.tour = false ; }
		 Condition_win();
		 fin_game();
		}
	 public void Played4() {
		
		 if ( this.tour == false ) {
			 this.bt4.setId("btn5X");
			 this.tour = true ; 
		 
		 } else {
			 this.bt4.setId("btn5O");
			 this.tour = false ; }
		 Condition_win();
		 fin_game();
			
		}
	 public void Played5() {
		
		 if ( this.tour == false ) {
			 this.bt5.setId("btn6X");
			 this.tour = true ; 
		 
		 } else {
			 this.bt5.setId("btn6O");
			 this.tour = false ; }
		 Condition_win();
		 fin_game();
			
		}
	 public void Played6() {
		
		 if ( this.tour == false ) {
			 this.bt6.setId("btn7X");
			 this.tour = true ; 
		 
		 } else {
			 this.bt6.setId("btn7O");
			 this.tour = false ; }
		 Condition_win();
		 fin_game();
			
		}
	 public void Played7() {
		 
		 if ( this.tour == false ) {
			 this.bt7.setId("btn8X");
			 this.tour = true ; 
		 
		 } else {
			 this.bt7.setId("btn8O");
			 this.tour = false ; }
		 Condition_win();
		 fin_game();
			
		}
	 public void Played8() {
		
		 if ( this.tour == false ) {
			 this.bt8.setId("btn9X");	
			 this.tour = true ; 
		 
		 } else {
			 this.bt8.setId("btn9O");	
			 this.tour = false ; }
		 Condition_win();
		 fin_game();
		}
	 
	 public void Condition_win() {
		
		 if (( bt.getId().equals("btn1X") && bt1.getId().equals("btn2X") && bt2.getId().equals("btn3X")) ) { this.winner = "red" ; this.panet4.setVisible(true); }
		 if (( bt.getId().equals("btn1X") && bt3.getId().equals("btn4X") && bt6.getId().equals("btn7X")) ) { this.winner = "red" ; this.panet1.setVisible(true); }
		 if (( bt.getId().equals("btn1X") && bt4.getId().equals("btn5X") && bt8.getId().equals("btn9X"))  ) { this.winner = "red" ; this.panet8.setVisible(true); }
		 if (( bt1.getId().equals("btn2X") && bt4.getId().equals("btn5X") && bt7.getId().equals("btn8X"))) { this.winner = "red" ; this.panet2.setVisible(true); }
		 if (( bt2.getId().equals("btn3X") && bt5.getId().equals("btn6X") && bt8.getId().equals("btn9X"))  ) { this.winner = "red" ; this.panet3.setVisible(true); }
		 if (( bt3.getId().equals("btn4X") && bt4.getId().equals("btn5X") && bt5.getId().equals("btn6X")) ) { this.winner = "red" ; this.panet5.setVisible(true); }
		 if (( bt6.getId().equals("btn7X") && bt7.getId().equals("btn8X") && bt8.getId().equals("btn9X"))) { this.winner = "red" ; this.panet6.setVisible(true); }
		 if (( bt2.getId().equals("btn3X") && bt4.getId().equals("btn5X") && bt6.getId().equals("btn7X")) ) { this.winner = "red" ; this.panet7.setVisible(true); }
		 
		 
	    
	   if (( bt.getId().equals("btn1O") && bt1.getId().equals("btn2O") && bt2.getId().equals("btn3O")) ){this.winner = "blue" ; this.panet4.setVisible(true); }
	   if ( ( bt.getId().equals("btn1O") && bt3.getId().equals("btn4O") && bt6.getId().equals("btn7O"))) {this.winner = "blue" ;this.panet1.setVisible(true);}
	   if ( ( bt.getId().equals("btn1O") && bt4.getId().equals("btn5O") && bt8.getId().equals("btn9O"))) {this.winner = "blue" ;this.panet8.setVisible(true);}
	   if ( ( bt1.getId().equals("btn2O") && bt4.getId().equals("btn5O") && bt7.getId().equals("btn8O")) ){this.winner = "blue" ;this.panet2.setVisible(true);}
	   if (( bt2.getId().equals("btn3O") && bt5.getId().equals("btn6O") && bt8.getId().equals("btn9O")) ){this.winner = "blue" ;this.panet3.setVisible(true);}
	   if ( ( bt3.getId().equals("btn4O") && bt4.getId().equals("btn5O") && bt5.getId().equals("btn6O")) ){this.winner = "blue" ;this.panet5.setVisible(true);}
	   if ( ( bt6.getId().equals("btn7O") && bt7.getId().equals("btn8O") && bt8.getId().equals("btn9O")) ){this.winner = "blue" ;this.panet6.setVisible(true);}
	   if ( ( bt2.getId().equals("btn3O") && bt4.getId().equals("btn5O") && bt6.getId().equals("btn7O"))){this.winner = "blue" ;this.panet7.setVisible(true); }
	    								 
	    }
	 public void fin_game() {
if ( !bt.getId().equals("btn1") && !bt1.getId().equals("btn2") && !bt2.getId().equals("btn3") && !bt3.getId().equals("btn4")&& !bt4.getId().equals("btn5") && !bt5.getId().equals("btn6") && !bt6.getId().equals("btn7")&& !bt7.getId().equals("btn8") && !bt8.getId().equals("btn9") && this.winner.equals("none") ) {
	//egalité
	this.ega1.setVisible(true);
	this.ega2.setVisible(true);
	 this.rejou.setVisible(true);
	 diable_btns();
	
}else if (this.winner.equals("red")) {
	
	//red X win
	this.Xwin.setVisible(true);
	 
	 diable_btns();
	 score(this.winner);
	 if (this.Xwins > 5 || this.Owins > 5  ) { this.fin.setVisible(true);} else {this.rejou.setVisible(true);}
	 
	
}else if ( this.winner.equals("blue")) {
	//blue win 
	this.Owin.setVisible(true);
	 diable_btns();
	 score(this.winner);
	 if (this.Xwins > 5 || this.Owins > 5  ) { this.fin.setVisible(true);} else {this.rejou.setVisible(true);}
	 
	 
}
		 
	 }
	 public void initial_game() {
		
		 this.winner  = "none";
		 this.bt.setId("btn1");
		 this.bt1.setId("btn2");
		 this.bt2.setId("btn3");
		 this.bt3.setId("btn4");
		 this.bt4.setId("btn5");
		 this.bt5.setId("btn6");
		 this.bt6.setId("btn7");
		 this.bt8.setId("btn9");
		 this.bt7.setId("btn8");
		 this.Owin.setVisible(false);
		 this.Xwin.setVisible(false);
		 this.ega1.setVisible(false);
		 this.ega2.setVisible(false);
		 this.panet1.setVisible(false); 
		 this.panet2.setVisible(false); 
		 this.panet3.setVisible(false); 
		 this.panet4.setVisible(false); 
		 this.panet5.setVisible(false); 
		 this.panet6.setVisible(false); 
		 this.panet7.setVisible(false); 
		 this.panet8.setVisible(false); 
		 this.rejou.setVisible(false);
		 enable_btns();
		
	 }
	 public void diable_btns() {
		 this.bt.setDisable(true);
		 this.bt1.setDisable(true);
		 this.bt2.setDisable(true);
		 this.bt3.setDisable(true);
		 this.bt4.setDisable(true);
		 this.bt5.setDisable(true);
		 this.bt6.setDisable(true);
		 this.bt7.setDisable(true);
		 this.bt8.setDisable(true);
		 
			
	    }
	 public void enable_btns() {
		 this.bt.setDisable(false);
		 this.bt1.setDisable(false);
		 this.bt2.setDisable(false);
		 this.bt3.setDisable(false);
		 this.bt4.setDisable(false);
		 this.bt5.setDisable(false);
		 this.bt6.setDisable(false);
		 this.bt7.setDisable(false);
		 this.bt8.setDisable(false);
		 
			
	    }
	 public void score(String winner) {
		 
	        if ( winner.equals("red")) { 
	        	
	        	switch (this.Xwins) {
	        	  case 1:
	        	    this.x1.setVisible(true);
	        	    break;
	        	  case 2:
	        		  this.x2.setVisible(true);
	        	    break;
	        	  case 3:
	        		  this.x3.setVisible(true);
	        	    break;
	        	  case 4:
	        		  this.x4.setVisible(true);
	        	    break;
	        	  case 5:
	        		  this.x5.setVisible(true);
	        	    break;
	        	
	        	}
	        	this.Xwins ++ ; 
	        }
	        if ( winner.equals("blue")) {
	        	
	        	switch (this.Owins) {
	        	  case 1:
	        	    this.o1.setVisible(true);
	        	    break;
	        	  case 2:
	        		  this.o2.setVisible(true);
	        	    break;
	        	  case 3:
	        		  this.o3.setVisible(true);
	        	    break;
	        	  case 4:
	        		  this.o4.setVisible(true);
	        	    break;
	        	  case 5:
	        		  this.o5.setVisible(true);
	        	    break;
	        	
	        	}
	        	this.Owins ++ ; 
	        }
			
	    }
	 @Override
	 
	    public void initialize(URL url, ResourceBundle resourceBundle) {
	        
			
	    }
	 
	 
	 
	 
	 
}
