package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

import clases.Entrenador;
import clases.Movimiento;
import clases.Pokemon;

public class VentanaCombate extends JFrame{
	private JPanel pDerecha;
	private JPanel pContent;
	private JPanel pMovimientos;
	private JPanel pEntrenador1;
	private JPanel pEntrenador2;
	private JPanel pPokemon1;
	private JPanel pPokemon2;
	private JPanel pPokemon1Estadisticas;
	private JPanel pPokemon2Estadisticas;
	private JPanel pEquipoPokemon;
	private JPanel pComentarista;
	private JButton movimiento1;
	private JButton movimiento2;
	private JTextArea logger;
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
	private Entrenador entrenador = VentanaLogin.entrenadorActual;
	private Entrenador rojo;
	private Pokemon pokemonActualAliado;
	private Pokemon pokemonRojo;

	private int contadorAliado = 0;
	private int contadorEnemigo = 0;
	
	
	private VentanaFinCombate ventanaFinCombate;



	public VentanaCombate() {
		this.setSize(new Dimension(1200,800));
		setTitle("POKEMON SHOWDOWN");
		setLayout(new BorderLayout());
		logger = new JTextArea("Hola puta");
		logger.setEditable(false);
		loggerWidth = 200;
		loggerHeigth = 810;
		loggerDimension = new Dimension(loggerWidth, loggerHeigth);
		logger.setPreferredSize(loggerDimension);
		pComentarista = new JPanel();
		pComentarista.add(logger);
		add(pComentarista,BorderLayout.EAST);
		movimientosDimension = new Dimension(20, 100);
		pMovimientos = new JPanel(new GridLayout(1,2));
		
		
		

		
		
		movimiento1 = new JButton("");
		movimiento1.setPreferredSize(movimientosDimension);
		pMovimientos.add(movimiento1);
		movimiento1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		} );
		movimiento2 = new JButton("");
		pMovimientos.add(movimiento2);
		movimiento2.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		} );
		pContent = new JPanel(new BorderLayout());
		lblNombreAliado  = new JLabel();
		lblNombreAliado.setForeground(Color.WHITE);
		lblNombreAliado.setBounds(54,22,135,15);
		pContent.add(lblNombreAliado);
		
		
		pContent.add(pMovimientos,BorderLayout.SOUTH);
		add(pContent,BorderLayout.CENTER);
		
		hpPokemonAliado = new JProgressBar();
		hpPokemonAliado.setStringPainted(true);
		hpPokemonAliado.setForeground(Color.GREEN);
		hpPokemonAliado.setBounds(50,50,0,0);
		pContent.add(hpPokemonAliado);
		hpPokemonEnemigo = new JProgressBar();
		cargarPokemonAliado();
		cargarPokemonEnemigo();
		setVisible(true);
	}
	public void cargarPokemonAliado() {
		
			pokemonActualAliado = entrenador.getPokemons().get(contadorAliado); 
			lblNombreAliado.setText(pokemonActualAliado.getNombre());
			hpPokemonAliado.setMaximum(pokemonActualAliado.getHp());
			hpPokemonAliado.setMaximum(0);
			hpPokemonAliado.setValue(pokemonActualAliado.getHp());
			movimiento1.setText(pokemonActualAliado.getMovimiento1().toString());
			movimiento2.setText(pokemonActualAliado.getMovimiento2().toString());
			
	}
	public void cargarPokemonEnemigo() {
		pokemonRojo = entrenador.getPokemons().get(contadorEnemigo); 
		lblNombreEnemigo.setText(pokemonRojo.getNombre());
		hpPokemonEnemigo.setMaximum(pokemonRojo.getHp());
		hpPokemonEnemigo.setMaximum(0);
		hpPokemonEnemigo.setValue(pokemonRojo.getHp());
	}
	public static void main(String[] args) {
		VentanaCombate v = new VentanaCombate();
		
	}
	public int quienAtacaPrimero(int velocidad1, int velocidad2) {
		if(velocidad1 > velocidad2) {
			
			return 1;
		}
		if(velocidad2 < velocidad1) {
			return 2;
		}
		else {
			return (int) (Math.random() * 2 + 1);
		}

	}
	
	
	public void atacarJugador(Movimiento movimiento) {
		String cadena = "\n\t" + pokemonActualAliado.getNombre() + "USÓ" + movimiento.getNombre();
		textoLogger += cadena;
		logger.setText(textoLogger);
		
		if(pokemonEsDerrotado(pokemonRojo)) {
			contadorEnemigo++;
			if(contadorEnemigo!=6) {
				cargarPokemonEnemigo();
			}
		}
		hpPokemonEnemigo.setValue(hpPokemonEnemigo.getValue()-movimiento.getDaño());
		
		
		
	}
	public void atacarRojo(Movimiento movimiento) {
		String cadena = "\n\t" + pokemonRojo.getNombre() + "USÓ" + movimiento.getNombre();
		textoLogger += cadena;
		logger.setText(textoLogger);
		if(pokemonEsDerrotado(pokemonActualAliado)) {
			contadorEnemigo++;
			if(contadorEnemigo!=6) {
				cargarPokemonEnemigo();
			}
		}
		hpPokemonAliado.setValue(hpPokemonAliado.getValue()-movimiento.getDaño());
	}
	public boolean pokemonEsDerrotado(Pokemon pokemon) {
		if(pokemon.getHp()<=0) {
			return true;
			
		}
		return false;
	}
	public void comprobarganador() {
		if(contadorAliado ==6) {
			ventanaFinCombate= new VentanaFinCombate();
			ventanaFinCombate.setVisible(true);
		}
		if(contadorEnemigo==6) {
			ventanaFinCombate= new VentanaFinCombate();
			ventanaFinCombate.setVisible(true);
		}
	}
}
