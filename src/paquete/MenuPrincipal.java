package paquete;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPrincipal extends JPanel {
	private JLabel titulo,descripcion,icono;
	public JButton boton1,boton2,boton3,boton4;
	public MenuPrincipal() {
		setLayout(null);
		setBackground(Color.orange);
		cargarComponentesLabel();
		cargarBotones();
	}
	
	private void cargarComponentesLabel() {
		//Creamos los diferentes labels para agregar textos en los panels
		titulo = new JLabel("Menú Principal");
		titulo.setBounds(300,70,200,40);
		titulo.setFont(new Font("Helvetica",Font.PLAIN,27));
		
		descripcion = new JLabel("''Bienvenido al software de la Choza de concreto''");
		descripcion.setBounds(200,150,450,40);
		descripcion.setFont(new Font("Helvetica",Font.BOLD,18));
		
		icono = new JLabel(new ImageIcon("logo.png"));
		icono.setBounds(5,0,150,150);
		add(titulo);
		add(descripcion);
		add(icono);
	}
	private void cargarBotones() {
		//Creamos los botones del panel
		boton1 = new JButton("Administrador de departamentos");
		boton1.setBounds(240,220,350,30);
		boton1.setFont(new Font("Helvetica",Font.PLAIN,18));
		
		boton2 = new JButton("Administrador de trabajadores");
		boton2.setBounds(240,260,350,30);
		boton2.setFont(new Font("Helvetica",Font.PLAIN,18));
		
		boton3 = new JButton("Información general de la empresa");
		boton3.setBounds(240,300,350,30);
		boton3.setFont(new Font("Helvetica",Font.PLAIN,18));
		
		boton4 = new JButton("Finalizar Programa");
		boton4.setBounds(240,340,350,30);
		boton4.setFont(new Font("Helvetica",Font.PLAIN,18));
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
	}

}
