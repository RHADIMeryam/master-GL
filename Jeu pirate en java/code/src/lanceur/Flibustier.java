
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author strangerdz
 */
public class Flibustier extends Pirate {
    private BufferedImage image;
    public Flibustier(Couleur couleur) {
        super(couleur);
        setOpaque(false);
                       try {                
          image = ImageIO.read(new File("flibustier.png"));
                   } catch (IOException ex) {
                         System.out.println("erreur path");
                         }
    }
    public void paintComponent(Graphics g){
	 super.paintComponent(g);
        g.drawImage(image, 0, 0, this);	
    }
     public void tirer()
    {
    
    }
       public static int seDeplacer(int i,int j){
            
             int x=i;
             int y=j;
           
        boolean valide=false; 
        while (valide==false)
        {        
           int nb2 = (int) (Math.random() * 2);
          int nb = (int) (Math.random() * 8);
          
               switch(nb2)
               {
                   case 0:
               
	          switch (nb)
	            {
	             case 0:
	                 if(y-1>=0)
	                 {
	                     valide=true;
	                     y--;
                             return x*12+y;
	                 }
	             break;        
	             case 1:
	                 if(y-1>=0 && x-1>=0)
	                 { 
	                     valide=true;
	                     x--;
	                     y--;
                             return x*12+y;
	                 }
	             break; 
	             case 2:
	                 if(x-1>=0)
	                 {
	                     valide=true;
	                     x--;
                             return x*12+y;
	                 }
	             break; 
	             case 3:
	                 if(y+1<=11 && x-1>=0)
                 	 { 
                	     valide=true;
	                     x--;
	                     y++;
                             return x*12+y;
	                 }
	             break;  
	             case 4:
	                 if(y+1<=11)
	                 {
	                     valide=true;
	                     y++;
                             return x*12+y;
         	         }
             	     break; 
	             case 5:
	                 if(y+1<=11 && x+1<=11)
	                 { 
	                     valide=true;
	                     x++;
	                     y++;
                             return x*12+y;
	                 }
	             break;                
	             case 6:
            	         if(x+1<=11)
          	         {
	                     valide=true;
	                     x++;return x*12+y;
                 	 }
	             break;
	             default:
	                 if(y-1>=0 && x+1<=11)
                 	{ 
	                     valide=true;
	                     x++;
	                     y--;
                             return x*12+y;
	                }
                        break;
                    }
                  break;
                   default :
                       switch (nb)
	            {
	             case 0:
	                 if(y-2>=0)
	                 {
	                     valide=true;
	                     y--;
                             y--;
                             return x*12+y;
	                 }
	             break;        
	             case 1:
	                 if(y-2>=0 && x-2>=0)
	                 { 
	                     valide=true;
	                     x--;
	                     y--;
                             x--;
	                     y--;
                             return x*12+y;
	                 }
	             break; 
	             case 2:
	                 if(x-2>=0)
	                 {
	                     valide=true;
	                     x--;
                             x--;
                             return x*12+y;
	                 }
	             break; 
	             case 3:
	                 if(y+2<=11 && x-1>=0)
                 	 { 
                	     valide=true;
	                     x--;
	                     y++;
                             x--;
	                     y++;
                             return x*12+y;
	                 }
	             break;  
	             case 4:
	                 if(y+2<=11)
	                 {
	                     valide=true;
	                     y++;
                             y++;
                             return x*12+y;
         	         }
             	     break; 
	             case 5:
	                 if(y+2<=11 && x+2<=11)
	                 { 
	                     valide=true;
	                     x++;
	                     y++;
                             x++;
	                     y++;
                             return x*12+y;
	                 }
	             break;                
	             case 6:
            	         if(x+2<=11)
          	         {
	                     valide=true;
	                     x++;
                             x++;
                             return x*12+y;
                 	 }
	             break;
	             default:
	                 if(y-2>=0 && x+2<=11)
                 	{ 
	                     valide=true;
	                     x++;
	                     y--;
                             x++;
	                     y--;
                             return x*12+y;
	                }
                        break;
                    }
                  break;
               
               
               }
                  
                 
                  
        }
		
      return 15;       
     }
    
}