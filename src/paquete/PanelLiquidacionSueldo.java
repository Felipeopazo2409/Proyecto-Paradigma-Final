package paquete;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class PanelLiquidacionSueldo extends JPanel {
	private JLabel tipo_contrato, titulo, icon, salario_por_hora, sueldo;
	public JButton volver_menu, calcular_salario;
	public JTextField campo_rut, campo_salario;
	public JComboBox contrato;
	private final String[] contratos = { "Full-Time", "Part-Time" };

	public PanelLiquidacionSueldo() {
		setLayout(null);
		setBackground(Color.orange);
		labels();
		campos();
		botones();
		liquidacion();
	}

	private void liquidacion() {
		calcular_salario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				liquidacionSueldo();

			}
		});
	}

	private void labels() {
		titulo = new JLabel("Liquidacion de Sueldo");
		titulo.setBounds(300, 80, 400, 40);
		titulo.setFont(new Font("Helvetica", Font.PLAIN, 22));

		icon = new JLabel(new ImageIcon("logo.png"));
		icon.setBounds(0, 0, 150, 150);

		salario_por_hora = new JLabel("Ingrese Salario Para calcular Liquidacion de sueldo");
		salario_por_hora.setBounds(200, 140, 520, 40);
		salario_por_hora.setFont(new Font("Helvetica", Font.PLAIN, 20));

		tipo_contrato = new JLabel("Tipo de contrato ");
		tipo_contrato.setBounds(200, 220, 300, 40);
		tipo_contrato.setFont(new Font("Helvetica", Font.PLAIN, 20));

		contrato = new JComboBox(contratos);
		contrato.setBounds(350, 240, 180, 25);
		add(titulo);
		add(icon);
		add(salario_por_hora);
		add(tipo_contrato);
		add(contrato);
	}

	private void campos() {
		campo_salario = new JTextField();
		campo_salario.setBounds(310, 185, 200, 25);

		add(campo_salario);
	}

	private void liquidacionSueldo() {
		double salario = Integer.parseInt(campo_salario.getText()) + 30000;
		System.out.println("Salario: " + salario);
		double afp = 0.1 * salario;
		double sistema_pension = 0.07 * salario;
		double beneficio_full_time = 80000;
		if (contrato.getSelectedItem().toString() == "Full-Time") {

			JOptionPane.showMessageDialog(null,
					"El salario es: " + (salario + beneficio_full_time - sistema_pension - afp));
		} else {
			JOptionPane.showMessageDialog(null, "El salario es: " + (salario - afp - sistema_pension));
		}
	}

	private void botones() {
		volver_menu = new JButton("Volver al Menú principal");
		volver_menu.setBounds(400, 300, 200, 30);
		calcular_salario = new JButton("Calcular Sueldo");
		calcular_salario.setBounds(200, 300, 200, 30);
		add(volver_menu);
		add(calcular_salario);

	}

}
