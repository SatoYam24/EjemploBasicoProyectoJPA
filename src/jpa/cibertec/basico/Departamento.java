package jpa.cibertec.basico;
import javax.persistence.*;

@Entity
@Table(name="departamento")
public class Departamento {
	//sus atributos...
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddepartamento;
	@Column(name="nombre")
	private String nombre;
	@Column(name="descripcion")
	private String descripcion;
	
	
	public Departamento() {
		//super();
	}  //fin del constructor vacio...
	
	
	public Departamento(int iddepartamento, String nombre, String descripcion) {
		//super();
		this.iddepartamento = iddepartamento;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}    //fin del constructor con parametros 3
	
	public Departamento(String nombre, String descripcion) {
		//super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}  //fin del constructor con parametros 2


	//creamos sus metodos getter y setters.....
	public int getIddepartamento() {
		return iddepartamento;
	}
	public void setIddepartamento(int iddepartamento) {
		this.iddepartamento = iddepartamento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}  //fin de la clase departamento.....
