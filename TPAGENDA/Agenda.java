package TPAGENDA;
import java.time.LocalDate;

public class Agenda {
	
	protected String nombre;
	protected LocalDate fecha;
	protected String descripcion;
	protected Long ID;

	public Agenda(String nombre,String descripcion,LocalDate fecha){
			this.nombre=nombre;
			this.descripcion = descripcion;
			this.fecha = fecha;
		}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}

