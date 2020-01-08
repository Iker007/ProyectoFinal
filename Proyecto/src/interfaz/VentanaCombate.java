package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.table.TableColumn;

import clases.Entrenador;
import clases.Movimiento;
import clases.Pokemon;
import clases.Tipo;

public class VentanaCombate extends JFrame implements ActionListener {
	private JPanel pCombate;
	private JPanel pContent;
	private JPanel pMovimientos;
	private JPanel pEntrenador1;
	private JPanel pEntrenador2;
	private JPanel pPokemon1;
	private JPanel pPokemon2;
	private JPanel pPokemon1Hp;
	private JPanel pPokemon2Hp;
	private JPanel pEquipoPokemon;
	private JPanel pComentarista;
	private JButton movimiento1;
	private JButton movimiento2;
	private JTextArea logger ;
	private int ventanaWidth;
	private int ventanaHeigth;
	private Dimension ventanaDimension;
	private JProgressBar hpPokemonAliado;
	private JProgressBar hpPokemonEnemigo;
	private JLabel hp;
	private JLabel lblNombreAliado;
	private JLabel lblNombreEnemigo;
	private JComboBox comboBox;
	private String textoLogger;
	private int loggerWidth;
	private int loggerHeigth;
	private Dimension loggerDimension;
	private Dimension movimientosDimension;
	private Entrenador entrenador;
	private Entrenador rojo;
	private Pokemon pokemonActualAliado;
	private Pokemon pokemonRojo;
	private String avatar;
	private List<Pokemon> equipo;

	private int contadorAliado = 0;
	private int contadorEnemigo = 0;

	private VentanaFinCombate ventanaFinCombate;

	public VentanaCombate(Entrenador entrenadorActual, String eleccionAvatar, Entrenador rojo) {
		this.setSize(new Dimension(1200, 800));
		setTitle("POKEMON SHOWDOWN");
		setLayout(new BorderLayout());
		this.entrenador = entrenadorActual;
		this.rojo = rojo;
		this.avatar = eleccionAvatar;
		logger = new JTextArea();
		textoLogger = "Datos del combate:";
		logger.setText(textoLogger);
		logger.setEditable(false);
		loggerWidth = 200;
		loggerHeigth = 810;
		loggerDimension = new Dimension(loggerWidth, loggerHeigth);
		logger.setPreferredSize(loggerDimension);
		pComentarista = new JPanel();
		pComentarista.add(logger);
		add(pComentarista, BorderLayout.EAST);
		movimientosDimension = new Dimension(20, 100);
		pMovimientos = new JPanel(new GridLayout(1, 2));

		movimiento1 = new JButton("");
		movimiento1.setPreferredSize(movimientosDimension);
		pMovimientos.add(movimiento1);
		movimiento1.addActionListener(this);

		movimiento2 = new JButton("");
		movimiento1.setPreferredSize(movimientosDimension);
		pMovimientos.add(movimiento2);
		movimiento2.addActionListener(this);
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
		// hpPokemonAliado.setBounds(50,50,0,0);
		pContent.add(hpPokemonAliado);
		hpPokemonEnemigo = new JProgressBar();
		hpPokemonEnemigo.setStringPainted(true);
		hpPokemonEnemigo.setForeground(Color.GREEN);
		pCombate = new JPanel(new BorderLayout());

		pPokemon1 = new JPanel(new GridLayout());
		pPokemon1Hp = new JPanel(new FlowLayout());
		pPokemon1Hp.add(lblNombreEnemigo);
		pPokemon1.add(pPokemon1Hp);
		pPokemon1.add(hpPokemonEnemigo);
		pCombate.add(pPokemon1, BorderLayout.NORTH);

		pPokemon2 = new JPanel(new GridLayout());
		pPokemon2Hp = new JPanel(new FlowLayout());
		pPokemon2Hp.add(lblNombreAliado);
		pPokemon2.add(hpPokemonAliado);
		pPokemon2.add(pPokemon2Hp);
		pCombate.add(pPokemon2, BorderLayout.SOUTH);
		pContent.add(pCombate,BorderLayout.CENTER);
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
	}

