package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import javax.swing.JTextField;

import clases.Entrenador;

public class VentanaFinCombate extends JFrame {

	private JButton revancha;
	private JButton cerrarSesion;
	private JButton salir;
	private JLabel entrenador;
	private JLabel ganadas;
	private JMenuBar menuBar;
	private JMenu exportar;
	private Entrenador entrenadorActual;

	public VentanaFinCombate(){
		this.setLayout(new FlowLayout());
		
		menuBar = new JMenuBar();
		//entrenadorActual = entrenador;
		salir = new JButton("Salir");
		revancha = new JButton("Rematch");
		cerrarSesion = new JButton("Log Out");
		
		//entrenador = new JLabel(setEntrenador(entrenador););
		
		
		
		this.setSize(1100,1000);
		this.setVisible(true);
		this.setTitle("Pokemon Showdown");
	}
	public void leerFicheroRanking() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File ("C:\\Documents\\Ranking.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			
			// Lectura del fichero
			String linea;
			while((linea=br.readLine())!=null) {
				entrenador.setText("hola");
				System.out.println(linea);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta 
			// una excepcion.
			try{                    
				if( null != fr ){   
					fr.close();     
				}                  
			}catch (Exception e2){ 
				e2.printStackTrace();
			}
		}

	}
	public void crearFicheroRanking(List<Entrenador> lista) {
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("c:\\Documents\\Ranking.txt");
            pw = new PrintWriter(fichero);

            	for(Entrenador e : lista) {
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
		VentanaFinCombate v = new VentanaFinCombate();
		
	}
	public JLabel getEntrenador() {
		return entrenador;
	}
	public void setEntrenador(Entrenador entrenador) {
		this.entrenador.setText(entrenador.getUsuario());
	}
	

}
