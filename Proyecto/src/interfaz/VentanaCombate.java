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
import java.util.List;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import clases.Entrenador;
import clases.Movimiento;
import clases.Pokemon;
import database.BDException;

public class VentanaCombate extends JFrame implements ActionListener {
	private JPanel pCombate;
	private JPanel pContent;
	private JPanel pMovimientos;
	
	private JPanel pPokemon1;
	private JPanel pPokemon2;
	private JPanel pPokemon1Hp;
	private JPanel pPokemon2Hp;
	
	private JPanel pComentarista;
	private JButton movimiento1;
	private JButton movimiento2;
	private JTextArea logger;
	
	private JProgressBar hpPokemonAliado;
	private JProgressBar hpPokemonEnemigo;
	
	private JLabel lblNombreAliado;
	private JLabel lblNombreEnemigo;
	
	private String textoLogger;


	private Dimension movimientosDimension;
	private Entrenador entrenador;
	private Entrenador rojo;
	private Pokemon pokemonActualAliado;
	private Pokemon pokemonRojo;
	private String avatar;
	
	private JLabel pokemonRival;
	private ImageIcon ImagenPOK2;
	private Image ImagenPOK2B;
	private Image NewImagenPOK2;
	private JLabel pokemonAliado;
	private ImageIcon ImagenPOK1;
	private Image ImagenPOK1B;
	private Image NewImagenPOK1;
	private JLabel zonaCombate;
	private JScrollPane jScrollPane ;
	private Entrenador ganador;

	private int contadorAliado = 0;
	private int contadorEnemigo = 0;
	private static Logger logger_Combate = Logger.getLogger(VentanaCombate.class.getName());

