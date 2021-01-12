package paquete;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelModificarTrabajador extends JPanel {
	private JLabel titulo, icono;
	private JLabel nombre, apellidoP, apellidoM, rut, fecha_nacimiento, tipo_contrato, salario, departamento;
	public JTextField campoNombre, campoApellidoMaterno, campoApellidoPaterno, campoRut, campoNacimiento, campoSalario,
			campoDepartamento,campo_contrato;
	public JButton guardar, cancelar, buscar;
	private String[] contratos = { "Full-time", "Part-Time" };
	public static int cantidadTrabajadores;

	public PanelModificarTrabajador() {
		setLayout(null);
		setBackground(Color.orange);

		labels();
		campos();
		botones();
	}

	private void labels() {
		titulo = new JLabel("Modificar Datos de Trabajador");
		titulo.setBounds(240, 50, 420, 40);
		titulo.setFont(new Font("serif", Font.PLAIN, 25));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);

		rut = new JLabel("Ingrese Rut");
		rut.setBounds(150, 140, 270, 40);
		rut.setFont(new Font("serif", Font.PLAIN, 20));

		nombre = new JLabel("Nombre");
		nombre.setBounds(50, 190, 100, 40);
		nombre.setFont(new Font("serif", Font.PLAIN, 20));

		apellidoP = new JLabel("Apellido Paterno ");
		apellidoP.setBounds(50, 220, 150, 40);
		apellidoP.setFont(new Font("serif", Font.PLAIN, 20));

		apellidoM = new JLabel("Apellido Materno ");

		apellidoM.setBounds(50, 250, 150, 40);
		apellidoM.setFont(new Font("serif", Font.PLAIN, 20));

		departamento = new JLabel();
		departamento.setBounds(50, 340, 300, 40);
		departamento.setFont(new Font("serif", Font.PLAIN, 20));

		fecha_nacimiento = new JLabel("Fecha de nacimiento ");
		fecha_nacimiento.setBounds(50, 280, 300, 40);
		fecha_nacimiento.setFont(new Font("serif", Font.PLAIN, 20));

		tipo_contrato = new JLabel("Tipo de contrato ");
		tipo_contrato.setBounds(50, 310, 300, 40);
		tipo_contrato.setFont(new Font("serif", Font.PLAIN, 20));


		salario = new JLabel("Salario por hora ");
		salario.setBounds(50, 340, 300, 40);
		salario.setFont(new Font("serif", Font.PLAIN, 20));

		departamento = new JLabel("Departamento ");
		departamento.setBounds(50, 370, 300, 40);
		departamento.setFont(new Font("serif", Font.PLAIN, 20));

		icono = new JLabel(new ImageIcon("logo.png"));
		icono.setBounds(1, 1, 150, 150);
		add(titulo);
		add(nombre);
		add(apellidoP);
		add(apellidoM);
		add(rut);
		add(fecha_nacimiento);
		add(tipo_contrato);
		add(salario);
		add(icono);
		add(departamento);

	}

	private void campos() {

		campoRut = new JTextField();
		campoRut.setBounds(250, 155, 150, 20);

		campoNombre = new JTextField();
		campoNombre.setBounds(240, 200, 150, 20);

		campoApellidoMaterno = new JTextField();
		campoApellidoMaterno.setBounds(240, 230, 150, 20);

		campoApellidoPaterno = new JTextField();
		campoApellidoPaterno.setBounds(240, 260, 150, 20);

		campoNacimiento = new JTextField();
		campoNacimiento.setBounds(240, 290, 150, 20);

		campoSalario = new JTextField();
		campoSalario.setBounds(240, 350, 150, 20);
		
		campo_contrato = new JTextField();
		campo_contrato.setBounds(240,320,150,20);
		
		campoDepartamento = new JTextField();
		campoDepartamento.setBounds(240, 380, 150, 20);

		add(campoNombre);
		add(campoApellidoMaterno);
		add(campoApellidoPaterno);
		add(campoRut);
		add(campoNacimiento);
		add(campoSalario);
		add(campoDepartamento);
		add(campo_contrato);
	}

	private void botones() {
		buscar = new JButton("Buscar Trabajador");
		buscar.setBounds(470, 200, 200, 40);

		guardar = new JButton("Guardar Nuevo Trabajador");
		guardar.setBounds(470, 270, 200, 40);
		

		cancelar = new JButton("Cancelar");
		cancelar.setBounds(470, 340, 200, 40);
		
		
		add(guardar);
		add(cancelar);
		add(buscar);
	}
}
