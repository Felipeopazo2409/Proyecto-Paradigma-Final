
package paquete;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelEliminarDepto extends JPanel{
	private JLabel titulo,icon,nombre,ingresar_n_depto,numero_trabajadores;
	public JTextField input;
	public JTextArea campo1,campo2;
	public JButton eliminar_depto,cancelar,buscar;
	public PanelEliminarDepto() {
		setLayout(null);
		setBackground(Color.orange);
		labels();
		textfield();
		textarea();
		botones();
	}
	private void labels() {
		titulo = new JLabel("Eliminar Departamento");
		titulo.setBounds(280,80,400,40);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Helvetica",Font.BOLD,25));
	
		icon = new JLabel(new ImageIcon("logo.png"));
		icon.setBounds(0,0,150,150);
		
		ingresar_n_depto = new JLabel("Ingrese Numero de Depto");
		ingresar_n_depto.setBounds(190,150,250,40);
		ingresar_n_depto.setFont(new Font("Helvetica",Font.PLAIN,16));
		
		nombre = new JLabel("Nombre");
		nombre.setBounds(190,180,150,40);
		nombre.setFont(new Font("Helvetica",Font.PLAIN,16));
		
		numero_trabajadores = new JLabel("Numero de trabajadores");
		numero_trabajadores.setBounds(190,210,250,40);
		numero_trabajadores.setFont(new Font("Helvetica",Font.PLAIN,16));
		
		
		add(titulo);
		add(icon);
		add(ingresar_n_depto);
		add(nombre);
		add(numero_trabajadores);
	}
	private void textarea() {
		campo1 = new JTextArea();
		campo1.setBounds(380,190,200,25);
		
		campo2 = new JTextArea();
		campo2.setBounds(380,220,200,25);
		
		add(campo1);
		add(campo2);
	}
	private void textfield() {
		input = new JTextField();
		input.setBounds(380,160,200,25);
		add(input);
	}
	private void botones() {
		buscar = new JButton("Buscar Departamento");
		buscar.setBounds(250,300,330,30);
		buscar.setFont(new Font("Helvetica",Font.PLAIN,18));
		
		
		eliminar_depto = new JButton("Eliminar");
		eliminar_depto.setBounds(70,380,330,30);
		eliminar_depto.setFont(new Font("Helvetica",Font.PLAIN,18));
		
		cancelar = new JButton("Cancelar");
		cancelar.setBounds(420,380,330,30);
		cancelar.setFont(new Font("Helvetica",Font.PLAIN,18));
		add(eliminar_depto);
		add(cancelar);
		add(buscar);
	}
}
