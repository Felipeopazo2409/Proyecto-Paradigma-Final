package paquete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class VentanaAdministrador extends JFrame {
	private JScrollPane scrollpane;
	public PanelAdministracion admin;
	public MenuPrincipal menu;
	public PanelInsertarDepto panel_insertar;
	public PanelEliminarDepto panel_eliminar;
	public PanelMostrarDepto mostrar_info;
	private int posicion_eliminar;
	public ArrayList<Departamento> lista_departamentos = new ArrayList<Departamento>();
	ArrayList<String> nombres_departamentos;
	public Departamento departamento;
	public VentanaAdministrador() {
		setSize(780,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(false);
		setLocationRelativeTo(null);
		 admin = new PanelAdministracion();
		 scrollpane = new JScrollPane();
		 scrollpane.setBounds(1,1,779,500);
		 scrollpane.setViewportView(admin);
		 add(scrollpane);
		 navegacion();
		 volver_atras();
		 insertar_datos();
		 mostrar_informacion();
		 eliminar_departamento();
	}
	
	
	private void navegacion() {
		panel_insertar = new PanelInsertarDepto();
		panel_eliminar = new PanelEliminarDepto();
		mostrar_info = new PanelMostrarDepto();
		//Pincho boton para insertar un nuevo departamento
		admin.ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setViewportView(panel_insertar);
			}
		});
		
		//Pincho boton para eliminar Departamento
		
		admin.eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setViewportView(panel_eliminar);
			}
		});
		
		//pincho boton para mostrar informacion de todos los departamentos
		
		admin.mostrarInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setViewportView(mostrar_info);
			}
		});

	}
	
	
	
	private void mostrar_informacion() {
		nombres_departamentos = new ArrayList<String>();
		mostrar_info.mostrar_lista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<lista_departamentos.size();i++) {
					System.out.println("Departamento: "+(i+1));
					System.out.println("N_Depto: "+lista_departamentos.get(i).getNumero_depto());
					System.out.println("Nombre: "+lista_departamentos.get(i).getNombre());
					System.out.println("Cantidad De trabajadores: "+lista_departamentos.get(i).getCantidad_trabajadores());
					System.out.println("\n\n");
					nombres_departamentos.add(lista_departamentos.get(i).getNombre());
				}
			}
		});
		
	}
	private void insertar_datos() {
		panel_insertar.guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenar_lista();
				JOptionPane.showMessageDialog(null, "Departamento Ingresado Exitosamente");
			}
		});
	}
	private void llenar_lista() {
		//Obtenemos informacion desde los campos textField, para poder instanciar un objeto de 
		//Departamento
		String n_depto = panel_insertar.campo1.getText();
		String nombre = panel_insertar.campo2.getText();
		String numero_trabajadores= panel_insertar.campo3.getText();
		int numero_depto = Integer.parseInt(n_depto);
		int n_trabajadores = Integer.parseInt(numero_trabajadores);
		departamento = new Departamento(numero_depto,nombre,n_trabajadores);
		lista_departamentos.add(departamento);
		FileWriter file;
		Gson gson  = new Gson();
		String json = gson.toJson(lista_departamentos);
		try {
			file = new FileWriter("Trabajadores.json");
			file.write(json);
			file.flush();
			file.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

	private void volver_atras() {
		panel_insertar.volver_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setViewportView(admin);
			}
		});
		panel_eliminar.cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setViewportView(admin);
			}
		});
		
		mostrar_info.volver_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setViewportView(admin);
			}
		});
	}
	
	private void eliminar_departamento() {
		
		panel_eliminar.buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String obtener_ndepto = panel_eliminar.input.getText();
				boolean esta = false;
				int n_depto = Integer.parseInt(obtener_ndepto);
				for (int i = 0; i < lista_departamentos.size();i++) {
					if (lista_departamentos.get(i).getNumero_depto()==n_depto) {
						posicion_eliminar =  i;
						esta = true;
						panel_eliminar.campo1.setText(lista_departamentos.get(i).getNombre());
						String cantidad = String.valueOf(lista_departamentos.get(i).getCantidad_trabajadores());
						panel_eliminar.campo2.setText(cantidad);
					}
				}
				if (esta == true) {
					JOptionPane.showMessageDialog(null,"Se ha encontrado el departamento");
				}else {
					JOptionPane.showMessageDialog(null,"El N° que ha ingresado no existe, Intente nuevamente");
				}
			}
		});
		
		panel_eliminar.eliminar_depto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista_departamentos.remove(posicion_eliminar);
				JOptionPane.showMessageDialog(null, "Departamento Eliminado Correctamente");
				panel_eliminar.input.setText("");
				panel_eliminar.campo1.setText("");
				panel_eliminar.campo2.setText("");
			}
		});
		

		
	}
	
}
