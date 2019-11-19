package interfaz;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class VentanaFinCombate extends JFrame {
	
	private JButton revancha;
	private JButton cerrarSesion;
	private JButton salir;

	public VentanaFinCombate(){
		this.setLayout(new FlowLayout());
		
		
		this.setSize(1100,1000);
		this.setVisible(true);
		this.setTitle("Pokemon Showdown");
	}
	
	
	public static void main(String[] args) {


	}
	

}
