package paquete;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelEliminarTrabajador extends JPanel {
	private JLabel titulo, icono, titulo2;
	private JLabel nombre, apellidoP, apellidoM, rut, fecha_nacimiento, tipo_contrato, salario, departamento;
	public JTextArea campoNombre, campoApellidoMaterno, campoApellidoPaterno, campoNacimiento, campo_contrato,
			camposalario, campodepartamento;
	public JButton eliminar, cancelar, buscar;
	public JTextField campo_rut;

	public PanelEliminarTrabajador() {
		setLayout(null);
		setBackground(Color.orange);
		labels(); // Configuro los textos en el panel
		textarea(); // Configuro los campos de texto
		textfield();// Configuro los campos de texto
		botones();// configuro los botones
	}

	private void labels() {
		titulo = new JLabel("Eliminación de trabajadores");
		titulo.setBounds(240, 20, 420, 40);
		titulo.setFont(new Font("Helvetica", Font.PLAIN, 25));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);

		titulo2 = new JLabel("Ingrese el rut para rellenar los campos automaticamente.");
		titulo2.setBounds(240, 40, 420, 40);
		titulo2.setFont(new Font("Helvetica", Font.PLAIN, 16));
		titulo2.setHorizontalAlignment(SwingConstants.CENTER);

		rut = new JLabel("Ingresar Rut");
		rut.setBounds(50, 80, 200, 40);
		rut.setFont(new Font("Helvetica", Font.PLAIN, 20));

		nombre = new JLabel("Nombre");
		nombre.setBounds(50, 190, 100, 40);
		nombre.setFont(new Font("Helvetica", Font.PLAIN, 20));

		apellidoP = new JLabel("Apellido Paterno ");
		apellidoP.setBounds(50, 220, 150, 40);
		apellidoP.setFont(new Font("Helvetica", Font.PLAIN, 20));

		apellidoM = new JLabel("Apellido Materno ");
		apellidoM.setBounds(50, 250, 180, 40);
		apellidoM.setFont(new Font("Helvetica", Font.PLAIN, 20));

		fecha_nacimiento = new JLabel("Fecha de nacimiento ");
		fecha_nacimiento.setBounds(50, 280, 300, 40);
		fecha_nacimiento.setFont(new Font("Helvetica", Font.PLAIN, 20));

		tipo_contrato = new JLabel("Tipo de contrato ");
		tipo_contrato.setBounds(50, 310, 300, 40);
		tipo_contrato.setFont(new Font("Helvetica", Font.PLAIN, 20));

		salario = new JLabel("Salario por hora ");
		salario.setBounds(50, 340, 300, 40);
		salario.setFont(new Font("Helvetica", Font.PLAIN, 20));

		departamento = new JLabel("Departamento ");
		departamento.setBounds(50, 370, 300, 40);
		departamento.setFont(new Font("Helvetica", Font.PLAIN, 20));

		icono = new JLabel(new ImageIcon("logo.png"));
		icono.setBounds(1, 1, 150, 150);
		add(titulo);
		add(titulo2);
		add(nombre);
		add(apellidoP);
		add(apellidoM);
		add(rut);
		add(fecha_nacimiento);
		add(tipo_contrato);
		add(salario);

		add(departamento);
	}

	private void textarea() {

		campoNombre = new JTextArea();
		campoNombre.setBounds(235, 200, 180, 20);

		campoApellidoPaterno = new JTextArea();
		campoApellidoPaterno.setBounds(235, 230, 180, 20);

		campoApellidoMaterno = new JTextArea();
		campoApellidoMaterno.setBounds(235, 260, 180, 20);

		campoNacimiento = new JTextArea();
		campoNacimiento.setBounds(235, 290, 180, 20);

		campo_contrato = new JTextArea();
		campo_contrato.setBounds(235, 320, 180, 20);

		camposalario = new JTextArea();
		camposalario.setBounds(235, 350, 180, 20);

		campodepartamento = new JTextArea();
		campodepartamento.setBounds(235, 380, 180, 20);

		add(campoNombre);
		add(campoApellidoPaterno);
		add(campoApellidoMaterno);
		add(campoNacimiento);
		add(campo_contrato);
		add(camposalario);
		add(campodepartamento);
	}

	private void textfield() {
		campo_rut = new JTextField();
		campo_rut.setBounds(235, 90, 180, 20);
		add(campo_rut);
	}

	private void botones() {

		buscar = new JButton("Buscar Trabajador");
		buscar.setBounds(190, 120, 250, 30);
		buscar.setFont(new Font("Helvetica", Font.PLAIN, 18));

		cancelar = new JButton("Cancelar");
		cancelar.setBounds(470, 250, 250, 30);
		cancelar.setFont(new Font("Helvetica", Font.PLAIN, 18));

		eliminar = new JButton("Eliminar Trabajador");
		eliminar.setBounds(470, 300, 250, 30);
		eliminar.setFont(new Font("Helvetica", Font.PLAIN, 18));

		add(buscar);
		add(eliminar);
		add(cancelar);
	
	}
}
