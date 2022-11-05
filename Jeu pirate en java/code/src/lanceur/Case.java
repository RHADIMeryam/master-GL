import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.JPanel;


public class Case extends JPanel {
	
	private static final long serialVersionUID = -1839026893240660968L;
	private boolean pelle;
	private Couleur couleur;
	private boolean selectionnee;
        private boolean trisor;
        private boolean mousquet;
        private boolean armure;
        private BufferedImage image;
	public Case(Couleur couleur){
		setLayout(new GridLayout(1,0));
		this.couleur=couleur;
                        try {                
          image = ImageIO.read(new File("gazon.png"));
                   } catch (IOException ex) {
                         System.out.println("erreur path");
                         }
		initCouleur();
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public boolean isSelectionnee() {
		return selectionnee;
	}

	public void setSelectionnee(boolean selectionnee) {
		this.selectionnee = selectionnee;
		if(selectionnee){
			setBackground(Color.BLUE);
			setForeground(Color.LIGHT_GRAY);
		}
		else {
			initCouleur();
		}
	}
	
	private void initCouleur(){
		switch(couleur){
		case VERT :
			setBackground(Color.GREEN);
			setForeground(new Color(10, 10, 10));
			
			break;
		case NOIR :
			setBackground(Color.GRAY);
			setForeground(new Color(20, 20, 20));
			break;
		}
	}
	
	@Override
	public void paintComponent(Graphics g){
		 super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
                /*Paint paint;
		Graphics2D g2d;
		if (g instanceof Graphics2D) {
			g2d = (Graphics2D) g;
		}
		else {
			System.out.println("Error");
			return;
		}
		paint = new GradientPaint(0,0, getBackground(), getWidth(), getHeight(), getForeground());
		g2d.setPaint(paint);
		g.fillRect(0, 0, getWidth(), getHeight());
                */
                
	}

    public boolean isPelle() {
        return pelle;
    }

    public void setPelle(boolean pelle) {
        this.pelle = pelle;
    }

    public boolean isTrisor() {
        return trisor;
    }

    public void setTrisor(boolean trisor) {
        this.trisor = trisor;
    }

    public boolean isMousquet() {
        return mousquet;
    }

    public void setMousquet(boolean mousquet) {
        this.mousquet = mousquet;
    }

    public boolean isArmure() {
        return armure;
    }

    public void setArmure(boolean armure) {
        this.armure = armure;
    }
    
    
        
}