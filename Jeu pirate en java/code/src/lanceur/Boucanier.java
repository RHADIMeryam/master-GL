
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Boucanier extends Pirate {
    private BufferedImage image;
    public Boucanier(Couleur couleur) {
        super(couleur);
       setOpaque(false);
                    try {                
          image = ImageIO.read(new File("boucanier.png"));
                   } catch (IOException ex) {
                         System.out.println("erreur path");
                         }
    }
    
    public void trancherTete()
    {
    
    }
    public void paintComponent(Graphics g){
	 super.paintComponent(g);
        g.drawImage(image, 0, 0, this);	
    }
    public static int seDeplacer(int i,int j){
            
             int x=i;
             int y=j;
           
        boolean valide=false; 
        while (valide==false)
        {        
           
          int nb = (int) (Math.random() * 8);
          
              
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
        }
		
      return 15;       
     }

  

}