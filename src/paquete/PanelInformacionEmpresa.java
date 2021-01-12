package paquete;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelInformacionEmpresa extends JPanel {
		private JLabel titulo,cantidadTrabajadores,cantidadDeptos,icon;
		public JButton boton;
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
				
				cantidadDeptos = new JLabel("Cantidad de Departamentos:3");
				cantidadDeptos.setBounds(280,150,300,40);
				cantidadDeptos.setFont(new Font("Helvetica",Font.PLAIN,22));
				cantidadDeptos.setHorizontalAlignment(SwingConstants.CENTER);
				
				cantidadTrabajadores = new JLabel("Cantidades de Trabajadores: ");
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
			 boton.setBounds(280,300,250,25);
			 add(boton);
		 }
}
