package pruebaDatatypes.modelo;

import java.io.Serializable;

public class Servicio implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String descripcion;
	private String wsdl;
	private String disponibilidad;
	public Servicio() {
		super();
	}
	public Servicio(String id, String descripcion, String wsdl, String disponibilidad) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.wsdl = wsdl;
		this.disponibilidad = disponibilidad;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getWsdl() {
		return wsdl;
	}
	public void setWsdl(String wsdl) {
		this.wsdl = wsdl;
	}
	public String getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
}
