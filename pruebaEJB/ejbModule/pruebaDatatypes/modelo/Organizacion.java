package pruebaDatatypes.modelo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Organizacion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private Map<String, Servicio> mapServicio;
	
	public Organizacion() {
		super();
		mapServicio = new HashMap<>();
	}
	public Organizacion(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
		mapServicio = new HashMap<>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Map<String, Servicio> getServicios() {
		return mapServicio;
	}
	public void setServicios(Map<String, Servicio> mapServicio) {
		this.mapServicio = mapServicio;
	}
	public void agregarServicio(Servicio s) {
		s.setOrganizacion(this);
		mapServicio.put(s.getId(), s);
	}
	
	
}
