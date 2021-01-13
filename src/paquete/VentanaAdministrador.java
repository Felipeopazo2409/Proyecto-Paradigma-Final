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
	public PanelInsertarDepto insertar;
	public PanelEliminarDepto eliminar;
	public PanelMostrarDepto mostrar_info;
	public ArrayList<Departamento> lista_departamentos = new ArrayList<Departamento>();

	public JSONArray arreglo = new JSONArray();
	public Departamento departamento;
	public int pos;
	public int cont =0;
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
		//Instanciamos los paneles para hacer un scroll
		insertar = new PanelInsertarDepto();
		eliminar = new PanelEliminarDepto();
		mostrar_info = new PanelMostrarDepto();
		//Pincho boton para insertar un nuevo departamento
		admin.ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setViewportView(insertar);
			}
		});
		
		//Pincho boton para eliminar Departamento
		
		admin.eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setViewportView(eliminar);
			}
		});
		
		//pincho boton para mostrar informacion de todos los departamentos
		
		admin.mostrarInformacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setViewportView(mostrar_info);
			}
		});

	}
	
	
	
	
	private void insertar_datos() {//Aqui vamos a insertar datos del departamento en el arraylist
		insertar.guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenar_lista();
				insertar.campo1.setText("");
				insertar.campo2.setText("");
				insertar.campo3.setText("");
				JOptionPane.showMessageDialog(null, "Departamento Ingresado Exitosamente");
			}
		});
	}

	private void volver_atras() {//Aqui navegamos hacia atras en los paneles
		insertar.volver_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollpane.setViewportView(admin);
			}
		});
		eliminar.cancelar.addActionListener(new ActionListener() {
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
	private void llenar_lista() {
		//Obtenemos informacion desde los campos textField, para poder instanciar un objeto de 
		//Departamento
		String n_depto = insertar.campo1.getText();
		String nombre = insertar.campo2.getText();
		String numero_trabajadores= insertar.campo3.getText();
		int numero_depto = Integer.parseInt(n_depto);
		int n_trabajadores = Integer.parseInt(numero_trabajadores);
		//Instanciamos un nuevo departamento
		departamento = new Departamento(numero_depto,nombre,n_trabajadores);
		//Agregamos un departamento en la lista
		lista_departamentos.add(departamento);
        FileWriter file;
        //Aquí Exportamos el json
        Gson gson  = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(lista_departamentos);
        try {
            file = new FileWriter("Departamentos.json");
            file.write(json);
            file.flush();
            file.close();
            
        }catch(IOException e) {
            e.printStackTrace();
        }
			
	}
	
	private void eliminar_departamento() {
		//Aqui Buscamos el departamento por su numero para eliminar
		eliminar.buscar.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
			  String n_depto = eliminar.input.getText();
			  boolean esta=false;
			  int n_departamento = Integer.parseInt(n_depto);
			  for (int i = 0;i<lista_departamentos.size();i++) {
				  if (lista_departamentos.get(i).getNumero_depto()==n_departamento) {
					  pos = i;
					  eliminar.campo1.setText(lista_departamentos.get(i).getNombre());
					  int cantidad = lista_departamentos.get(i).getCantidad_trabajadores();
					  eliminar.campo2.setText(String.valueOf(cantidad));
					  esta = true;
				  }
			  }
			  //Alertas
			  if (esta == true) {
				  JOptionPane.showMessageDialog(null, "Se ha encontrado el departamento");
			  }else {
				  JOptionPane.showMessageDialog(null,"No se ha podido Encontrar el departamento, Intente nuevamente");
			  }
			}
		});
		
		eliminar.eliminar_depto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista_departamentos.remove(pos);//Eliminamos el departamento por posicion
				eliminar.input.setText("");//Limpiamos la pantalla
				eliminar.campo1.setText("");
				eliminar.campo2.setText("");
				JOptionPane.showMessageDialog(null,"Se ha eliminado el departamento correctamente");
			}
		});
		
	}
	private void mostrar_informacion() {
		//Imprime la informacion por consola, no se logró mostrarla por la interfaz
		mostrar_info.mostrar_lista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<lista_departamentos.size();i++) {
					System.out.println("Departamento: "+(i+1));
					System.out.println("N_Depto: "+lista_departamentos.get(i).getNumero_depto());
					System.out.println("Nombre: "+lista_departamentos.get(i).getNombre());
					System.out.println("Cantidad De trabajadores: "+lista_departamentos.get(i).getCantidad_trabajadores());
					System.out.println("\n\n");
				}
			}
		});
		
	}
	
}
