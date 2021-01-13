package paquete;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelInformacionEmpresa extends JPanel {
		public JLabel titulo,cantidadTrabajadores,cantidadDeptos,icon;
		public JButton boton;
		int contador_trabajadores = 0;
		int contador_deptos = 0;
		public PanelInformacionEmpresa() {
			setLayout(null);
			setBackground(Color.orange);
			cargarComponentesLabel();
			cargarBoton();
		}
		 public void cargarComponentesLabel() {
				titulo = new JLabel("Informacion General Empresa");
				titulo.setBounds(220,80,400,40);
				titulo.setFont(new Font("Helvetica",Font.PLAIN,28));
				titulo.setHorizontalAlignment(SwingConstants.CENTER);
				
				cantidadDeptos = new JLabel("Cantidad de Departamentos: "+contador_deptos);
				cantidadDeptos.setBounds(280,150,300,40);
				cantidadDeptos.setFont(new Font("Helvetica",Font.PLAIN,22));
				cantidadDeptos.setHorizontalAlignment(SwingConstants.CENTER);
				
				cantidadTrabajadores = new JLabel("Cantidad de Trabajadores: "+contador_trabajadores);
				cantidadTrabajadores.setBounds(280,220,300,40);
				cantidadTrabajadores.setFont(new Font("Helvetica",Font.PLAIN,22));
				cantidadTrabajadores.setHorizontalAlignment(SwingConstants.CENTER);
				
				icon = new JLabel(new ImageIcon("logo.png"));
				icon.setBounds(0,0,150,150);
				add(titulo);
				add(cantidadDeptos);
				add(cantidadTrabajadores);
				add(icon);
			 }
		 
		 private void cargarBoton() {
			 boton = new JButton("Volver al menu Principal");
			 boton.setBounds(280,300,270,40);
			 add(boton);
		 }
}
