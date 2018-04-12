package pruebaDatatypes.datatype;

public class dtServicio {
	private String id;
	private String descripcion;
	private String wsdl;
	private String disponibilidad;
	public dtServicio(String id, String descripcion, String wsdl, String disponibilidad) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.wsdl = wsdl;
		this.disponibilidad = disponibilidad;
	}
	public String getId() {
		return id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getWsdl() {
		return wsdl;
	}
	public String getDisponibilidad() {
		return disponibilidad;
	}
	
	
}
