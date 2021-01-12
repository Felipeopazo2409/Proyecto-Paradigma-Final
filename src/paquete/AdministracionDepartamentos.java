package paquete;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AdministracionDepartamentos extends JPanel implements ActionListener{
	private JLabel titulo,icon;
	public JButton ingresar,eliminar,mostrarInformacion;
	private JScrollPane scrollpane;
	public AdministracionDepartamentos() {
		setLayout(null);
		setBackground(Color.orange);
		CargarComponentesLabel();
		CargarBotones();
		cargarOtrosComponentes();
	}
	private void CargarComponentesLabel() {
		titulo = new JLabel("Administrador de departamentos");
		titulo.setBounds(250,80,360,40);
		titulo.setFont(new Font("serif",Font.PLAIN,23));
		
		icon = new JLabel(new ImageIcon("logo.png"));
		icon.setBounds(0,0,150,150);
		
		add(titulo);
		add(icon);
	}
	private void CargarBotones() {
		ingresar = new JButton("Añadir Departamento");
		ingresar.setBounds(280,170,250,25);
		
		eliminar = new JButton("Eliminar Departamento");
		eliminar.setBounds(280,220,250,25);
		
		mostrarInformacion = new JButton("Mostrar Información");
		mostrarInformacion.setBounds(280,270,250,25);
		
		add(ingresar);
		add(eliminar);
		add(mostrarInformacion);
	}
	public void actionPerformed(ActionEvent e) {
		
	}
	public void cargarOtrosComponentes() {
		scrollpane = new JScrollPane();
		scrollpane.setBounds(1,1,779,500);
		scrollpane.setBackground(Color.orange);
		//add(scrollpane);
	
	}
	
}

