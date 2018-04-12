package beans.interfaces;

import java.util.Map;
import javax.ejb.Local;

import pruebaDatatypes.modelo.Organizacion;
import pruebaDatatypes.modelo.Servicio;

@Local
public interface BeanTestLocal {
	public boolean agregarServicio(String nombreOrganizacion, String idServicio, String descripcion, String wsdl, String disponibilidad);
	public Servicio obtenerServicioPorId(String idServicio);
	public Map<String, Servicio> obtenerServicios();
	public Map<String, Servicio> obtenerServiciosPorOrganizacion(String nombre);
	public Map<Integer, Organizacion> getAllOrganizacion();
}
