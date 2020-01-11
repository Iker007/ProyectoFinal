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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Entrenador;
import clases.Movimiento;
import clases.Pokemon;
import clases.Tipo;
import database.BDException;
import database.GestorBD;

public class VentanaLogin extends JFrame implements ActionListener {
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
	private Entrenador rojo;
	private Dimension tamanyoBotones;
	private String eleccionAvatar;
	private GestorBD baseDeDatos = new GestorBD();
	static Entrenador entrenadorActual;
	public List<Entrenador> usuarios = new ArrayList<Entrenador>();
	public List<Pokemon> pokemons = new ArrayList<Pokemon>();
	public List<Tipo> tipos = new ArrayList<Tipo>();
	public List<Movimiento> movimientos = new ArrayList<Movimiento>();
	private static Logger logger_Login = Logger.getLogger(VentanaLogin.class.getName());
	
	public VentanaLogin() throws BDException {
		this.setSize(800, 600);
		this.setLayout(new BorderLayout());
		this.setTitle("Pokemon Showdown");
		this.setResizable(false);
		baseDeDatos.conectar();
		tipos = baseDeDatos.obtenerTodosTipos();
		movimientos = baseDeDatos.obtenerTodosMovimientos(tipos);
		pokemons = baseDeDatos.obtenerTodosPokemon(movimientos);
		usuarios = baseDeDatos.obtenerTodosUsuarios(pokemons);
		usernameLabel = new JLabel("Usuario:");
		username = new JTextField();
		username.setEditable(true);
		username.setPreferredSize(new Dimension(250, 45));
		username.setFont(new Font("Comic Sainz MS", Font.BOLD, 20));
		passwordLabel = new JLabel("Contraseña:");
		password = new JTextField();
		password.setEditable(true);
		password.setPreferredSize(new Dimension(250, 45));
		password.setFont(new Font("", Font.BOLD, 20));
		pContent = new JPanel(new GridLayout(1, 3));
		pDatos = new JPanel(new GridLayout(2, 1));
		pUsername = new JPanel(new FlowLayout());
		pUsername.add(usernameLabel);
		pUsername.add(username);
		pPassword = new JPanel(new FlowLayout());
		pPassword.add(passwordLabel);
		pPassword.add(password);

		pBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 60));
		pDatos.add(pUsername);
		pDatos.add(pPassword);
		tamanyoBotones = new Dimension(120, 50);
		signInButton = new JButton("Iniciar sesión");
		signInButton.setPreferredSize(tamanyoBotones);
		signUpButton = new JButton("Registrarse");
		signUpButton.setPreferredSize(tamanyoBotones);
		pBotones.add(signInButton);
		pBotones.add(signUpButton);

		blanco = new JPanel(new FlowLayout());
		blanco.setBackground(Color.black);
		blanco1 = new JPanel(new FlowLayout());
		pContent.add(pDatos, BorderLayout.SOUTH);
		blanco.setPreferredSize(new Dimension(300, 300));
		background = new JLabel(new ImageIcon(getClass().getResource("/resources/PokemonShowdownTitle.jpg")));
		this.add(background, BorderLayout.CENTER);
		background.setLayout(new FlowLayout());
		pContent.add(pBotones);
		salir = new JButton("Salir del juego");
		avatarNames = new String[] { "Chico", "Chica", "Otros" };
		avatar = new JLabel("Avatar:");
		avatar.setForeground(Color.WHITE);
		avatarComboBox = new JComboBox<>(avatarNames);
		avatarComboBox.setPreferredSize(new Dimension(100, 50));
		pComboBox = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 40));
		pComboBox.add(avatar);
		pComboBox.add(avatarComboBox);
		pComboBox.add(salir);

		pContent.add(pComboBox);
		

		try {
			usuarios = baseDeDatos.obtenerTodosUsuarios(pokemons);
			rojo = usuarios.get(0);
		} catch (BDException e3) {
			e3.printStackTrace();
		}
		

		pBotones.setBackground(Color.DARK_GRAY);
		pComboBox.setBackground(Color.DARK_GRAY);
		pContent.setBackground(Color.DARK_GRAY);
		background.setMinimumSize(new Dimension(200, 200));
		this.add(pContent, BorderLayout.SOUTH);
		pBotones.setBounds(100, 100, 1000, 100);
		this.setMinimumSize(new Dimension(825, 670));
		signInButton.addActionListener(this);
		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
		});
		signUpButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		String s = username.getText();
		String p = password.getText();

		if (event.getSource() == signInButton) {

			s = username.getText();
			p = password.getText();
			try {
				usuarios = baseDeDatos.obtenerTodosUsuarios(pokemons);
			} catch (BDException e) {
				e.printStackTrace();
			}

			if (!s.isEmpty() && !p.isEmpty()) {
				int existe = 1;
				for (Entrenador entrenador : usuarios) {
					if (entrenador.getUsuario().equals(s) && entrenador.getContraseña().equals(p)) {
						JOptionPane.showMessageDialog(this, "Se ha realizado con exito");
						existe++;
						entrenadorActual = entrenador;
						dispose();
						eleccionAvatar = (String) avatarComboBox.getSelectedItem();
						VentanaInicio v = new VentanaInicio(entrenadorActual, eleccionAvatar, rojo);
						v.setVisible(true);

					}

				}
				if (existe == 1) {
					JOptionPane.showMessageDialog(this, "El entrenador no existe");
				}

			} else {
				JOptionPane.showMessageDialog(this, "Error rellene todos los campos para proceder", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (event.getSource() == signUpButton) {
			int existe = 1;
			s = username.getText();
			p = password.getText();

			if (!s.isEmpty() && !p.isEmpty()) {
				try {
					usuarios = baseDeDatos.obtenerTodosUsuarios(pokemons);
				} catch (BDException e3) {
					e3.printStackTrace();
				}
				for (Entrenador entrenador : usuarios) {
					if (entrenador.getUsuario().equals(s)) {
						JOptionPane.showMessageDialog(this, "El usuario ya existe");
						existe++;
					}
				}
				if (existe == 1) {
					Entrenador e = new Entrenador();
					List<Integer> equipo = new ArrayList<Integer>();
					List<Pokemon> TodosPokemons = new ArrayList<Pokemon>();
					List<Movimiento> movimientos = new ArrayList<Movimiento>();
					List<Pokemon> pokemons = new ArrayList<Pokemon>();

					try {
						movimientos.addAll(GestorBD.obtenerTodosMovimientos(tipos));
					} catch (BDException e2) {
						e2.printStackTrace();
					}

					for (int i = 0; i < 6; i++) {
						Random rnd = new Random();
						equipo.add((int) (rnd.nextDouble() * 19));
					}
					try {
						TodosPokemons.addAll(GestorBD.obtenerTodosPokemon(movimientos));

					} catch (BDException e1) {
						e1.printStackTrace();
					}
					for (int j = 0; j < 6; j++) {
						pokemons.add(TodosPokemons.get(equipo.get(j)));
					}

					e.setUsuario(s);
					e.setContraseña(p);
					e.setScore(0);
					e.setPokemons(pokemons);
					entrenadorActual = e;
					try {
						baseDeDatos.insertarEntrenador(e);
						usuarios = baseDeDatos.obtenerTodosUsuarios(pokemons);
						JOptionPane.showMessageDialog(this, "Usuario creado con éxito. Prueba a iniciar sesión");

					} catch (BDException | ClassNotFoundException e1) {
						e1.printStackTrace();
						System.out.println("No se pudo insertar el entrenador en la BD");
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "Error rellene todos los campos para proceder", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	public static void main(String[] args) throws BDException {
		// TODO Auto-generated method stub
		VentanaLogin v = new VentanaLogin();
		v.setVisible(true);
		
		//logger_Login.setLevel(Level.ALL);
		//try {
			//H
		//}
	}
}
