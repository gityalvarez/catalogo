package beans;

import beans.interfaces.BeanTestLocal;
import beans.interfaces.BeanTestRemote;
import logica.controllers.OrganizacionController;
import pruebaDatatypes.modelo.Organizacion;
import pruebaDatatypes.modelo.Servicio;
import java.io.Serializable;
import java.util.Map;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class BeanTest
 */
@Stateless
@LocalBean
public class BeanTest implements BeanTestLocal , BeanTestRemote , Serializable {

	private static final long serialVersionUID = 1L;

    public BeanTest() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public boolean agregarServicio(String nombreOrganizacion, String idServicio, String descripcion, String wsdl, String disponibilidad) {
		// TODO Auto-generated method stub
		Organizacion org = OrganizacionController.getInstancia().getOrganizacionPorNombre(nombreOrganizacion);
		if(org != null && org.getServicios().size() < 10) {
			OrganizacionController.getInstancia().altaServicio(idServicio, descripcion, wsdl, disponibilidad, org.getId());
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public Servicio obtenerServicioPorId(String idServicio) {
		// TODO Auto-generated method stub
		return OrganizacionController.getInstancia().getServicio(idServicio);
	}
	
	@Override
	public  Map<String, Servicio> obtenerServicios() {
		// TODO Auto-generated method stub
		return OrganizacionController.getInstancia().getAllServicios();
	}

	@Override
	public Map<String, Servicio> obtenerServiciosPorOrganizacion(String nombre) {
		// TODO Auto-generated method stub
		Organizacion org = OrganizacionController.getInstancia().getOrganizacionPorNombre(nombre);
		return org.getServicios();
	}
	
	@Override
	public  Map<Integer, Organizacion> getAllOrganizacion() {
		// TODO Auto-generated method stub
		return OrganizacionController.getInstancia().getAllOrganizacion();
	}

}
