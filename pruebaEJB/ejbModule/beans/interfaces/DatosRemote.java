package beans.interfaces;

import javax.ejb.Remote;

import pruebaDatatypes.modelo.Organizacion;
import pruebaDatatypes.modelo.Servicio;

@Remote
public interface DatosRemote {
	public boolean altaServicio(String idServicio, String descripcion, String wsdl, String disponibilidad, int idOrganizacion);
	public Servicio getServicio(String id);
	public Organizacion getOrganizacion(int id);
}
