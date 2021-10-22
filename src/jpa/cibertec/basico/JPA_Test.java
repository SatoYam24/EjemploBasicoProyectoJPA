package jpa.cibertec.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPA_Test {
	private EntityManager manager;

public JPA_Test(EntityManager manager) {
	super();
	this.manager = manager;
}
	public static void main(String[] arg) {
	//comenzamos a testear los respectivos metodos...
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("jpa_2021_cibertec_III");
		EntityManager manager=factory.createEntityManager();
		//instanciamos la misma clase
		JPA_Test jpatest=new JPA_Test(manager);
		EntityTransaction tx=manager.getTransaction();
		//iniciamos la transaccion
		tx.begin();
		//llamamos al metodo crear empleado...
		jpatest.CrearEmpleado();
		//llamamos al metodo listar empleado...
		//declaramos uuna variable de tipo list empleado...
		List<Empleado> verlistado=jpatest.MostrarEmpleados();
		//creamos un buclle para realizar la respectiva impresion de los empleados...
		System.out.println("****************Listado de empleados con JPQL**********");
		for(Empleado emp:verlistado) {
			//imprimimos por pantalla con system...
			System.out.println("Nombre:"+emp.getNombre()+"Apellido:"+emp.getApellido()+"Sexo:"+emp.getSexo()+
					"Dni:"+emp.getDni()+"Email:"+emp.getEmail()+"Telefono:"+emp.getTel()+"Sueldo:"+emp.getSueldo());
		}//Fin del bucle for...
		//****************************** llamamos al metodo dentro del metodo principal(main)
		jpatest.ActualizarEmpleado(4,"Abby", "Gonzales", "F", "104055897", "abby@hotmail.com","3614950",3500,4);
		//****************************** llamamos al metodo eliminar
		jpatest.EliminarEmpleado(4);
		
	} //fin del metodo principal

	//Crear un metodo 
	public void CrearEmpleado() {
		Departamento departamento=new Departamento("Administracion","parte fundamental de la empresa");
		Departamento departamento2=new Departamento("Sistemas","parte tecnologica de la empresa");
		Departamento departamento3=new Departamento("Contabilidad","parte de la sunat con la empresa");
		Departamento departamento4=new Departamento("Almacen","parte logistica de la empresa");
		//El metodo persis permite almacenar valores en la BD mysql...
		manager.persist(departamento);
		manager.persist(departamento2);
		manager.persist(departamento3);
		manager.persist(departamento4);
		//instanciar la clase empleado
		Empleado empleado=new Empleado("Miguel","Perez","M","10516516","miguel@hotmail.com","987654321",1600,departamento);
		Empleado empleado2=new Empleado("Juan","Rodriguez","M","10516524","juan@hotmail.com","987654387",5000,departamento2);
		Empleado empleado3=new Empleado("Maria","Quispe","F","105165131","maria@hotmail.com","987654354",1000,departamento3);
		Empleado empleado4=new Empleado("Ana","Paredes","F","10516517","ana@hotmail.com","987654312",2000,departamento4);
		//seguimos con la persistencia
		manager.persist(empleado);
		manager.persist(empleado2);
		manager.persist(empleado3);
		manager.persist(empleado4);
		
	} //fin del metodo crear empleado
	
	//+++++++++++++++++++++++++ consultas dinámicas JPQL ++++++++++++++++++++++++++++//
	
	//creeamos un metodo para listar empleados.....
	
	public List<Empleado> MostrarEmpleados(){
		//decllaramos una variable de tipo cadena
		String consulta="select e from Empleado e";
		//Aplicamos la interfaz query..
		Query listado=manager.createQuery(consulta,Empleado.class);
		//almacenando los respecttivos valores en la variable listadoempleado
		List<Empleado> listadoempleado=listado.getResultList();
		
		//Retornamos listado de empleados
		return listadoempleado;
	}//Fin del metodo listarempleados
	
	public List<Empleado> BuscarEmpleado(int cod) {
		//declaramos una variable de tipo cadena......
		//parametros dinamicos por nombres.....sintaxis :nombre
		String buscar="select e from Empleado e where e.idempleado=:codigo";
		//aplicamos la interfaz query
		Query buscarempl=manager.createQuery(buscar,Empleado.class).setParameter("codigo", cod);
		//Declaramos una variable de tipo empleado
		List<Empleado> mostrarempl=buscarempl.getResultList();;
		//retrnonamos el valor buscado
		return mostrarempl;
	}//Fin del metodo buscar por empleado
	
	
	//Crear metodo actualizar empleado...
	public void ActualizarEmpleado(int cod, String nom, String ape, String sex, String dn, 
		String em, String tel, double suel, int coddepart) {
		//declaramos una variable de tipo cadena
		String cadena="UPDATE Empleado e SET e.nombre=:nom,e.apellido=:ape,"
		+"sexo=:sex,dni=:dn,email=:em,telefono=:tel,"
		+"sueldo=:suel,e.departamento.iddepartamento=:coddepart where e.idempleado=:cod";
		//Aplicacmos la interfaz query
		Query cons=manager.createQuery(cadena);
		//Creamos los parametros dinamicos por nombre
		cons.setParameter("cod", cod);
		cons.setParameter("nom", nom);
		cons.setParameter("ape", ape);
		cons.setParameter("sex", sex);
		cons.setParameter("dn", dn);
		cons.setParameter("em", em);
		cons.setParameter("tel", tel);
		cons.setParameter("suel", suel);
		cons.setParameter("coddepart", coddepart);
		int num=cons.executeUpdate();
		if(num>0) {
			System.out.println("Empleado actualizado con JPQL");
		}else {
			System.out.println("Empleado NO actualizado");
		}

	}//Fin del metodo actualizar empleado
	
	
	//Creamos el metodo eliminar
	public void EliminarEmpleado(int cod) {
		//declaramos una variable de tipoo cadena
		String cadena ="delete from Empleado e where e.idempleado=:cod";
		//Aplicamos la interfaz query
		Query eliminarempl=manager.createQuery(cadena);
		//asignamos parametros
		eliminarempl.setParameter("cod",cod);
		//ejecutamos las instrucciones
		int n = eliminarempl.executeUpdate();
		if(n>0) {
			System.out.println("Empleado eliminado de la BD");
		}else {
			System.out.println("No se puede eliminar el empleado de la bd");
		}

	}//fin del metodo eliminar empleado
}//Fin de la clase test
