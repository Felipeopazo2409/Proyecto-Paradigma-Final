package paquete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class VentanaPrincipal extends JFrame  {
	public MenuPrincipal menu;
	public PanelAdministracion admin;
	public  PanelTrabajador panel_trabajador;
	private JScrollPane scrollPaneles;
	

	public VentanaPrincipal() {
		setSize(780,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);

		cargarComponentes();
	}
	public void cargarComponentes() {
		menu = new MenuPrincipal();
		scrollPaneles = new JScrollPane();
		scrollPaneles.setBounds(1,1,779,500);
		add(scrollPaneles);
		scrollPaneles.setViewportView(menu);
		
	}
}
