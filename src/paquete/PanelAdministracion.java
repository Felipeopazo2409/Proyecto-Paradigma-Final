package paquete;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelAdministracion extends JPanel{
	private JLabel titulo,icon;
	public JButton ingresar,eliminar,mostrarInformacion,volver_menu;
	public PanelAdministracion() {
		setLayout(null);
		setBackground(Color.orange);
		setVisible(true);
		CargarComponentesLabel();
		CargarBotones();
	}
	private void CargarComponentesLabel() {
		titulo = new JLabel("Administrador de departamentos");
		titulo.setBounds(250,80,360,40);
		titulo.setFont(new Font("Helvetica",Font.PLAIN,23));
		
		icon = new JLabel(new ImageIcon("logo.png"));
		icon.setBounds(0,0,150,150);
		add(titulo);
		add(icon);
	}
	private void CargarBotones() {
		ingresar = new JButton("Agregar Departamento");
		ingresar.setBounds(280,170,250,25);
		ingresar.setFont(new Font("Helvetica",Font.PLAIN,18));
				
		eliminar = new JButton("Eliminar Departamento");
		eliminar.setBounds(280,220,250,25);
		eliminar.setFont(new Font("Helvetica",Font.PLAIN,18));
		
		mostrarInformacion = new JButton("Mostrar Informacion");
		mostrarInformacion.setBounds(280,270,250,25);
		mostrarInformacion.setFont(new Font("Helvetica",Font.PLAIN,18));
		
		volver_menu = new JButton("Volver al menu principal");
		volver_menu.setBounds(280,320,250,25);
		volver_menu.setFont(new Font("Helvetica",Font.PLAIN,18));
		add(ingresar);
		add(eliminar);
		add(mostrarInformacion);
		add(volver_menu);
	}
	
}
