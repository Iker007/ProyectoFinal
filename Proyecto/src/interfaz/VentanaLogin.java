package interfaz;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import clases.Entrenador;
import database.GestorBD;

public class VentanaLogin extends JFrame implements ActionListener{
	private JPanel pContent;
	private JPanel pTitulo;
	private JPanel pBottom;
	private JPanel pDatos;
	private JPanel pUsername;
	private JPanel pPassword;
	private JTextField username;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField password;
	private JPanel pBotones;
	private JButton signUpButton;
	private JButton signInButton;
	private JButton salir;
	private ImageIcon imageIconTitle;
	private JLabel avatar;
	private JComboBox<String> avatarComboBox;
	private JPanel pComboBox;
	private String[] avatarNames;
	private JLabel background;
	private Image image;
	private JPanel blanco;
	private JPanel blanco1;
	private JMenuBar menuBar;
	private Color southPanel;
	private Dimension tamanyoBotones;
	private GestorBD baseDeDatos = new GestorBD();
	private Entrenador entrenadorActual;
	
	public VentanaLogin() {
		this.setSize(800, 600);
		this.setLayout(new BorderLayout());
		this.setTitle("Pokemon Showdown");
		usernameLabel = new JLabel("Username:");
		username = new JTextField();
		username.setEditable(true);
		username.setPreferredSize(new Dimension(250, 45));
		username.setFont(new Font("Comic Sainz MS", Font.BOLD, 20));
		passwordLabel = new JLabel("Password:");
		password = new JTextField();
		password.setEditable(true);
		password.setPreferredSize(new Dimension(250,45));
		password.setFont(new Font("",Font.BOLD,20));
		pContent = new JPanel(new GridLayout(1,3));
		pDatos = new JPanel(new GridLayout(2,1));
		pUsername = new JPanel(new FlowLayout());
		pUsername.add(usernameLabel);
		pUsername.add(username);
		pPassword = new JPanel(new FlowLayout());
		pPassword.add(passwordLabel);
		pPassword.add(password);
		
		pBotones = new JPanel(new FlowLayout(FlowLayout.CENTER,0,60));
		pDatos.add(pUsername);
		pDatos.add(pPassword);
		tamanyoBotones = new Dimension(100, 50);
		signInButton = new JButton("Sign In");
		signInButton.setPreferredSize(tamanyoBotones);
		signUpButton = new JButton("Register");
		signUpButton.setPreferredSize(tamanyoBotones);
		pBotones.add(signInButton);
		pBotones.add(signUpButton);
		
		blanco = new JPanel(new FlowLayout());
		blanco.setBackground(Color.black);
		blanco1 = new JPanel(new FlowLayout());
		pContent.add(pDatos,BorderLayout.SOUTH);
		blanco.setPreferredSize(new Dimension(300, 300));
		background = new JLabel(new ImageIcon("C:\\ProyectoProgIII\\PokemonShowdownTitle.jpg"));
		//background = new JLabel(new ImageIcon("C:\\\\Users\\\\oscar\\\\Downloads\\\\A.gif"));
		this.add(background,BorderLayout.CENTER);
		background.setLayout(new FlowLayout());
		pContent.add(pBotones);
		salir = new JButton("Salir del juego");
		avatarNames = new String[]{"Chico","Chica","Otros"};
		avatar = new JLabel("Avatar:");
		avatar.setForeground(Color.WHITE);
		avatarComboBox = new JComboBox<>(avatarNames);
		avatarComboBox.setPreferredSize(new Dimension(100, 50));
		//.addItem(avatarNames[0]);
		//avatarComboBox.addItem(avatarNames[1]);
		//avatarComboBox.addItem(avatarNames[2]);
		pComboBox = new JPanel(new FlowLayout(FlowLayout.CENTER,30,40));
		pComboBox.add(avatar);
		pComboBox.add(avatarComboBox);
		pComboBox.add(salir);
		//pComboBox.setAlignmentX(CENTER_ALIGNMENT);
		//pComboBox.setAlignmentY(CENTER_ALIGNMENT);
		
		pContent.add(pComboBox);
		//this.setContentPane(new JLabel(new ImageIcon("C:\\ProyectoProgIII\\PokemonShowdownTitle.jpg") ));
		//this.setLayout(new FlowLayout());
		//background.add(blanco,BorderLayout.WEST);
		//background.add(pContent,FlowLayout.CENTER);
		//background.add(pBotones,FlowLayout.TRAILING);
		//this.add(pContent, BorderLayout.CENTER);
		//imageIconTitle = new ImageIcon("C:\\\\Users\\\\oscar\\\\Downloads\\\\Imagenes\\\\X.png");
		//image = imageIconTitle.getImage(); 
		//imagenTitulo = new ImageIcon(image);
		//pContent.add(imagenTitulo);
		//this.add(pContent,BorderLayout.CENTER);
		//this.add(imagenTitulo);
		
		pBotones.setBackground(Color.DARK_GRAY);
		pComboBox.setBackground(Color.DARK_GRAY);
		pContent.setBackground(Color.DARK_GRAY);
		background.setMinimumSize(new Dimension(200, 200));
		this.add(pContent,BorderLayout.SOUTH);
		pBotones.setBounds(100, 100, 1000, 100);
		////this.add(pBotones,BorderLayout.SOUTH);
		this.setMinimumSize(new Dimension(825, 670));
		signInButton.addActionListener(this);
		salir.addActionListener(this);
	}
	
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			String s = username.getText();
			String p = password.getText();
			try {
			if(event.getSource() == signInButton) {
				
				if(!s.isEmpty() && !p.isEmpty()) {
					for(Entrenador entrenador : baseDeDatos.usuarios) {
					if(entrenador.getUsuario().equals(s) && entrenador.getContraseña().equals(p)) {
						JOptionPane.showMessageDialog(this, "Se ha realizado con exito");
						VentanaInicio v = new VentanaInicio();
						System.exit(0);
					}
					}
					
					}
				else {
					JOptionPane.showMessageDialog(this, "Error rellene todos los campos para proceder", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			}catch(NumberFormatException E) {
				JOptionPane.showMessageDialog(this, "Error rellene todos los campos para proceder", "Error", JOptionPane.ERROR_MESSAGE);
				
			}
			if(event.getSource() == signUpButton) {
				
				if(!s.isEmpty() && !p.isEmpty()) {
					for(Entrenador entrenador : baseDeDatos.usuarios) {
					if(entrenador.getUsuario().equals(s)) {
						JOptionPane.showMessageDialog(this, "El usuario ya existe");
						
					}
					else {
						Entrenador e = new Entrenador();
						e.setName(s);
						e.setContraseña(p);
						System.out.println(e.getName());
						entrenadorActual = e;
						VentanaInicio v = new VentanaInicio();
						baseDeDatos.usuarios.add(e);
						
						JOptionPane.showMessageDialog(this, "El usuario ya existe");
					}
					}
					
					}
				else {
					JOptionPane.showMessageDialog(this, "Error rellene todos los campos para proceder", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			
			if(event.getSource() == salir) {
				System.exit(0);
			}
		
			

	}
	public boolean compararUsuario() {
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VentanaLogin v = new VentanaLogin();
		v.setVisible(true);

	}
}
