package beans.interfaces;

import javax.ejb.Local;

import pruebaDatatypes.modelo.Organizacion;
import pruebaDatatypes.modelo.Servicio;

@Local
public interface DatosLocal {
	public boolean altaServicio(String idServicio, String descripcion, String wsdl, String disponibilidad, int idOrganizacion);
	public Servicio getServicio(String id);
	public Organizacion getOrganizacion(int id);
}	