	public VentanaCombate(Entrenador entrenadorActual, String eleccionAvatar, Entrenador rojo) {
		logger_Combate.info("Creando ventana Combate");
		this.setSize(new Dimension(1400, 800));
		setTitle("POKEMON SHOWDOWN");
		setLayout(new BorderLayout());
		this.entrenador = entrenadorActual;
		this.rojo = rojo;
		this.avatar = eleccionAvatar;
		pokemonActualAliado = entrenador.getPokemons().get(0);
		pokemonRojo = rojo.getPokemons().get(0);
		logger = new JTextArea();
		
		textoLogger = "Datos del combate:" + "\n Te ha retado el entrenador Rojo";
		logger.setText(textoLogger);
		logger.setEditable(false);
		logger.setFont(new Font("Agency FB", Font.BOLD, 16));
		jScrollPane = new JScrollPane();
		jScrollPane.getViewport().setBackground(Color.white);
		jScrollPane.getViewport().add(logger);
		jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pComentarista = new JPanel();
		jScrollPane.setPreferredSize(new Dimension(200,750));
		pComentarista.add(jScrollPane);
		pComentarista.setBorder(new LineBorder(Color.BLACK));
		add(pComentarista, BorderLayout.EAST);
		movimientosDimension = new Dimension(20, 100);
		pMovimientos = new JPanel(new GridLayout(1, 2));

		movimiento1 = new JButton("");
		movimiento1.setPreferredSize(movimientosDimension);
		pMovimientos.add(movimiento1);

		movimiento2 = new JButton("");
		movimiento1.setPreferredSize(movimientosDimension);
		pMovimientos.add(movimiento2);
		pContent = new JPanel(new BorderLayout());
		lblNombreAliado = new JLabel();
		lblNombreAliado.setForeground(Color.BLACK);
		lblNombreAliado.setBounds(54, 22, 135, 15);
		pContent.add(lblNombreAliado);

		lblNombreEnemigo = new JLabel();
		lblNombreEnemigo.setForeground(Color.BLACK);
		lblNombreEnemigo.setBounds(54, 22, 135, 15);

		hpPokemonAliado = new JProgressBar();
		hpPokemonAliado.setStringPainted(true);
		hpPokemonAliado.setForeground(Color.GREEN);
		pContent.add(hpPokemonAliado);
		hpPokemonEnemigo = new JProgressBar();
		hpPokemonEnemigo.setStringPainted(true);
		hpPokemonEnemigo.setForeground(Color.GREEN);
		pCombate = new JPanel(new BorderLayout());

		ImagenPOK1 = new ImageIcon(
				getClass().getResource("/resources/" + pokemonActualAliado.getNombre().toLowerCase() + ".png"));
		ImagenPOK1B = ImagenPOK1.getImage();
		NewImagenPOK1 = ImagenPOK1B.getScaledInstance(150, 175, java.awt.Image.SCALE_SMOOTH);
		ImagenPOK1 = new ImageIcon(NewImagenPOK1);
		pokemonAliado = new JLabel((ImagenPOK1));
		pokemonAliado.setBackground(new Color(0, 0, 0, 0));

		pPokemon1 = new JPanel(new GridLayout());
		pPokemon1Hp = new JPanel(new FlowLayout());
		pPokemon1Hp.add(lblNombreEnemigo);
		pPokemon1.add(pPokemon1Hp);
		pPokemon1.add(hpPokemonEnemigo);
		pCombate.add(pPokemon1, BorderLayout.NORTH);

		ImagenPOK2 = new ImageIcon(
				getClass().getResource("/resources/" + pokemonRojo.getNombre().toLowerCase() + ".png"));
		ImagenPOK2B = ImagenPOK2.getImage();
		NewImagenPOK2 = ImagenPOK2B.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
		ImagenPOK2 = new ImageIcon(NewImagenPOK2);
		pokemonRival = new JLabel((ImagenPOK2));
		pokemonRival.setBackground(new Color(0, 0, 0, 0));

		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resources/FondoCombate.png")); // load
		Image image = imageIcon.getImage(); // transformarlo
		Image newimg = image.getScaledInstance(1000, 600, java.awt.Image.SCALE_SMOOTH); // escalarlo con smooth scaling
		imageIcon = new ImageIcon(newimg); // vuelve a transformarlo

		zonaCombate = new JLabel(imageIcon);
		zonaCombate.setLayout(new GridLayout(1, 2));

		zonaCombate.add(pokemonAliado);
		zonaCombate.add(pokemonRival);

		pCombate.add(zonaCombate);

		pPokemon2 = new JPanel(new GridLayout());
		pPokemon2Hp = new JPanel(new FlowLayout());
		pPokemon2Hp.add(lblNombreAliado);
		pPokemon2.add(hpPokemonAliado);
		pPokemon2.add(pPokemon2Hp);
		pCombate.add(pPokemon2, BorderLayout.SOUTH);
		pContent.add(pCombate, BorderLayout.CENTER);
		pContent.add(pMovimientos, BorderLayout.SOUTH);
		add(pContent, BorderLayout.CENTER);

		cargarPokemonAliado();
		cargarPokemonEnemigo();
		setVisible(true);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		movimiento1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				esconderBotones(); // Esconde los botones
				if (quienAtacaPrimero() == 1) { // Elige quien ataca primero
					try {
						atacarJugador(pokemonActualAliado.getMovimiento1());
					} catch (BDException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} // Ataca con el pokemon y el movimiento elegido
					if (pokemonEsDerrotado(hpPokemonEnemigo)) {
						cargarPokemonEnemigo();
					} else
						try {
							atacarRojo(pokemonRojo.getMovimiento2());
						} catch (BDException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					if (pokemonEsDerrotado(hpPokemonAliado)) {
						cargarPokemonAliado();
					}

				} else if (quienAtacaPrimero() == 2) {
					try {
						atacarRojo(pokemonRojo.getMovimiento2());
					} catch (BDException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if (pokemonEsDerrotado(hpPokemonAliado)) {
						cargarPokemonAliado();
					} else
						try {
							atacarJugador(pokemonActualAliado.getMovimiento1());
						} catch (BDException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} // Ataca con el pokemon y el movimiento
																				// elegido
					if (pokemonEsDerrotado(hpPokemonEnemigo)) {
						cargarPokemonEnemigo();
					}
				}
				inicioDeTurno();
				
			}
		});

