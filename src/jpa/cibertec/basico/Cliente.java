package jpa.cibertec.basico;
import javax.persistence.*;


@Entity
@Table(name="cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int idcliente;
	@Column(name="nombre")
	private int nombre;
	@Column(name="apellido")
	private int apellido;
	@Column(name="dni")
	private int dni;
	@Column(name="sexo")
	private int sexo;
	@Column(name="email")
	private int email;
	@Column(name="telefono")
	private int telefono;
	
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	public int getApellido() {
		return apellido;
	}
	public void setApellido(int apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	public int getEmail() {
		return email;
	}
	public void setEmail(int email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public Cliente(int idcliente, int nombre, int apellido, int dni, int sexo, int email, int telefono) {
		super();
		this.idcliente = idcliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.sexo = sexo;
		this.email = email;
		this.telefono = telefono;
	}
	public Cliente() {
		//super();
	}
	
	
	
	
}
