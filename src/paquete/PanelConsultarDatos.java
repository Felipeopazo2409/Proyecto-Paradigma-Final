package paquete;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelConsultarDatos extends JPanel {
	private JLabel titulo,icono;
	private JLabel nombre,apellidoP,apellidoM,rut,fecha_nacimiento,tipo_contrato,salario,departamento;
    public JTextArea campoNombre,campoApellidoMaterno,campoApellidoPaterno,campoNacimiento,campo_contrato,camposalario,campodepartamento;
    public JTextField campo_rut;
    public JButton volver_menu;
    public JButton buscar;
	public PanelConsultarDatos() {
		setLayout(null);
		setBackground(Color.orange);
		cargarComponentesLabel();
		cargarComponentesText();
		cargarComponentesButton();
		textField();
	}
	private void cargarComponentesLabel() {
		//Creamos los labels para el panel
		titulo = new JLabel("Consultar Datos de Trabajadores");
		titulo.setBounds(240,60,420,40);
		titulo.setFont(new Font("Helvetica",Font.PLAIN,25));
		
		rut = new JLabel("Ingresar Rut");
		rut.setBounds(150,150,200,40);
		rut.setFont(new Font("Helvetica",Font.PLAIN,20));
		
		nombre = new JLabel("Nombre");
		nombre.setBounds(50,190,100,40);
		nombre.setFont(new Font("Helvetica",Font.PLAIN,20));
		
		apellidoP = new JLabel("Apellido Paterno ");
		apellidoP.setBounds(50,220,150,40);
		apellidoP.setFont(new Font("Helvetica",Font.PLAIN,20));
		
		
		apellidoM = new JLabel("Apellido Materno ");
		apellidoM.setBounds(50,250,180,40);
		apellidoM.setFont(new Font("Helvetica",Font.PLAIN,20));
		
		
		fecha_nacimiento = new JLabel("Fecha de nacimiento ");
		fecha_nacimiento.setBounds(50,280,300,40);
		fecha_nacimiento.setFont(new Font("Helvetica",Font.PLAIN,20));
		
		
		tipo_contrato = new JLabel("Tipo de contrato ");
		tipo_contrato.setBounds(50,310,300,40);
		tipo_contrato.setFont(new Font("Helvetica",Font.PLAIN,20));
	
		
		salario = new JLabel("Salario por hora ");
		salario.setBounds(50,340,300,40);
		salario.setFont(new Font("Helvetica",Font.PLAIN,20));
		
		departamento = new JLabel("Departamento ");
		departamento.setBounds(50,370,300,40);
		departamento.setFont(new Font("Helvetica",Font.PLAIN,20));
		
		icono = new JLabel(new ImageIcon("logo.png"));
		icono.setBounds(1,1,150,150);
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
	
	private void cargarComponentesText() {
		//Creamos los diferentes Campos de texto para extraer informacion por teclado
		
		campoNombre = new JTextArea();
		campoNombre.setBounds(235,200,180,20);
	
		
		campoApellidoPaterno = new JTextArea();
		campoApellidoPaterno.setBounds(235,230,180,20);
		
		
		campoApellidoMaterno = new JTextArea();
		campoApellidoMaterno.setBounds(235,260,180,20);
		
		campoNacimiento = new JTextArea();
		campoNacimiento.setBounds(235,290,180,20);
		
		campo_contrato = new JTextArea();
		campo_contrato.setBounds(235,320,180,20);
		
		camposalario = new JTextArea();
		camposalario.setBounds(235,350,180,20);
		
		campodepartamento = new JTextArea();
		campodepartamento.setBounds(235,380,180,20);
		
		add(campoNombre);
		add(campoApellidoPaterno);
		add(campoApellidoMaterno);
		add(campoNacimiento);
		add(campo_contrato);
		add(camposalario);
		add(campodepartamento);
		
	}
	
	public void cargarComponentesButton() {
		//Creamos los diferentes botones para el panel
		buscar = new JButton("Buscar Trabajador");
		buscar.setBounds(500,150,230,40);
		buscar.setFont(new Font("Helvetica",Font.PLAIN,16));
		
		volver_menu = new JButton("Volver al menu principal");
		volver_menu.setBounds(500,230,230,40);
		volver_menu.setFont(new Font("Helvetica",Font.PLAIN,16));
		add(buscar);
		
		add(volver_menu);
		
	}	
	private void textField() {
		campo_rut = new JTextField();
		campo_rut.setBounds(270,160,180,20);
		add(campo_rut);
	}
}
