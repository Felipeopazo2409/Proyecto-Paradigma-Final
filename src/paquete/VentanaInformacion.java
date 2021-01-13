package paquete;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class VentanaInformacion extends JFrame{
	public PanelInformacionEmpresa panel_informacion;
	private JScrollPane scrollPaneles;

	public VentanaInformacion() {
		setSize(780,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(false);
		setLocationRelativeTo(null);
		cargarComponentes();
	
	}
	public void cargarComponentes() {
		panel_informacion = new PanelInformacionEmpresa();
		scrollPaneles = new JScrollPane();
		scrollPaneles.setBounds(1,1,779,500);
		add(scrollPaneles);
		scrollPaneles.setViewportView(panel_informacion);
		
	}
}