	public void cargarPokemonAliado() {

		pokemonActualAliado = entrenador.getPokemons().get(contadorAliado);
		lblNombreAliado.setText(  ": HP" + pokemonActualAliado.getNombre() );
		hpPokemonAliado.setMaximum(pokemonActualAliado.getHp());
		hpPokemonAliado.setMinimum(0);
		hpPokemonAliado.setValue(pokemonActualAliado.getHp());
		movimiento1.setText(pokemonActualAliado.getMovimiento1().getNombre());
		movimiento2.setText(pokemonActualAliado.getMovimiento2().getNombre());

	}

	public void cargarPokemonEnemigo() {
		pokemonRojo = rojo.getPokemons().get(contadorEnemigo);

		lblNombreEnemigo.setText(pokemonRojo.getNombre() + " HP:");
		hpPokemonEnemigo.setMaximum(pokemonRojo.getHp());
		hpPokemonEnemigo.setMinimum(0);
		hpPokemonEnemigo.setValue(pokemonRojo.getHp());
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

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == movimiento1) { // Recibe el ataque del boton
			esconderBotones();              // Esconde los botones
			if (quienAtacaPrimero() == 1) { // Elige quien ataca primero
				atacarJugador(pokemonActualAliado.getMovimiento1()); // Ataca con el pokemon y el movimiento elegido
				if (pokemonEsDerrotado(hpPokemonEnemigo)) {
					cargarPokemonEnemigo();
				}
				else  
					atacarJugador(pokemonActualAliado.getMovimiento1());
					if (pokemonEsDerrotado(hpPokemonAliado)) {
						cargarPokemonAliado();
					}
					else if (!pokemonEsDerrotado(hpPokemonEnemigo)) {
						atacarRojo(pokemonRojo.getMovimiento2());
					if (pokemonEsDerrotado(hpPokemonAliado)) {
						cargarPokemonAliado();
					
					}
				} 
				}
			
			if (quienAtacaPrimero() == 2) {
				atacarRojo(pokemonRojo.getMovimiento2());
				if (pokemonEsDerrotado(hpPokemonAliado)) {
					cargarPokemonAliado();

				}
				else  
					atacarJugador(pokemonActualAliado.getMovimiento1()); // Ataca con el pokemon y el movimiento elegido
				if (pokemonEsDerrotado(hpPokemonEnemigo)) {
					cargarPokemonEnemigo();


				}
			}

		}