		movimiento2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				esconderBotones(); // Esconde los botones
				if (quienAtacaPrimero() == 1) { // Elige quien ataca primero
					try {
						atacarJugador(pokemonActualAliado.getMovimiento2());
					} catch (BDException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} // Ataca con el pokemon y el movimiento elegido
					if (pokemonEsDerrotado(hpPokemonEnemigo)) {
						cargarPokemonEnemigo();
					} else
						try {
							atacarRojo(pokemonRojo.getMovimiento1());
						} catch (BDException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					if (pokemonEsDerrotado(hpPokemonAliado)) {
						cargarPokemonAliado();
					}

				} else if (quienAtacaPrimero() == 2) {
					try {
						atacarRojo(pokemonRojo.getMovimiento1());
					} catch (BDException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if (pokemonEsDerrotado(hpPokemonAliado)) {
						cargarPokemonAliado();
					} else
						try {
							atacarJugador(pokemonActualAliado.getMovimiento2());
						} catch (BDException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} // Ataca con el pokemon y el movimiento
																				// elegido
					if (pokemonEsDerrotado(hpPokemonEnemigo)) {
						cargarPokemonEnemigo();
					}
				}
				inicioDeTurno();
			}
		});
	}

	public void cargarPokemonAliado() {

		zonaCombate.removeAll();

		pokemonActualAliado = entrenador.getPokemons().get(contadorAliado);
		String cadena = "\n" + " Adelante " + pokemonActualAliado.getNombre() + "\n";
		textoLogger += cadena;

		ImagenPOK1 = new ImageIcon(
				getClass().getResource("/resources/" + pokemonActualAliado.getNombre().toLowerCase() + ".png"));
		ImagenPOK1B = ImagenPOK1.getImage();
		NewImagenPOK1 = ImagenPOK1B.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
		ImagenPOK1 = new ImageIcon(NewImagenPOK1);
		pokemonAliado = new JLabel((ImagenPOK1));
		pokemonAliado.setBackground(new Color(0, 0, 0, 0));

		zonaCombate.add(pokemonAliado);
		zonaCombate.add(pokemonRival);

		logger.setText(textoLogger);
		lblNombreAliado.setText(":HP " + pokemonActualAliado.getNombre());
		hpPokemonAliado.setMaximum(pokemonActualAliado.getHp());
		hpPokemonAliado.setMinimum(0);
		hpPokemonAliado.setValue(pokemonActualAliado.getHp());
		movimiento1.setText(pokemonActualAliado.getMovimiento1().getNombre());
		movimiento2.setText(pokemonActualAliado.getMovimiento2().getNombre());
		logger_Combate.info("Anadiendo nuevo pokemon aliado ventana Combate");
	}

	public void cargarPokemonEnemigo() {

		zonaCombate.removeAll();

		pokemonRojo = rojo.getPokemons().get(contadorEnemigo);
		String cadena = "\n" + " Rojo sacó a " + pokemonRojo.getNombre() + "\n";
		textoLogger += cadena;

		ImagenPOK2 = new ImageIcon(
				getClass().getResource("/resources/" + pokemonRojo.getNombre().toLowerCase() + ".png"));
		ImagenPOK2B = ImagenPOK2.getImage();
		NewImagenPOK2 = ImagenPOK2B.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
		ImagenPOK2 = new ImageIcon(NewImagenPOK2);
		pokemonRival = new JLabel((ImagenPOK2));
		pokemonRival.setBackground(new Color(0, 0, 0, 0));

		zonaCombate.add(pokemonAliado);
		zonaCombate.add(pokemonRival);

		logger.setText(textoLogger);
		lblNombreEnemigo.setText(pokemonRojo.getNombre() + " HP: ");
		hpPokemonEnemigo.setMaximum(pokemonRojo.getHp());
		hpPokemonEnemigo.setMinimum(0);
		hpPokemonEnemigo.setValue(pokemonRojo.getHp());
		logger_Combate.info("Anadiendo nuevo pokemon aliado ventana Combate");
	}

	public int quienAtacaPrimero() {
		if (pokemonActualAliado.getSpeed() > pokemonRojo.getSpeed()) {
			return 1;
		}
		if (pokemonRojo.getSpeed() < pokemonActualAliado.getSpeed()) {
			return 2;
		} else {
			return (int) (Math.random() * 2 + 1);
		}

	}
	//Pone los botones desactivados
	public void esconderBotones() {
		movimiento1.setEnabled(false);
		movimiento2.setEnabled(false);
		logger_Combate.info("Escondiendo botones en ventana Combate");
	}
	//Pone los botones activados
	public void inicioDeTurno() {
		movimiento1.setEnabled(true);
		movimiento2.setEnabled(true);
		logger_Combate.info("Poniendo botones en ventana Combate");

	}
	
	public void atacarJugador(Movimiento movimiento) throws BDException {
		String cadena = "\n" + pokemonActualAliado.getNombre() + " usó " + movimiento.getNombre();
		textoLogger += cadena + "\n";
		logger.setText(textoLogger);
		if ((pokemonRojo.getDefense() - (movimiento.getDaño() + pokemonActualAliado.getAttack())) < -10) {
			hpPokemonEnemigo.setValue(hpPokemonEnemigo.getValue()
					+ (pokemonRojo.getDefense() - (movimiento.getDaño() + pokemonActualAliado.getAttack())));
		} else {
			hpPokemonEnemigo.setValue(hpPokemonEnemigo.getValue() - 10);
		}
		if (pokemonEsDerrotado(hpPokemonEnemigo)) {
			contadorEnemigo++;
			if (contadorEnemigo != 6) {
				cargarPokemonEnemigo();
			}
		}
		if (movimiento.getNombre() == "EXPLOSION") {
			hpPokemonAliado.setValue(hpPokemonAliado.getValue() - 1000);
		}
		logger_Combate.info("Jugador atacando");
		comprobarganador();

	}

	public void atacarRojo(Movimiento movimiento) throws BDException {
		String cadena = "\n" + pokemonRojo.getNombre() + " usó " + movimiento.getNombre();

		textoLogger += cadena + "\n";
		logger.setText(textoLogger);
		if ((pokemonActualAliado.getDefense() - (movimiento.getDaño() + pokemonRojo.getAttack())) < -10) {
			hpPokemonAliado.setValue(hpPokemonAliado.getValue()
					+ (pokemonActualAliado.getDefense() - (movimiento.getDaño() + pokemonRojo.getAttack())));
		} else {
			hpPokemonAliado.setValue(hpPokemonAliado.getValue() - 10);

		}
		if (pokemonEsDerrotado(hpPokemonAliado)) {
			contadorAliado++;
			if (contadorAliado != 6) {
				cargarPokemonAliado();
			}
		}
		logger_Combate.info("Rojo atacando ventana Combate");
		comprobarganador();
	}

	public boolean pokemonEsDerrotado(JProgressBar hppokemon) {
		if (hppokemon.getValue() <= 0) {
			logger_Combate.info("Pokemon derrotado");
			return true;
			
		}
		return false;
	}


	public void comprobarganador() throws BDException {
		VentanaFinCombate ventanaFinCombate;
		if (contadorAliado == 6) {
			entrenador.setScore(entrenador.getScore() - 1);
			rojo.setScore(rojo.getScore() + 1);
			ganador = rojo;
			ventanaFinCombate = new VentanaFinCombate(entrenador, avatar, rojo, ganador);
			ventanaFinCombate.setVisible(true);
			dispose();
		}
		if (contadorEnemigo == 6) {
			entrenador.setScore(entrenador.getScore() + 1);
			rojo.setScore(rojo.getScore() - 1);
			ganador = entrenador;
			ventanaFinCombate = new VentanaFinCombate(entrenador, avatar, rojo, ganador);
			ventanaFinCombate.setVisible(true);
			dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}