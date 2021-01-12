package paquete;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelValidarTrabajador extends JPanel{
	
	public PanelTrabajador panel;
	public JButton buscar;
	public JLabel ingresoRut;
	public JTextField buscarTrabajador;
	
	public PanelValidarTrabajador() {
		panel = new PanelTrabajador();
		setLayout(null); 
		setBackground(Color.orange);
		JLabel logo = new JLabel(new ImageIcon("logo.png"));
		logo.setBounds(0,0,150,150);
		add(logo);
		cargarCampo();
		CargarBotones();
		cargarComponentesLabel();
		
	}
	
	 public void CargarBotones() {
		 buscar = new JButton ("Buscar trabajador");
		 buscar.setBounds(240,300,300,60);
		 buscar.setFont(new Font("Helvetica",Font.PLAIN,18));
		 add(buscar);
	 }
	
	 public void cargarComponentesLabel() {
		 ingresoRut = new JLabel("Ingrese rut:");
		 ingresoRut.setBounds(230,170,300,40);
		 ingresoRut.setFont(new Font("Helvetica",Font.PLAIN,22));
		 add(ingresoRut);
		 
	 }
	 
	 public void cargarCampo() {
		 buscarTrabajador = new JTextField();
		 buscarTrabajador.setBounds(240, 220, 100, 30);
		 add(buscarTrabajador);
	 }
	
	
	 
}
