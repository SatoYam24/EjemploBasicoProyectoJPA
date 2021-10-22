package jpa.cibertec.basico;

import java.util.Date;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name="venta")
public class Venta {
	//Creamos sus respectivos atributos
	//Creamos la llave primaria auto incrementable
	@Id
	@Column(name="id")
	private int idventa;
	@Column(name="importe")
	private double importe;
	@Column(name="fecha")
	private Date fecha;
	
	@JoinTable(
			name="rel_venta_producto",
			joinColumns=@JoinColumn(name="FK_VENTA"),
			inverseJoinColumns=@JoinColumn(name="FK_PRODUCTO")
			)
			@ManyToMany(cascade=CascadeType.ALL)
	
	private List<Producto>productos;
	
	public Venta() {
		//super();
	}//Fin del constructor vacio
	
	public Venta(double importe, Date fecha) {
		//super();
		this.importe = importe;
		this.fecha = fecha;
	}
	
	public int getIdventa() {
		return idventa;
	}
	public void setIdventa(int idventa) {
		this.idventa = idventa;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}//Fin de la clase venta