		inicioDeTurno();
		if (e.getSource() == movimiento2) {
			esconderBotones();
			if (quienAtacaPrimero() == 2) {
				atacarRojo(pokemonRojo.getMovimiento1());
				if (!pokemonEsDerrotado(hpPokemonAliado)) {
					atacarJugador(pokemonActualAliado.getMovimiento2());
					inicioDeTurno();
				} else {
					cargarPokemonAliado();
					if (pokemonEsDerrotado(hpPokemonEnemigo)) {
						cargarPokemonEnemigo();
					}
				}
			}
			}
			inicioDeTurno();
		
	}


	public void esconderBotones() {
		movimiento1.setVisible(false);
		movimiento2.setVisible(false);

	}

	public void inicioDeTurno() {
		movimiento1.setVisible(true);
		movimiento2.setVisible(true);

	}

	public void atacarJugador(Movimiento movimiento) {
		String cadena = "\n\t" + pokemonActualAliado.getNombre() + " US� " + movimiento.getNombre();
		textoLogger += cadena;
		logger.setText(textoLogger);
		if ((pokemonRojo.getDefense() - (movimiento.getDa�o()+pokemonActualAliado.getAtak())) < 0) {
			hpPokemonEnemigo.setValue(hpPokemonEnemigo.getValue() - movimiento.getDa�o());
		} else {
			hpPokemonEnemigo.setValue(hpPokemonEnemigo.getValue() - 10);
		}

		if (pokemonEsDerrotado(hpPokemonEnemigo)) {
			contadorEnemigo++;
			if (contadorEnemigo != 6) {
				cargarPokemonEnemigo();
			}
		}

		comprobarganador();

	}

	public void atacarRojo(Movimiento movimiento) {
		String cadena = "\n\t" + pokemonRojo.getNombre() + " US� " +  movimiento.getNombre();

		textoLogger += cadena + "\n\t";
		logger.setText(textoLogger);
		if ((pokemonActualAliado.getDefense() - (movimiento.getDa�o()+ pokemonRojo.getAtak())) < 0) {
			hpPokemonAliado.setValue(hpPokemonAliado.getValue() - movimiento.getDa�o());
		} else {
			hpPokemonAliado.setValue(hpPokemonAliado.getValue() - 10);
		}
		if (pokemonEsDerrotado(hpPokemonAliado)) {
			contadorAliado++;
			if (contadorAliado != 6) {
				cargarPokemonAliado();
			}
		}

		comprobarganador();
	}

	public boolean pokemonEsDerrotado(JProgressBar hppokemon) {
		if (hppokemon.getValue() <= 0) {
			return true;

		}
		return false;
	}

	//	public static void main(String[] args) {
	//		List<Pokemon> equipo = new ArrayList<Pokemon>();
	//		List<Pokemon> equipo2 = new ArrayList<Pokemon>();
	//		Tipo t1 = new Tipo("t1");
	//		Tipo t2 = new Tipo("t2");
	//
	//		Movimiento m1 = new Movimiento("as", t1, 12, "a");
	//		Movimiento m2 = new Movimiento("df", t2, 12, "b");
	//
	//		Pokemon p1 = new Pokemon("a", 0, t1, t2, m1, m2, 10, 10, 10, 10);
	//		Pokemon p2 = new Pokemon("b", 0, t1, t2, m1, m2, 10, 10, 10, 10);
	//		Pokemon p3 = new Pokemon("c", 0, t1, t2, m1, m2, 10, 10, 10, 10);
	//		Pokemon p4 = new Pokemon("d", 0, t1, t2, m1, m2, 10, 10, 10, 10);
	//		Pokemon p5 = new Pokemon("e", 0, t1, t2, m1, m2, 10, 10, 10, 10);
	//		Pokemon p6 = new Pokemon("f", 0, t1, t2, m1, m2, 10, 10, 10, 10);
	//		Pokemon p7 = new Pokemon("a", 0, t1, t2, m1, m2, 10, 10, 10, 10);
	//		Pokemon p8 = new Pokemon("b", 0, t1, t2, m1, m2, 10, 10, 10, 10);
	//		Pokemon p9 = new Pokemon("c", 0, t1, t2, m1, m2, 10, 10, 10, 10);
	//		Pokemon p10 = new Pokemon("d", 0, t1, t2, m1, m2, 10, 10, 10, 10);
	//		Pokemon p11 = new Pokemon("e", 0, t1, t2, m1, m2, 10, 10, 10, 10);
	//		Pokemon p12 = new Pokemon("f", 0, t1, t2, m1, m2, 10, 10, 10, 10);
	//
	//		equipo.add(p1);
	//		equipo.add(p2);
	//		equipo.add(p3);
	//		equipo.add(p4);
	//		equipo.add(p5);
	//		equipo.add(p6);
	//		equipo2.add(p7);
	//		equipo2.add(p8);
	//		equipo2.add(p9);
	//		equipo2.add(p10);
	//		equipo2.add(p11);
	//		equipo2.add(p12);
	//		Entrenador entrenadorActual = new Entrenador("a", 0, "a", equipo);
	//		Entrenador rojo = new Entrenador("b", 0, "c", equipo2);
	//		VentanaCombate v = new VentanaCombate(entrenadorActual, rojo);
	//
	//	}

	public void comprobarganador() {
		VentanaFinCombate ventanaFinCombate;
		if (contadorAliado == 6) {
			ventanaFinCombate = new VentanaFinCombate(entrenador, avatar, rojo);
			ventanaFinCombate.setVisible(true);
			dispose();
		}
		if (contadorEnemigo == 6) {
			ventanaFinCombate = new VentanaFinCombate(entrenador, avatar, rojo);
			ventanaFinCombate.setVisible(true);
			dispose();
		}
	}
}