package jpa.cibertec.basico;
import javax.persistence.*;


@Entity
@Table(name="empleado")
public class Empleado {
//creamos sus atributos...
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idempleado;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="sexo")
	private String sexo;
	@Column(name="dni")
	private String dni;
	@Column(name="email")
	private String email;
	@Column(name="telefono")
	private String tel;
	@Column(name="sueldo")
	private double sueldo;
	@ManyToOne
	@JoinColumn(name="departamento")	
	private Departamento departamento;
	
	public Empleado(int idempleado, String nombre, String apellido, String sexo, String dni, String email, String tel,
			double sueldo, Departamento departamento) {
	//	super();
		this.idempleado = idempleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.dni = dni;
		this.email = email;
		this.tel = tel;
		this.sueldo = sueldo;
		this.departamento = departamento;
	}  //fin del constructor con todos los parametro...
	
	public Empleado() {
		//super();
	}  //fin del constructor vacio...
	

	public Empleado(String nombre, String apellido, String sexo, String dni, String email, String tel, double sueldo,
			Departamento departamento) {
		//super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.dni = dni;
		this.email = email;
		this.tel = tel;
		this.sueldo = sueldo;
		this.departamento = departamento;
	}   //fin del constructor sin el parametro idempleado....

	//metodos getter y setter.....
	public int getIdempleado() {
		return idempleado;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public void setIdempleado(int idempleado) {
		this.idempleado = idempleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
	
}   //fin de la clase empleado....
