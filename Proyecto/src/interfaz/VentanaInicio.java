package interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class VentanaInicio extends JFrame implements ActionListener {

	private JPanel fondo;
	private JLabel fondo2;
	private JPanel hueco1;
	private JPanel hueco2;
	private JPanel hueco3;
	private JPanel hueco4;
	//private JPanel hueco5;
	private JPanel hueco6;
	private JPanel hueco7;
	private JPanel hueco8;
	//private JPanel hueco9;
	private JPanel PanelEntrenador1;
	private JPanel PanelEntrenador2;
	private JPanel Equipo1;
	private JLabel Equipo2;
	private JLabel entrenador1;
	private JLabel entrenador2;
	private JLabel nombre1;
	private JLabel nombre2;
	private JLabel continuar;
	private JPanel PanelContinuar;
	private JLabel versus;
	private ImageIcon ImagenVS;
	private Image NewImageVS;
	private Image ImageVS2;
	private ImageIcon ImagenENT1;
	private Image NewImageENT1;
	private Image ImageENT1B;
	private ImageIcon ImagenENT2;
	private Image NewImageENT2;
	private Image ImageENT2B;
	private ImageIcon ImagenPOK2;
	private Image NewImagePOK2;
	private Image ImagePOK2;
	private JLabel Pokemon1;
	private ImageIcon ImagenPOK1;
	private Image NewImagePOK1;
	private Image ImagePOK1B;
	private JLabel Pokemon2;
	private JLabel Pokemon3;
	private JLabel Pokemon4;
	private JLabel Pokemon5;
	private JLabel Pokemon6;
	private ImageIcon img1;
	private Image img2;
	private Image img3;
	private ImageIcon a;

	public VentanaInicio() {

		this.setLayout(new FlowLayout());
		fondo2 = new JLabel(new ImageIcon(getClass().getResource("/resources/InicioCombate.png")));
		fondo = new JPanel();
		fondo.setBackground(new Color(0, 0, 0, 0));
		fondo2.setLayout(new FlowLayout());
		fondo.setLayout(new GridLayout(4, 3));
		fondo.setPreferredSize(new Dimension(1000, 800));

		nombre1 = new JLabel();
		nombre1.setText("TRAINER1");
		nombre1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		PanelEntrenador1 = new JPanel(new FlowLayout(FlowLayout.CENTER,20,85) );
		
		//PanelEntrenador1.setLayout(new GridLayout(1, 3));
		//hueco5 = new JPanel();
		//PanelEntrenador1.add(hueco5);
		//hueco5.setVisible(false);
		PanelEntrenador1.add(nombre1);
		PanelEntrenador1.setBackground(new Color(0, 0, 0, 0));
		
		//hueco9 = new JPanel();
		//PanelEntrenador1.add(hueco9);
		//hueco9.setVisible(false);
		fondo.add(PanelEntrenador1);
		
		hueco1 = new JPanel();
		hueco1.setOpaque(false);
		fondo.add(hueco1);

		nombre2 = new JLabel();
		nombre2.setText("RED");
		nombre2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		PanelEntrenador2 = new JPanel();
		PanelEntrenador2.setLayout(new GridLayout(1, 3));
		hueco6 = new JPanel();
		PanelEntrenador2.add(hueco6);
		hueco6.setVisible(false);
		PanelEntrenador2.add(nombre2);
		hueco8 = new JPanel();
		PanelEntrenador2.add(hueco8);
		hueco8.setVisible(false);
		PanelEntrenador2.setBackground(new Color(0, 0, 0, 0));
		fondo.add(PanelEntrenador2);
		
		ImagenENT1 = new ImageIcon(getClass().getResource("/resources/ApacheKawaii.png"));
		ImageENT1B = ImagenENT1.getImage();
		NewImageENT1 = ImageENT1B.getScaledInstance(300, 180, java.awt.Image.SCALE_SMOOTH); 
		ImagenENT1 = new ImageIcon(NewImageENT1); 
		//Pillar imagen H v M v O
		entrenador1 = new JLabel((ImagenENT1));
		entrenador1.setBackground(new Color(0, 0, 0, 0));
		entrenador1.setLayout(new FlowLayout());
		fondo.add(entrenador1);

		//entrenador1 = new JLabel(new ImageIcon("C:\\Users\\34619\\Desktop\\Uni\\Programacion\\ImagenesProyecto\\ApacheKawaii.png"));
		//fondo.add(entrenador1);

		ImagenVS = new ImageIcon(getClass().getResource("/resources/Vs.png"));
		ImageVS2 = ImagenVS.getImage();
		NewImageVS = ImageVS2.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH); 
		ImagenVS = new ImageIcon(NewImageVS); 

		versus = new JLabel((ImagenVS));
		versus.setBackground(new Color(0, 0, 0, 0));
		versus.setLayout(new FlowLayout());
		fondo.add(versus);
		
		ImagenENT2 = new ImageIcon(getClass().getResource("/resources/Red.png"));
		//ImagenENT2 = new ImageIcon(VentanaInicio.class.getResource("img/Red.png"));
		//ImagenENT2 = new ImageIcon("C:\\Users\\34619\\Desktop\\Uni\\Programacion\\ImagenesProyecto\\Red.png");
		ImageENT2B = ImagenENT2.getImage();
		NewImageENT2 = ImageENT2B.getScaledInstance(150, 175, java.awt.Image.SCALE_SMOOTH); 
		ImagenENT2 = new ImageIcon(NewImageENT2); 
		entrenador2 = new JLabel((ImagenENT2));
		entrenador2.setBackground(new Color(0, 0, 0, 0));
		fondo.add(entrenador2);
		
		//entrenador2 = new JLabel(new ImageIcon("C:\\Users\\34619\\Desktop\\Uni\\Programacion\\ImagenesProyecto\\Red.png"));
		//fondo.add(entrenador2);

		
		Equipo1 = new JPanel();
		Equipo1.setLayout(new GridLayout(2,3));
		//Equipo1.setBackground(new Color(0, 0, 0, 0));
		//ImagenPOK1 = new ImageIcon(getClass().getResource("/resources/ArceusSprite.png"));
		//ImagePOK1B = ImagenPOK1.getImage();
		//NewImagePOK1 = ImagePOK1B.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH); 
		//ImagenPOK1 = new ImageIcon(NewImagePOK1);
		a = ajustarSprite("Arceus");
		Pokemon1 = new JLabel(a);
		Equipo1.add(Pokemon1);
		Pokemon2 = new JLabel();
		Equipo1.add(Pokemon2);
		Pokemon3 = new JLabel();
		Equipo1.add(Pokemon3);
		Pokemon4 = new JLabel();
		Equipo1.add(Pokemon4);
		Pokemon5 = new JLabel();
		Equipo1.add(Pokemon5);
		Pokemon6 = new JLabel();
		Equipo1.add(Pokemon6);
		fondo.add(Equipo1);

		hueco2 = new JPanel();
		fondo.add(hueco2);
		hueco2.setVisible(false);
		
		ImagenPOK2 = new ImageIcon(getClass().getResource("/resources/EnemyTeam.png"));
		ImagePOK2 = ImagenPOK2.getImage();
		NewImagePOK2 = ImagePOK2.getScaledInstance(300, 175, java.awt.Image.SCALE_SMOOTH); 
		ImagenPOK2 = new ImageIcon(NewImagePOK2); 
		
		Equipo2 = new JLabel((ImagenPOK2));
		Equipo2.setBackground(new Color(0, 0, 0, 0));
		Equipo2.setLayout(new FlowLayout());
		fondo.add(Equipo2);
		
		//pokemon2 = new JPanel();
		//pokemon2.setBackground(Color.GREEN);
		//fondo.add(pokemon2);

		hueco3 = new JPanel();
		fondo.add(hueco3);
		hueco3.setVisible(false);

		PanelContinuar = new JPanel();
		hueco7 = new JPanel();
		hueco7.setVisible(false);
		continuar = new JLabel("TOCA PARA CONTINUAR");
		continuar.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		PanelContinuar.add(hueco7);
		PanelContinuar.add(continuar);
		PanelContinuar.setBackground(new Color(0, 0, 0, 0));
		fondo.add(PanelContinuar);

		hueco4 = new JPanel();
		fondo.add(hueco4);
		hueco4.setVisible(false);

		// Al hacer click pasar a VentanaCombate
		fondo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				System.exit(0);
			}
		});

		fondo2.add(fondo);
		this.add(fondo2);
		this.setSize(1100, 900);
		this.setVisible(true);
		this.setTitle("Pokemon Showdown");

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public  ImageIcon ajustarSprite(String img) {

		ImageIcon imageIcon = new ImageIcon(getClass().getResource("/resources/"+img.toLowerCase()+"Sprite.png")); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(80, 80,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		return imageIcon;
}
	
	public static void main(String[] args) {
		VentanaInicio a = new VentanaInicio();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
