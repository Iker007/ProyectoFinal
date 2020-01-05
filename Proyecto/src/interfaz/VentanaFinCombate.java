package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.Entrenador;
import database.BDException;

public class VentanaFinCombate extends JFrame {

	private JButton revancha;
	private JButton cerrarSesion;
	private JButton salir;
	private JLabel entrenador;
	private JLabel ganadas;
	private JMenuBar menuBar;
	private JMenu exportar;
	private static Entrenador entrenadorActual;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel2a;
	private JPanel panel2b;
	private JPanel panel2c;
	private JPanel hueco1;
	private JPanel hueco2;
	private JPanel hueco3;
	private static String eleccionAvatar;

	public VentanaFinCombate(Entrenador entrenadorActual, String eleccionAvatar) {
		this.setLayout(new FlowLayout());
		this.entrenadorActual = entrenadorActual;
		this.eleccionAvatar = eleccionAvatar;
		menuBar = new JMenuBar();
		salir = new JButton("Salir");
		salir.setPreferredSize(new Dimension(200, 50));
		revancha = new JButton("Revancha");
		revancha.setPreferredSize(new Dimension(200, 50));
		cerrarSesion = new JButton("Cerrar sesión");
		cerrarSesion.setPreferredSize(new Dimension(200, 50));

		// entrenador = new JLabel(setEntrenador(entrenador););

		setResizable(false);
		this.setSize(1100, 1000);
		this.setVisible(true);
		this.setTitle("Pokemon Showdown");
		this.setLayout(new GridLayout(2, 1));
		panel1 = new JPanel();
		panel1.setBackground(Color.RED);
		this.add(panel1);
		panel2 = new JPanel();
		panel2.setBackground(Color.BLACK);
		hueco1 = new JPanel();
		hueco1.setVisible(false);
		hueco2 = new JPanel();
		hueco2.setVisible(false);
		hueco3 = new JPanel();
		hueco3.setVisible(false);
		panel2.setLayout(new GridLayout(2, 3));
		panel2a = new JPanel(new FlowLayout());
		panel2a.add(cerrarSesion);
		panel2b = new JPanel(new FlowLayout());
		panel2b.add(revancha);
		panel2c = new JPanel(new FlowLayout());
		panel2c.add(salir);
		panel2.add(hueco1);
		panel2.add(hueco2);
		panel2.add(hueco3);
		panel2.add(panel2a);
		panel2.add(panel2b);
		panel2.add(panel2c);
		this.add(panel2);

		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		revancha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaInicio v = new VentanaInicio(entrenadorActual, eleccionAvatar);
				v.setVisible(true);
			}
		});
		cerrarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaLogin v;
				try {
					v = new VentanaLogin();
					v.setVisible(true);
				} catch (BDException e1) {
					e1.printStackTrace();
				}

			}
		});

	}

	public void leerFicheroRanking() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File("C:\\Documents\\Ranking.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			while ((linea = br.readLine()) != null) {
				entrenador.setText("hola");
				System.out.println(linea);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public void crearFicheroRanking(List<Entrenador> lista) {
		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("c:\\Documents\\Ranking.txt");
			pw = new PrintWriter(fichero);

			for (Entrenador e : lista) {
				pw.println(e.getUsuario() + ":" + e.getScore());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		VentanaFinCombate v = new VentanaFinCombate(entrenadorActual, eleccionAvatar);

	}

	public JLabel getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador.setText(entrenador.getUsuario());
	}
	
	
}
