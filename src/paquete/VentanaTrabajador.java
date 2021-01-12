package paquete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

public class VentanaTrabajador extends JFrame {
	public PanelTrabajador panel;
	private JScrollPane scrollpane;
	public PanelInsertarTrabajador panelInsertarTrabajador;
	public PanelModificarTrabajador panelModificarTrabajador;
	public PanelEliminarTrabajador panelEliminarTrabajador;
	private PanelConsultarDatos panelConsultarTrabajador;
	private PanelLiquidacionSueldo panelLiquidacionTrabajador;
	public Trabajador trabajador;
	public ArrayList<Trabajador> lista_trabajadores = new ArrayList();
	public JSONArray arreglo;
	public int pos;
	public int pos_eliminar;
	public int cont;
	public VentanaTrabajador() {
		panel = new PanelTrabajador();
		arreglo = new JSONArray();
		setSize(780, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(false);
		setLocationRelativeTo(null);
		Inicializar();
		navegacion();
		volver_atras();
		insertarDatos();
		modificar_informacion();
		eliminar_trabajador();
		consultar_datos();
	
	}
	private void Inicializar() {
		scrollpane = new JScrollPane();
		scrollpane.setBounds(1, 1, 779, 500);
		scrollpane.setViewportView(panel);
		add(scrollpane);
	}
	
	private void navegacion() {//Navegamos por los diferentes paneles
		// Instancia de paneles
		panelInsertarTrabajador = new PanelInsertarTrabajador();
		panelModificarTrabajador = new PanelModificarTrabajador();
		panelEliminarTrabajador = new PanelEliminarTrabajador();
		panelConsultarTrabajador = new PanelConsultarDatos();
		panelLiquidacionTrabajador = new PanelLiquidacionSueldo();
	
		// Eventos de los botones
		
		// pinchar boton para ingresar un trabajador
		panel.ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setViewportView(panelInsertarTrabajador);
			}
		});

		// Pinchar Boton para modificar un trabajador
		panel.modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setViewportView(panelModificarTrabajador);

			}
		});

		// Pinchar Boton para Eliminar un trabajador
		panel.eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setViewportView(panelEliminarTrabajador);
			}
		});
		// Pinchar Boton para Consultar Datos de un trabajador
		panel.consultar_datos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setViewportView(panelConsultarTrabajador);
			}
		});
		// Pinchar Boton para Generar Liquidacion de sueldo
		panel.generar_liquidacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setViewportView(panelLiquidacionTrabajador);
			}
		});
	}


	
	private void volver_atras() {
		panelInsertarTrabajador.cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setViewportView(panel);
			}
		});

		panelModificarTrabajador.cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setViewportView(panel);
			}
		});

		panelEliminarTrabajador.cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setViewportView(panel);
			}
		});
		panelConsultarTrabajador.volver_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setViewportView(panel);
			}
		});
		panelLiquidacionTrabajador.volver_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setViewportView(panel);
			}
		});

	}

	private void insertarDatos() {

		panelInsertarTrabajador.guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarTrabajadores();
				panelInsertarTrabajador.campoNombre.setText("");
				panelInsertarTrabajador.campoApellidoPaterno.setText("");
				panelInsertarTrabajador.campoApellidoMaterno.setText("");
				panelInsertarTrabajador.campoNacimiento.setText("");
				panelInsertarTrabajador.campoRut.setText("");
				panelInsertarTrabajador.campoSalario.setText("");
				panelInsertarTrabajador.campoDepartamento.setText("");
				JOptionPane.showMessageDialog(null, "Trabajador ingresado Exitosamente");
			}
		});

	}

	private void insertarTrabajadores() {

		String nombre = panelInsertarTrabajador.campoNombre.getText();
		String apellidoP = panelInsertarTrabajador.campoApellidoPaterno.getText();
		String apellidoM = panelInsertarTrabajador.campoApellidoMaterno.getText();
		String obtener_rut = panelInsertarTrabajador.campoRut.getText();
		String fecha = panelInsertarTrabajador.campoNacimiento.getText();
		String tipo_contrato = panelInsertarTrabajador.contrato.getSelectedItem().toString();
		String obtener_salario = panelInsertarTrabajador.campoSalario.getText();
		String departamento = panelInsertarTrabajador.campoDepartamento.getText();
		int rut = Integer.parseInt(obtener_rut);
		int salario = Integer.parseInt(obtener_salario);
		System.out.println("Salario: "+salario);
		trabajador = new Trabajador(nombre, apellidoP, apellidoM, rut, fecha, tipo_contrato, salario, departamento);
		lista_trabajadores.add(trabajador);
		arreglo.put(cont,trabajador);
		
		FileWriter file;
		Gson gson  = new Gson();
		String json = gson.toJson(lista_trabajadores);
		try {
			file = new FileWriter("Trabajadores.json");
			file.write(json);
			file.flush();
			file.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

	private void modificar_informacion() {
		
		panelModificarTrabajador.buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String obtener_rut = panelModificarTrabajador.campoRut.getText();
				int rut = Integer.parseInt(obtener_rut);
				boolean encontrado = false;
				for(int i=0;i<lista_trabajadores.size();i++) {
					if(lista_trabajadores.get(i).getRut()== rut ) {
						pos = i;
						encontrado = true;
						panelModificarTrabajador.campoNombre.setText(lista_trabajadores.get(i).getNombre());
						panelModificarTrabajador.campoApellidoPaterno.setText(lista_trabajadores.get(i).getAPaterno());
						panelModificarTrabajador.campoApellidoMaterno.setText(lista_trabajadores.get(i).getAMaterno());
						panelModificarTrabajador.campoNacimiento.setText(lista_trabajadores.get(i).getFecha());
						String salario = String.valueOf(lista_trabajadores.get(i).getSalario());
						panelModificarTrabajador.campo_contrato.setText(lista_trabajadores.get(i).getContrato());
						panelModificarTrabajador.campoSalario.setText(salario);
						panelModificarTrabajador.campoDepartamento.setText(lista_trabajadores.get(i).getDepartamento());
					}
				}
		
				if (encontrado == true) {
					JOptionPane.showMessageDialog(null,"Trabajador Encontrado exitosamente");
				}else {
					JOptionPane.showMessageDialog(null,"Error al encontrar trabajador,Intente Nuevamente");
				}
			}
			
		});
		
		//Guardamos la información del trabajador modificado
		panelModificarTrabajador.guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Obtengo los valores de los campos TextField
				String nombre = panelModificarTrabajador.campoNombre.getText();
				String apellidoP = panelModificarTrabajador.campoApellidoPaterno.getText();
				String apellidoM = panelModificarTrabajador.campoApellidoMaterno.getText();
				String obtener_rut = panelModificarTrabajador.campoRut.getText();
				String fecha = panelModificarTrabajador.campoNacimiento.getText();
				String tipo_contrato = panelModificarTrabajador.campo_contrato.getText();
				String obtener_salario = panelModificarTrabajador.campoSalario.getText();
				String departamento = panelModificarTrabajador.campoDepartamento.getText();
				int rut = Integer.parseInt(obtener_rut);
				int salario = Integer.parseInt(obtener_salario);
				
				//Modifico la informacion en el indice pos
				
				lista_trabajadores.get(pos).setNombre(nombre);
				lista_trabajadores.get(pos).setAPaterno(apellidoP);
				lista_trabajadores.get(pos).setAMaterno(apellidoM);
				lista_trabajadores.get(pos).setContrato(tipo_contrato);
				lista_trabajadores.get(pos).setFecha(fecha);
				lista_trabajadores.get(pos).setDepartamento(departamento);
				lista_trabajadores.get(pos).setSalario(salario);
				
				//Mensaje De alerta
				panelModificarTrabajador.campoNombre.setText("");
				panelModificarTrabajador.campoApellidoPaterno.setText("");
				panelModificarTrabajador.campoApellidoMaterno.setText("");
				panelModificarTrabajador.campoNacimiento.setText("");
				panelModificarTrabajador.campo_contrato.setText("");
				panelModificarTrabajador.campoSalario.setText("");
				panelModificarTrabajador.campoDepartamento.setText("");
				JOptionPane.showMessageDialog(null, "Trabajador Modificado exitosamente");
				
			}
		});
		
		
	}
	private void eliminar_trabajador() {
		panelEliminarTrabajador.buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String obtener_rut = panelEliminarTrabajador.campo_rut.getText();
				int rut = Integer.parseInt(obtener_rut);
				boolean encontrado = false;
				for (int i =0;i<lista_trabajadores.size();i++) {
					if (lista_trabajadores.get(i).getRut()== rut) {
						encontrado = true;
						pos_eliminar = i;
						panelEliminarTrabajador.campoNombre.setText(lista_trabajadores.get(i).getNombre());
						panelEliminarTrabajador.campoApellidoPaterno.setText(lista_trabajadores.get(i).getAPaterno());
						panelEliminarTrabajador.campoApellidoMaterno.setText(lista_trabajadores.get(i).getAMaterno());
						panelEliminarTrabajador.campoNacimiento.setText(lista_trabajadores.get(i).getFecha());
						String salario = String.valueOf(lista_trabajadores.get(i).getSalario());
						panelEliminarTrabajador.campo_contrato.setText(lista_trabajadores.get(i).getContrato());
						panelEliminarTrabajador.camposalario.setText(salario);
						panelEliminarTrabajador.campodepartamento.setText(lista_trabajadores.get(i).getDepartamento());
					}
				}
				if(encontrado == true) {
					JOptionPane.showMessageDialog(null, "Se ha encontrado el trabajador");
				}else {
					JOptionPane.showMessageDialog(null, "El trabajador no existe");
				}
				
				
				
			}
		});
		
		panelEliminarTrabajador.eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista_trabajadores.remove(pos_eliminar);
				panelEliminarTrabajador.campoNombre.setText("");
				panelEliminarTrabajador.campoApellidoPaterno.setText("");
				panelEliminarTrabajador.campoApellidoMaterno.setText("");
				panelEliminarTrabajador.campoNacimiento.setText("");
				panelEliminarTrabajador.campo_contrato.setText("");
				panelEliminarTrabajador.camposalario.setText("");
				panelEliminarTrabajador.campodepartamento.setText("");
				JOptionPane.showMessageDialog(null,"Trabajador eliminado exitosamente");
			}
		});
		
	}
		
	private void consultar_datos() {
		
		panelConsultarTrabajador.buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String obtener_rut = panelConsultarTrabajador.campo_rut.getText();
				int rut = Integer.parseInt(obtener_rut);
				boolean encontrado = false;
				for(int i=0;i<lista_trabajadores.size();i++) {
					if(lista_trabajadores.get(i).getRut()== rut ) {

						encontrado = true;
						panelConsultarTrabajador.campoNombre.setText(lista_trabajadores.get(i).getNombre());
						panelConsultarTrabajador.campoNombre.setEditable(false);
						
						panelConsultarTrabajador.campoApellidoPaterno.setText(lista_trabajadores.get(i).getAPaterno());
						panelConsultarTrabajador.campoApellidoPaterno.setEditable(false);
						
						panelConsultarTrabajador.campoApellidoMaterno.setText(lista_trabajadores.get(i).getAMaterno());
						panelConsultarTrabajador.campoNacimiento.setText(lista_trabajadores.get(i).getFecha());
						String salario = String.valueOf(lista_trabajadores.get(i).getSalario());
						panelConsultarTrabajador.campo_contrato.setText(lista_trabajadores.get(i).getContrato());
						panelConsultarTrabajador.camposalario.setText(salario);;
						panelConsultarTrabajador.campodepartamento.setText(lista_trabajadores.get(i).getDepartamento());
					}
				}

				if (encontrado == true) {
					JOptionPane.showMessageDialog(null,"Trabajador Encontrado exitosamente");
				}else {
					JOptionPane.showMessageDialog(null,"Error al encontrar trabajador,Intente Nuevamente");
				}
			}
		});
		
		
	}
	
	}
	

	
