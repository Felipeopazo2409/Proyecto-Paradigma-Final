package paquete;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInsertarDepto extends JPanel {
	private JLabel titulo, n_depto, nombre, numero, trabajadores, icon, mensaje;
	public JTextField campo1, campo2, campo3, campo4;
	public JButton volver_menu, guardar;

	public PanelInsertarDepto() {
		setLayout(null);
		setBackground(Color.orange);
		cargarComponentesLabel();
		cargarComponentesText();
		cargarComponentesButton();
	}

	private void cargarComponentesLabel() {
		titulo = new JLabel("Inserte datos del departamento nuevo");
		titulo.setBounds(230, 100, 450, 40);
		titulo.setFont(new Font("Helvetica", Font.BOLD, 22));

		icon = new JLabel(new ImageIcon("logo.png"));
		icon.setBounds(0, 0, 150, 150);

		n_depto = new JLabel("N Depto");
		n_depto.setBounds(190, 150, 150, 40);
		n_depto.setFont(new Font("Helvetica", Font.PLAIN, 16));

		nombre = new JLabel("Nombre");
		nombre.setBounds(190, 200, 150, 40);
		nombre.setFont(new Font("Helvetica", Font.PLAIN, 16));

		numero = new JLabel("Numero de trabajadores");
		numero.setBounds(190, 250, 250, 40);
		numero.setFont(new Font("Helvetica", Font.PLAIN, 16));

		mensaje = new JLabel("Se ha guardado la información exitosamente");
		mensaje.setBounds(220, 10, 400, 40);
		mensaje.setFont(new Font("Helvetica", Font.PLAIN, 16));
		add(titulo);
		add(icon);
		add(n_depto);
		add(nombre);
		add(numero);
	}

	private void cargarComponentesText() {
		campo1 = new JTextField();
		campo1.setBounds(390, 160, 200, 25);

		campo2 = new JTextField();
		campo2.setBounds(390, 208, 200, 25);

		campo3 = new JTextField();
		campo3.setBounds(390, 260, 200, 25);
		add(campo1);
		add(campo2);
		add(campo3);
	}

	private void cargarComponentesButton() {
		volver_menu = new JButton("Menú Principal");
		volver_menu.setBounds(240, 375, 280, 35);
		volver_menu.setFont(new Font("Helvetica", Font.PLAIN, 18));
		guardar = new JButton("Guardar Informacion");
		guardar.setBounds(240, 320, 280, 35);
		guardar.setFont(new Font("Helvetica", Font.PLAIN, 18));

		add(volver_menu);
		add(guardar);

	}

}
