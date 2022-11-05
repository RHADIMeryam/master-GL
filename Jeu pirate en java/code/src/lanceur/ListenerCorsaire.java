import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ListenerCorsaire implements MouseListener {
	
	private Plateau plateau;
	private Corsaire corsaire;
	
	public ListenerCorsaire(Corsaire corsaire, Plateau plateau){
		this.plateau=plateau;
		this.corsaire=corsaire;
	}

	public void mouseClicked(MouseEvent arg0) {
		
	}

	public void mouseEntered(MouseEvent arg0) {
	
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent arg0) {
		plateau.afficherPossibilites(corsaire);
	}

	public void mouseReleased(MouseEvent arg0) {
		
	}

}