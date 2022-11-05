import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class Registration {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
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
	public Registration() {
		initialize();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 20, 60));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblCreationDunNouveau = new JLabel("Creation d'un nouveau joueur");
		lblCreationDunNouveau.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 22));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(86, Short.MAX_VALUE)
					.addComponent(lblCreationDunNouveau, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
					.addGap(82))
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
		
		
		
		JLabel label = new JLabel("Nom d'utilisateur :");
		label.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 15));
		label.setBounds(40, 76, 139, 21);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Mot de passe :");
		label_1.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 15));
		label_1.setBounds(40, 116, 124, 21);
		panel_1.add(label_1);
		
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
				Login log = new Login();
				frame.dispose();
			}
		});
		btnRevenir.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 18));
		btnRevenir.setBackground(new Color(220, 20, 60));
		btnRevenir.setBounds(40, 238, 171, 31);
		panel_1.add(btnRevenir);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordField.getText().equals(passwordField_1.getText())) {
					File file=new File("authentification.txt");
					if(!file.exists()){
						try{
							file.createNewFile();
						}catch (IOException ex){
							ex.printStackTrace();
						}
					}
					try(PrintWriter print =new PrintWriter(new FileOutputStream(file,true))) 
					{
						print.println(textField.getText()+"-"+passwordField.getText());
					}catch (IOException exp)
					{
						exp.printStackTrace();
					}
					Acceuil acc=new Acceuil(textField.getText(),passwordField.getText() );
					frame.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Retaper votre mot de passe");
					textField.setText("");
					passwordField.setText("");
					passwordField_1.setText("");

				}
			}
		});
		btnValider.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 18));
		btnValider.setBackground(new Color(220, 20, 60));
		btnValider.setBounds(274, 238, 156, 31);
		panel_1.add(btnValider);
		
		JLabel lblRetapezLeMot = new JLabel("Retapez le mot de passe :");
		lblRetapezLeMot.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 15));
		lblRetapezLeMot.setBounds(39, 159, 192, 21);
		panel_1.add(lblRetapezLeMot);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBackground(new Color(255, 255, 224));
		passwordField_1.setBounds(274, 158, 156, 25);
		panel_1.add(passwordField_1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 497, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
