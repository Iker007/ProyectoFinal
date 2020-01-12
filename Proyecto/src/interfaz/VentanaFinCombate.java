package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import clases.Entrenador;
import clases.Movimiento;
import clases.Pokemon;
import clases.Tipo;
import database.BDException;
import database.GestorBD;

public class VentanaFinCombate extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton revancha;
	private JButton cerrarSesion;
	private JButton salir;
	private JLabel entrenador;
	private JLabel ganadas;
	private JMenuBar menuBar;
	private JMenu exportar;
	private static Entrenador entrenadorActual;
	private Entrenador rojo;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel2a;
	private JPanel panel2b;
	private JPanel panel2c;
	private JPanel hueco1;
	private JPanel hueco2;
	private JPanel hueco3;
	private JMenuBar mb;
    private JMenu menu1;
    private JMenuItem mi1,mi2,mi3;
    private ImageIcon imagenENT;
    private Image imagenENTB;
    private Image newImagenENT;
    private ImageIcon imagenD;
    private Image imagenD2;
    private Image newImagenD;
    private JLabel derrota;
    private ImageIcon imagenV;
    private Image imagenV2;
    private Image newImagenV;
    private JLabel victoria;
    private ImageIcon imagenL;
    private Image imagenL2;
    private Image newImagenL;
    private JLabel liga;
    private JPanel pEntrenador;
    private JPanel fondo;
    private JLabel fondo2;

	private static String eleccionAvatar;
	private List<Entrenador> entrenadores;
	private List<Pokemon> pokemons;
	private List<Movimiento> movimientos;
	private List<Tipo> tipos;
	private GestorBD baseDeDatos = new GestorBD();


	public VentanaFinCombate(Entrenador entrenadorActual, String eleccionAvatar, Entrenador rojo, Entrenador ganador) throws BDException {
		this.setLayout(new FlowLayout());
		this.entrenadorActual = entrenadorActual;
		this.eleccionAvatar = eleccionAvatar;
		this.rojo = rojo;
		menuBar = new JMenuBar();
		salir = new JButton("Salir");
		salir.setPreferredSize(new Dimension(200, 50));
		revancha = new JButton("Revancha");
		revancha.setPreferredSize(new Dimension(200, 50));
		cerrarSesion = new JButton("Cerrar sesión");
		cerrarSesion.setPreferredSize(new Dimension(200, 50));
		
		fondo2 = new JLabel(new ImageIcon(getClass().getResource("/resources/League.jpg")));
		fondo = new JPanel();
		fondo.setBackground(new Color(0, 0, 0, 0));
		fondo2.setLayout(new FlowLayout());
		fondo.setLayout(new GridLayout(2, 1));
		fondo.setPreferredSize(new Dimension(1000, 1000));
		
		tipos = baseDeDatos.obtenerTodosTipos();		
		movimientos = baseDeDatos.obtenerTodosMovimientos(tipos);
		pokemons = baseDeDatos.obtenerTodosPokemon(movimientos);
		entrenadores = baseDeDatos.obtenerTodosUsuarios(pokemons);

		setResizable(false);
		this.setSize(1000, 1000);
		this.setVisible(true);
		this.setTitle("Pokemon Showdown");
		this.setLayout(new BorderLayout());
		
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,3));
		panel2.setBackground(Color.BLACK);
		
		panel2a = new JPanel();
		panel2b = new JPanel(); 
		panel2c = new JPanel(); 
		panel2a.add(cerrarSesion);
		panel2b.add(revancha);
		panel2c.add(salir);
		panel2.add(panel2a);
		panel2.add(panel2b);
		panel2.add(panel2c);
		panel2a.setBackground(new Color(0, 0, 0, 0));
		panel2b.setBackground(new Color(0, 0, 0, 0));
		panel2c.setBackground(new Color(0, 0, 0, 0));
		
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,1));
		panel1.setBackground(new Color(0, 0, 0, 0));
		
		if(ganador.getUsuario().equals("RED")) {
			imagenENT = new ImageIcon(getClass().getResource("/resources/Red.png"));
			imagenENTB = imagenENT.getImage();
			newImagenENT = imagenENTB.getScaledInstance(160, 200, java.awt.Image.SCALE_SMOOTH);
			imagenENT = new ImageIcon(newImagenENT);
			
			imagenD = new ImageIcon(getClass().getResource("/resources/Defeat.png"));
			imagenD2 = imagenD.getImage();
			newImagenD = imagenD2.getScaledInstance(500, 300, java.awt.Image.SCALE_SMOOTH);
			imagenD = new ImageIcon(newImagenD);

			derrota = new JLabel((imagenD));
			derrota.setBackground(new Color(0, 0, 0, 0));
			panel1.add(derrota);
			
			}else if (eleccionAvatar.equals("Chico")) {
				imagenENT = new ImageIcon(getClass().getResource("/resources/" + eleccionAvatar + ".png"));
				imagenENTB = imagenENT.getImage();
				newImagenENT = imagenENTB.getScaledInstance(150, 180, java.awt.Image.SCALE_SMOOTH);
				imagenENT = new ImageIcon(newImagenENT);
				
				imagenV = new ImageIcon(getClass().getResource("/resources/Victory.png"));
				imagenV2 = imagenV.getImage();
				newImagenV = imagenV2.getScaledInstance(500, 300, java.awt.Image.SCALE_SMOOTH);
				imagenV = new ImageIcon(newImagenV);

				victoria = new JLabel((imagenV));
				victoria.setBackground(new Color(0, 0, 0, 0));
				panel1.add(victoria);
			} else if (eleccionAvatar.equals("Chica")) {
				imagenENT = new ImageIcon(getClass().getResource("/resources/" + eleccionAvatar + ".png"));
				imagenENTB = imagenENT.getImage();
				newImagenENT = imagenENTB.getScaledInstance(150, 180, java.awt.Image.SCALE_SMOOTH);
				imagenENT = new ImageIcon(newImagenENT);
				
				imagenV = new ImageIcon(getClass().getResource("/resources/Victory.png"));
				imagenV2 = imagenV.getImage();
				newImagenV = imagenV2.getScaledInstance(500, 300, java.awt.Image.SCALE_SMOOTH);
				imagenV = new ImageIcon(newImagenV);

				victoria = new JLabel((imagenV));
				victoria.setBackground(new Color(0, 0, 0, 0));
				panel1.add(victoria);
			} else if (eleccionAvatar.equals("Otros")) {
				imagenENT = new ImageIcon(getClass().getResource("/resources/" + "ApacheKawaii" + ".png"));
				imagenENTB = imagenENT.getImage();
				newImagenENT = imagenENTB.getScaledInstance(400, 300, java.awt.Image.SCALE_SMOOTH);
				imagenENT = new ImageIcon(newImagenENT);
				
				imagenV = new ImageIcon(getClass().getResource("/resources/Victory.png"));
				imagenV2 = imagenV.getImage();
				newImagenV = imagenV2.getScaledInstance(500, 300, java.awt.Image.SCALE_SMOOTH);
				imagenV = new ImageIcon(newImagenV);

				victoria = new JLabel((imagenV));
				victoria.setBackground(new Color(0, 0, 0, 0));
				panel1.add(victoria);
			}		
			entrenador = new JLabel((imagenENT));
			entrenador.setBackground(new Color(0, 0, 0, 0));
		
			imagenL = new ImageIcon(getClass().getResource("/resources/League.jpg"));
			imagenL2 = imagenL.getImage();
			newImagenL = imagenL2.getScaledInstance(1000, 1000, java.awt.Image.SCALE_SMOOTH);
			imagenL = new ImageIcon(newImagenL);
			
			
			panel1.add(entrenador);
			fondo.add(panel1);
			
			panel2.setBackground(new Color(0, 0, 0, 0));
			fondo.add(panel2);
			
			fondo2.add(fondo);
			this.add(fondo2);
			
		   mb=new JMenuBar();
	        setJMenuBar(mb);
	        menu1=new JMenu("Opciones");
	        mb.add(menu1);
	        mi1=new JMenuItem("Ver puntuaciones");
	        mi1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						leerFicheroRanking();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
	        menu1.add(mi1);
	        mi2=new JMenuItem("Guardar puntuación");
	        mi2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					crearFicheroRanking(entrenadores);
				}
			});
	        menu1.add(mi2); 

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
				VentanaInicio v = new VentanaInicio(entrenadorActual, eleccionAvatar, rojo);
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
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
		});

	}

	public void leerFicheroRanking() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		try(FileReader fileReader = new FileReader("scores.txt")) {
		    int ch = fileReader.read();
		    while(ch != -1) {
		        System.out.print((char)ch);
		        ch = fileReader.read();
		    }
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}

	}

	public void crearFicheroRanking(List<Entrenador> lista) {
		
		try(FileWriter fileWriter = new FileWriter("scores.txt")) {
		    
		    for(int i = 0; i < lista.size(); i++) {
		    	String fileContent = lista.get(i).getUsuario() + " " + lista.get(i).getScore() + "\n";
			    fileWriter.write(fileContent);
				}
				System.out.println("Puntuaciones guardadas con éxito");
		} catch (IOException e) {
		    // exception handling
		}
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador.setText(entrenador.getUsuario());
	}
	
	
}
