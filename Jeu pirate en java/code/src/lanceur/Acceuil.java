import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Acceuil {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil window = new Acceuil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 * @param string 
	 * @param string 
	 */
	public Acceuil(String chaine, String mp) {
		initialize(chaine,mp);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String chaine, String mp) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 494, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblPageDacceuil = new JLabel("Page d'acceuil");
		lblPageDacceuil.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 22));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(162, Short.MAX_VALUE)
					.addComponent(lblPageDacceuil, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(148))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(lblPageDacceuil)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JButton btnCommencerUneNouvelle = new JButton("Commencer une nouvelle partie");
		btnCommencerUneNouvelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChoixDifNom c = new ChoixDifNom(chaine,mp);
				frame.dispose();
			}
		});
		btnCommencerUneNouvelle.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 18));
		btnCommencerUneNouvelle.setBackground(new Color(135, 206, 250));
		btnCommencerUneNouvelle.setBounds(72, 46, 335, 31);
		panel_1.add(btnCommencerUneNouvelle);
		
		JButton btnChargerUnePartie = new JButton("Charger une partie sauvegardée");
		btnChargerUnePartie.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 18));
		btnChargerUnePartie.setBackground(new Color(135, 206, 250));
		btnChargerUnePartie.setBounds(72, 115, 335, 31);
		panel_1.add(btnChargerUnePartie);
		
		JButton btnEditerMonProfil = new JButton("Editer mon profile");
		btnEditerMonProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifProfil modif=new ModifProfil(chaine, mp);
				frame.dispose();
			}
		});
		btnEditerMonProfil.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 18));
		btnEditerMonProfil.setBackground(new Color(135, 206, 250));
		btnEditerMonProfil.setBounds(72, 180, 335, 31);
		panel_1.add(btnEditerMonProfil);
		
		JButton btnVoirStatistique = new JButton("Voir les statistiques");
		btnVoirStatistique.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 18));
		btnVoirStatistique.setBackground(new Color(135, 206, 250));
		btnVoirStatistique.setBounds(72, 254, 335, 31);
		panel_1.add(btnVoirStatistique);
		
		JButton btnQuitter = new JButton("Quitter ");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuitter.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 18));
		btnQuitter.setBackground(new Color(135, 206, 250));
		btnQuitter.setBounds(72, 321, 335, 31);
		panel_1.add(btnQuitter);
		
		JLabel lblNomDutilisateur = new JLabel(chaine);
		lblNomDutilisateur.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 15));
		lblNomDutilisateur.setBounds(12, 427, 180, 21);
		panel_1.add(lblNomDutilisateur);
	}
}
