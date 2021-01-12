package paquete;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelMostrarDepto extends JPanel{
	private JLabel titulo;
	public JButton volver_menu,mostrar_lista;
	public JTable tabla;
	public PanelMostrarDepto() {
		setLayout(null);
		setBackground(Color.orange);
		labels();
		botones();
		
		DefaultTableModel modelo = new DefaultTableModel();
		tabla = new JTable(modelo);
		tabla.setBounds(5,80,550,350);

	    add(tabla);
	}
	private void labels() {
		titulo = new JLabel("Mostrar Informacion de los departamentos");
		titulo.setBounds(180,20,450,40);
		titulo.setFont(new Font("Helvetica",Font.PLAIN,22));
	
	
		
		add(titulo);
		
	}
	private void botones() {
		mostrar_lista = new JButton("Mostrar Lista \nde departamentos");
		mostrar_lista.setBounds(560,160,200,100);
		mostrar_lista.setFont(new Font("Helvetica",Font.PLAIN,11));
		volver_menu = new JButton("Volver al menu Principal");
		volver_menu.setBounds(560,280,200,100);
		volver_menu.setFont(new Font("Helvetica",Font.PLAIN,11));
		
		add(volver_menu);
		add(mostrar_lista);
		
	}
}
