package logica.controllers;

import java.util.HashMap;
import java.util.Map;

import pruebaDatatypes.modelo.Organizacion;
import pruebaDatatypes.modelo.Servicio;

public class OrganizacionController {
	
	private Map<Integer,Organizacion> mapOrganizacion;
	private Map<String,Servicio> mapServicio;
	private static OrganizacionController instancia = null;
	
	private OrganizacionController() {
		mapOrganizacion = new HashMap<>();
		mapServicio = new HashMap<>();
	}
	
	public static OrganizacionController getInstancia() {
		if(instancia == null) {
			instancia = new OrganizacionController();
		}
		return instancia;
	}
	
	public boolean agregarOrganizacion(int id, String nombre) {
		Organizacion org = new Organizacion(id,nombre);
		return mapOrganizacion.put(id, org) != null;	
	}
	
	public Organizacion getOrganizacion(int id) {
		return mapOrganizacion.get(id);
	}
	
	public Map<Integer,Organizacion> getAllOrganizacion(){
		return mapOrganizacion;
	}
	
	public Map<String,Servicio> getAllServicios(){
		return mapServicio;
	}
	
	public boolean altaServicio(String idServicio, String descripcion, String wsdl, String disponibilidad, int idOrganizacion) {
		Servicio serv = new Servicio(idServicio,descripcion,wsdl,disponibilidad);
		Organizacion org = getOrganizacion(idOrganizacion);
		org.agregarServicio(serv);
		return mapServicio.put(idServicio, serv) != null;
	}
	
	public Servicio getServicio(String id) {
		return mapServicio.get(id);
	}
	
	public Organizacion getOrganizacionPorNombre(String nombre) {
		Map<Integer,Organizacion> org = getAllOrganizacion();
		Organizacion organizacionBuscada = null;
		for (Map.Entry<Integer,Organizacion> entry : org.entrySet()){
			if(entry.getValue().getNombre().equals(nombre)) {
				organizacionBuscada = entry.getValue();
			}
		}
		return organizacionBuscada;
	}
	
	public void cargarDatos() {
		
		//Cargar Organizaciones
		agregarOrganizacion(1,"ASSE");
		agregarOrganizacion(2,"MEF");
		agregarOrganizacion(3,"MINT");
		agregarOrganizacion(4,"DNPT");
		agregarOrganizacion(5,"MIEM");
		agregarOrganizacion(6,"MIDES");
		agregarOrganizacion(7,"MSP");
		agregarOrganizacion(8,"BPS");
		agregarOrganizacion(9,"ADUANAS");
		agregarOrganizacion(10,"DNB");
		agregarOrganizacion(11,"MGAP");
		agregarOrganizacion(12,"CGN");
		agregarOrganizacion(13,"AGSIC");
		agregarOrganizacion(14,"MTSS");
		agregarOrganizacion(15,"IMM");
		agregarOrganizacion(16,"DNIC");
		agregarOrganizacion(17,"DNSP");
		agregarOrganizacion(18,"DGI");
		agregarOrganizacion(19,"DSE");
		agregarOrganizacion(20,"DGR");

		//Cargar Servicios
		altaServicio("1", "Este servicio expone las operaciones de alta, baja y modificacion de solicitudes de correccion de ofertas en SICE, asi como la aprobacion, consulta y listado de solicitudes y descarga de archivos asociados a las mismas.", "https://www.agesic.gub.uy/innovaportal/file/6116/1/acce_sice_solicscorreccionofertas_v4.wsdl","99%", 1); 
		altaServicio("2", "Este servicio expone la operacion de Revalida de una compra en SICE", "https://www.agesic.gub.uy/innovaportal/file/6115/1/acce_sice_revalidas.wsdl", "99%", 1);
		altaServicio("3", "Este servicio expone las operaciones de alta, baja y Modificacion de ordenes de compra en SICE, asi como el cambio de estado, aprobacion, consulta y listado de las mismas.", "https://www.agesic.gub.uy/innovaportal/file/6114/1/agesic_sice_ordenescompra.wsdl","99%", 1); 
		altaServicio("4", "Este servicio expone las operaciones de alta, baja y modificacion de facturas de ajuste en SICE, asi como el cambio de estado, aprobacion, consulta y listado de las mismas.", "https://www.agesic.gub.uy/innovaportal/file/6112/1/acce_sice_facturasajuste.wsdl","99%", 1);
		altaServicio("5", "Este servicio expone las operaciones de alta, baja y modificacion de compras comunes en SICE, asi como la aprobacion, cambio de estado, consulta y busqueda de las mismas.", "https://www.agesic.gub.uy/innovaportal/file/6110/1/acce_sice_facturas.wsdl","99%", 1); 
		altaServicio("6", "Este servicio expone las operaciones de Alta, Baja y Modificacion de ampliaciones en SICE, asi como el cambio de estado, aprobacion, consulta y descarga de archivos de las mismas.", "https://www.agesic.gub.uy/innovaportal/file/6108/1/ampliaciones_prod_v3.wsdl","99%", 1);
		altaServicio("7", "Este servicio expone la operacion de Cierre de compras en SICE, asi como cambio de estado.", "https://www.agesic.gub.uy/innovaportal/file/6106/1/adjudicaciones_prod_v3.wsdl","99%", 1); 
		altaServicio("8", "Este servicio expone las operaciones de Alta de aclaraciones a llamados/invitaciones a cotizar y adjudicaciones en SICE, asi como el listado de los mismos y descarga de un archivo de aclaracion.",  "https://www.agesic.gub.uy/innovaportal/file/6106/1/adjudicaciones_prod_v3.wsdl","99%", 1);
		altaServicio("9", "Este servicio provee los valores reales de un padron, el valor promedio para el pago de impuestos e indica si tiene una declaracion jurada de caracterizacion urbana. Indica su fecha de presentacion y de vencimiento.", "https://www.agesic.gub.uy/innovaportal/file/5330/1/catastrosubiwebservice.xsd","media", 2); 
		altaServicio("10", "Valida si el usuario -incluyendo su documento de identidad- esta autorizado a realizar el tramite, ya sea en nombre propio o en el de las empresas.", "https://www.agesic.gub.uy/innovaportal/file/6082/1/consultarusuarioauttramite.wsdl","", 3);
	}
}
