package interfaz;

import java.awt.BorderLayout;import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

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
	private JProgressBar hpPokemon1;
	private JProgressBar hpPokemon2;
	private JLabel hp;
	private String textoLogger;
	private int loggerWidth;
	private int loggerHeigth;
	private Dimension loggerDimension;
	private Dimension movimientosDimension;
	
	public VentanaCombate() {
		ventanaWidth = 1200;
		ventanaHeigth = 800;
		ventanaDimension = new Dimension(ventanaWidth, ventanaHeigth);
		this.setSize(ventanaDimension);
		this.setTitle("POKEMON SHOWDOWN");
		this.setLayout(new BorderLayout());
		logger = new JTextArea("Hola puta");
		logger.setEditable(false);
		loggerWidth = 200;
		loggerHeigth = 810;
		loggerDimension = new Dimension(loggerWidth, loggerHeigth);
		logger.setPreferredSize(loggerDimension);
		pComentarista = new JPanel();
		pComentarista.add(logger);
		this.add(pComentarista,BorderLayout.EAST);
		movimientosDimension = new Dimension(100, 100);
		pMovimientos = new JPanel(new GridLayout(1,2));
		movimiento1 = new JButton("Hoja AFILADA");
		movimiento1.setPreferredSize(movimientosDimension);
		movimiento2 = new JButton("CAQUITA");
		pMovimientos.add(movimiento1);
		pMovimientos.add(movimiento2);
		pContent = new JPanel(new BorderLayout());
		pContent.add(pMovimientos,BorderLayout.SOUTH);
		this.add(pContent,BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	public static void main(String[] args) {
		VentanaCombate v = new VentanaCombate();
	}

}
