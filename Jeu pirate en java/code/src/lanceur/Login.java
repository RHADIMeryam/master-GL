import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	private static boolean isBlank(String s) {
	     return s == null || s.isEmpty();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 598, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 20, 60));
		panel.setBounds(0, 0, 598, 71);
		frame.getContentPane().add(panel);
		
		JLabel titleFrame = new JLabel("Authentification");
		titleFrame.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 22));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(208)
					.addComponent(titleFrame)
					.addContainerGap(236, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addComponent(titleFrame)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Table.background"));
		panel_1.setBounds(0, 66, 598, 314);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnSeConnecter = new JButton("Se connecter");
		btnSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File file=new File("authentification.txt");
				String line;
				boolean trouv=false;
				if(!file.exists()){
					try{
						file.createNewFile();
					}catch (IOException e){
						e.printStackTrace();
					}
				}
				try(FileInputStream fis=new FileInputStream(file)){
						Scanner a=new Scanner(fis);
						a.useDelimiter("-");
						while(a.hasNextLine() && !isBlank(line = a.nextLine())){
							 String[] accountData = line.split("-");
						     String user = accountData[0];
						     String password = accountData[1];
							if (textField.getText().equals(user) && passwordField.getText().equals(password)){
								trouv=true;
								Acceuil acc=new Acceuil(textField.getText(),passwordField.getText());
								frame.dispose();
							}
						}
						if(trouv==false) {
							JOptionPane.showMessageDialog(null, "Le nom et le mot de passe entrés ne correspond à aucun compte");
						}
						
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		});
		btnSeConnecter.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 18));
		btnSeConnecter.setBackground(new Color(220, 20, 60));
		btnSeConnecter.setBounds(323, 173, 156, 31);
		panel_1.add(btnSeConnecter);
		
		JLabel username = new JLabel("Nom d'utilisateur :");
		username.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 18));
		username.setBounds(81, 76, 171, 28);
		panel_1.add(username);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 18));
		lblMotDePasse.setBounds(81, 116, 171, 21);
		panel_1.add(lblMotDePasse);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 224));
		textField.setBounds(323, 80, 156, 25);
		panel_1.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 255, 224));
		passwordField.setBounds(323, 116, 156, 25);
		panel_1.add(passwordField);
		
		JButton btnSinscrire = new JButton("S'inscrire");
		btnSinscrire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 Registration reg = new Registration();
			 frame.dispose();
			}
		});
		btnSinscrire.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 18));
		btnSinscrire.setBackground(new Color(220, 20, 60));
		btnSinscrire.setBounds(81, 173, 171, 31);
		panel_1.add(btnSinscrire);
	}
}
