package paquete;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.json.JSONArray;

public class PanelTrabajador extends JPanel {
	 private JLabel titulo,icon;
	 public JButton ingresar,modificar,eliminar,volver_menu,consultar_datos,generar_liquidacion;
	 public VentanaTrabajador ventana_trabajadores;
	 public VentanaInformacion ventana_informacion_general;
	 
	 
	 public PanelTrabajador() {
		 setLayout(null);
		 setBackground(Color.orange);
		
		 cargarComponentesLabel();
		 CargarBotones();
		 
	 }
	 public void cargarComponentesLabel() {
		titulo = new JLabel("Administración de trabajadores");
		titulo.setBounds(280,50,300,40);
		titulo.setFont(new Font("Helvetica",Font.PLAIN,22));
		
		icon = new JLabel(new ImageIcon("logo.png"));
		icon.setBounds(0,0,150,150);
		add(titulo);
		add(icon);
	 }
	 private void CargarBotones() {
			ingresar = new JButton("Añadir Trabajador");
			ingresar.setBounds(280,130,300,25);
			ingresar.setFont(new Font("Helvetica",Font.PLAIN,18));
			
			modificar = new JButton("Modificar Trabajador");
			modificar.setBounds(280,170,300,25);
			modificar.setFont(new Font("Helvetica",Font.PLAIN,18));
			
			eliminar = new JButton("Eliminar Trabajador");
			eliminar.setBounds(280,210,300,25);
			eliminar.setFont(new Font("Helvetica",Font.PLAIN,18));
			
			consultar_datos = new JButton("Consultar Datos de trabajadores");
			consultar_datos.setBounds(280,250,300,25);
			consultar_datos.setFont(new Font("Helvetica",Font.PLAIN,18));
			
			generar_liquidacion = new JButton("Generar Liquidación de sueldo");
			generar_liquidacion.setBounds(280,290,300,25);
			generar_liquidacion.setFont(new Font("Helvetica",Font.PLAIN,18));
			
			volver_menu = new JButton("Volver al menú principal");
			volver_menu.setBounds(280,330,300,25);
			volver_menu.setFont(new Font("Helvetica",Font.PLAIN,18));
			add(ingresar);
			add(eliminar);
			add(modificar);
			add(consultar_datos);
			add(generar_liquidacion);
			add(volver_menu);
		}
}
