package pruebaCliente;

import java.util.Map;
import java.util.Scanner;
import javax.ejb.EJB;
import pruebaDatatypes.modelo.Organizacion;
import pruebaDatatypes.modelo.Servicio;
import beans.interfaces.BeanTestRemote;
import utils.Utils;

public class Principal {

	@EJB private static BeanTestRemote bean;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//BeanTestRemote bean = Utils.doLookup();
			bean = Utils.doLookup();
			boolean fin = false;
			String idServicio, descripcionServicio, wsdlServicio, disponibilidadServicio, nombreOrganizacion;
			Scanner scanDatos = new Scanner(System.in);
			int opcion;
			while(!fin) {
				System.out.println("Menu Principal");
				System.out.println("==============");
				System.out.println();
				System.out.println("1) Agregar un Servicio");
				System.out.println("2) Listar Servicios");
				System.out.println("3) Listar Servicios de una Organizacion");
				System.out.println("9) Salir");
				System.out.println();
				System.out.print("Opcion: ");
				opcion = Integer.parseInt(scanDatos.nextLine());
				switch(opcion) {
				
					case 1:	System.out.println("Organizaciones");
							System.out.println("==============");
							System.out.println();
							
							Map<Integer,Organizacion> org = bean.getAllOrganizacion();
							for (Map.Entry<Integer,Organizacion> entry : org.entrySet()){
							    System.out.println(entry.getValue().getNombre());
							}
							
							System.out.print("Nombre de la Organizacion: ");
							nombreOrganizacion = scanDatos.nextLine();
							System.out.print("Id del Servicio: ");
							idServicio = scanDatos.nextLine();
							System.out.print("Descripcion del Servicio: ");
							descripcionServicio = scanDatos.nextLine();
							System.out.print("Wsdl del Servicio: ");
							wsdlServicio = scanDatos.nextLine();
							System.out.print("Disponibilidad del Servicio: ");
							disponibilidadServicio = scanDatos.nextLine();
							if(bean.agregarServicio(nombreOrganizacion,idServicio,descripcionServicio,wsdlServicio,disponibilidadServicio)) {
								System.out.println("Servicio agregado correctamente");
							}else {
								System.out.println("Error: El servicio no se pudo agregar");
							}
							break;
							
					
					case 2: System.out.println("Servicios");
							System.out.println("=========");
							System.out.println();
							Map<String,Servicio> serv = bean.obtenerServicios();
							for (Map.Entry<String,Servicio> entry : serv.entrySet()){
							    System.out.println("Id: "+ entry.getValue().getId());
							    System.out.println("Descripcion: "+ entry.getValue().getDescripcion());
							    System.out.println("Wsdl: "+ entry.getValue().getWsdl());
							    System.out.println("Disponibilidad: "+ entry.getValue().getDisponibilidad());
							    System.out.println();
							    System.out.println("===========================================================================");
							    System.out.println();
							}
							break;
							
					case 3: System.out.println("Organizaciones");
							System.out.println("==============");
							System.out.println();
							Map<Integer,Organizacion> orga = bean.getAllOrganizacion();
							for (Map.Entry<Integer,Organizacion> entry : orga.entrySet()){
							    System.out.println(entry.getValue().getNombre());
							}
							System.out.print("Nombre de la Organizacion: ");
							nombreOrganizacion = scanDatos.nextLine();
							System.out.println("Servicios");
							System.out.println("=========");
							System.out.println();
							Map<String,Servicio> serviciosDeOrganizacion = bean.obtenerServiciosPorOrganizacion(nombreOrganizacion);
							for (Map.Entry<String,Servicio> entry : serviciosDeOrganizacion.entrySet()){
							    System.out.println("Id: "+ entry.getValue().getId());
							    System.out.println("Descripcion: "+ entry.getValue().getDescripcion());
							    System.out.println("Wsdl: "+ entry.getValue().getWsdl());
							    System.out.println("Disponibilidad: "+ entry.getValue().getDisponibilidad());
							    System.out.println();
							    System.out.println("===========================================================================");
							    System.out.println();
							}
							break;
					
					case 9:	fin = true;
							break;
							
					default: System.out.println("Opcion Incorrecta");
				}
			}
			scanDatos.close();
			System.out.println("Gracias por usar la aplicacion!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
