package paquete;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JPanel {
	private JLabel titulo;
	private JLabel integrantes;
	private JLabel icono;
	private JButton boton;
	private boolean presionado;
	public Home() {
		setLayout(null);
		presionado = false;
		setBackground(Color.orange);
		configurarLabels();
		configurarBoton();
		add(titulo);
		add(icono);
		add(integrantes);
		add(boton);
	}
	private void configurarLabels() {
		//Titulo
		titulo = new JLabel("Proyecto Paradigmas de la programación (2020)");
		titulo.setBounds(200,130,350,50);
		titulo.setFont(new Font("serif",Font.PLAIN,18));
		titulo.setAlignmentX(CENTER_ALIGNMENT);
		titulo.setAlignmentY(CENTER_ALIGNMENT);
		//Insertar Insignia Universidad
		icono = new JLabel(new ImageIcon("insigniaubb.png"));
		icono.setBounds(10,10,140,85);
		//Nombre de los integrantes
		integrantes = new JLabel("Integrantes: Delnovio Alarcón - Felipe Opazo - Vicente Matus");
		integrantes.setBounds(165,170,450,60);
		integrantes.setFont(new Font("serif",Font.BOLD,16));
	}
	private void configurarBoton() {
		boton = new JButton("Pincha aquí para ingresar al programa");
		boton.setBounds(140,240,500,30);
		//Aquí creamos el evento para el boton
		
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("has dado click en el boton");
			}
		});
		
	}
	
	public boolean getPress() {
		return presionado;
	}
	
	
}
