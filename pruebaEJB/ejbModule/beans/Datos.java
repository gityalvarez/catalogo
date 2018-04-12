package beans;

import beans.interfaces.DatosLocal;
import beans.interfaces.DatosRemote;
import logica.controllers.OrganizacionController;
import pruebaDatatypes.modelo.Organizacion;
import pruebaDatatypes.modelo.Servicio;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@LocalBean
@Startup
public class Datos implements DatosRemote, DatosLocal, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Datos() {
        // TODO Auto-generated constructor stub
    }
	
	@PostConstruct
	public void cargarDatos() {
		OrganizacionController.getInstancia().cargarDatos();
	}

	@Override
	public boolean altaServicio(String idServicio, String descripcion, String wsdl, String disponibilidad, int idOrganizacion) {
		// TODO Auto-generated method stub
		return OrganizacionController.getInstancia().altaServicio(idServicio, descripcion, wsdl, disponibilidad, idOrganizacion);
	}

	@Override
	public Servicio getServicio(String id) {
		// TODO Auto-generated method stub
		return OrganizacionController.getInstancia().getServicio(id);
	}

	@Override
	public Organizacion getOrganizacion(int id) {
		// TODO Auto-generated method stub
		return OrganizacionController.getInstancia().getOrganizacion(id);
	}

}
