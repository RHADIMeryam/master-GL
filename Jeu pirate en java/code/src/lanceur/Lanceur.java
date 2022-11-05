

import javax.swing.JFrame;
import javax.swing.UIManager;


public class Lanceur {
        public boolean a = true;
	
	public Lanceur() {
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch(Exception e){}
		JFrame f = new JFrame();
		f.setSize(600, 600);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Plateau p =new Plateau(9);
                f.add(p);
                f.setVisible(true);
               

	}

}