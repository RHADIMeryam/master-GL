import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class ModifProfil {

	protected static final Path FILE_PATH = null;
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifProfil window = new ModifProfil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	private static boolean isBlank(String s) {
	     return s == null || s.isEmpty();
	}

	/**
	 * Create the application.
	 */
	public ModifProfil(String chaine,String mp) {
		initialize();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(199, 21, 133));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblCreationDunNouveau = new JLabel("Modification de Profile");
		lblCreationDunNouveau.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 22));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(99)
					.addComponent(lblCreationDunNouveau, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(117, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(lblCreationDunNouveau)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		
		
		JLabel lblNouveauNomDutilisateur = new JLabel("Nouveau nom d'utilisateur :");
		lblNouveauNomDutilisateur.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 15));
		lblNouveauNomDutilisateur.setBounds(40, 76, 201, 21);
		panel_1.add(lblNouveauNomDutilisateur);
		
		JLabel lblNouveauMotDe = new JLabel("Nouveau mot de passe :");
		lblNouveauMotDe.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 15));
		lblNouveauMotDe.setBounds(40, 116, 180, 21);
		panel_1.add(lblNouveauMotDe);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(new Color(255, 255, 224));
		textField.setBounds(274, 75, 156, 25);
		panel_1.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 255, 224));
		passwordField.setBounds(274, 115, 156, 25);
		panel_1.add(passwordField);
		
		JButton btnRevenir = new JButton("Retour ");
		btnRevenir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acceuil acc=new Acceuil(chaine,mp);
				frame.dispose();
			}
		});
		btnRevenir.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 18));
		btnRevenir.setBackground(new Color(199, 21, 133));
		btnRevenir.setBounds(40, 200, 171, 31);
		panel_1.add(btnRevenir);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// mettre a jour les fichiers
				Path p1 = Paths.get("authentification.txt");
				ArrayList<String> fileContent = null;
				try {
					fileContent = new ArrayList<>(Files.readAllLines(p1, StandardCharsets.UTF_8));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				for (int i = 0; i < fileContent.size(); i++) {
				    if (fileContent.get(i).equals(chaine+"-"+mp)) {
				        fileContent.set(i, textField.getText()+"-"+passwordField.getText());
				        break;
				    }
				}

				try {
					Files.write(p1, fileContent, StandardCharsets.UTF_8);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Acceuil acc=new Acceuil(textField.getText(),passwordField.getText());
				frame.dispose();
			}
		});
		btnValider.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 18));
		btnValider.setBackground(new Color(199, 21, 133));
		btnValider.setBounds(274, 200, 156, 31);
		panel_1.add(btnValider);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 486, 395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
