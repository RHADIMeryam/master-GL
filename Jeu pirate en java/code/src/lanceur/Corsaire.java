
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JPanel;


public class Corsaire extends JPanel {

	private static final long serialVersionUID = 1436178861615738480L;

	private Couleur couleur;
        private int id;
        private boolean ayantPelle;
        private int ayantMosquet=1;
        private int ayantArmure=0;
	private boolean monte;
        private int vie=100;
           private BufferedImage image;




	public Corsaire(Couleur couleur) {
		
		this.couleur = couleur;
		setOpaque(false);
                    try {                
          image = ImageIO.read(new File("corsaire.png"));
                   } catch (IOException ex) {
                         System.out.println("erreur path");
                         }

	}
	
	@Override
	public void paintComponent(Graphics g){
	 super.paintComponent(g);
        g.drawImage(image, 0, 0, this);	
            

	}

	public Couleur getCouleur() {
		return couleur;
	}

	public boolean isMonte() {
		return monte;
	}

	public void setMonte(boolean monte) {
		this.monte = monte;
	}
        
        public void setAyantPelle(boolean in)
        {
            this.ayantPelle=in; 
        
        }
        public boolean getAyantPelle()
        {
            return ayantPelle;
        }
        public void creuser()
        { 
       
        }
        public void tirer()
        {
        
        }

    public int isAyantMosquet() {
        return ayantMosquet;
    }

    public void setAyantMosquet() {
        this.ayantMosquet ++;
    }

   

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getAyantArmure() {
        return ayantArmure;
    }

    public void setAyantArmure(int ayantArmure) {
        this.ayantArmure = ayantArmure;
    }
    
    
}