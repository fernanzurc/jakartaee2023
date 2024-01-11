package service;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.Producto;

public class ProductosService {
	private EntityManager getEntityManager() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("productosPU");
		return factory.createEntityManager();
	}	
	public void agregarProducto(String nombre, String categoria, double precio) {
		//se le pone el valor 0 al idProducto pero se podría haber puesto cualquier otro valor
		//ya que el motor de peristencia no lo va a utilizar a la hora
		//de hacer el insert
		Producto pr=new Producto(0, nombre, categoria, precio);
		EntityManager em=getEntityManager();
		//definimos la operación de acción dentro de una transacción
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(pr);
		tx.commit();
	}
	
	public Producto buscarProducto(int idProducto) {
		return getEntityManager().find(Producto.class, idProducto);
	}
	public void eliminarProducto(int idProducto) {
		//buscamos el producto que queremos eliminar y si existe lo eliminamos
		Producto pr=buscarProducto(idProducto);
		if(pr!=null) {
			EntityManager em=getEntityManager();
			EntityTransaction tx=em.getTransaction();
			tx.begin();
			em.remove(pr);
			tx.commit();
			
		}
	}
	
	public List<Producto> buscarPorCategoria(String categoria){
		//consulta sin parámetro
		//String jpql="select p from Producto p where p.categoria='"+categoria+"'";
		//consultas parametrizadas por posición
		String jpql="select p from Producto p where p.categoria=?1";
		//consultas parametrizadas por nombre
		//String jpql="select p from Producto p where p.categoria=:cat";
		
		TypedQuery<Producto> query=getEntityManager().createQuery(jpql, Producto.class);
		//sustituimos parámetros por valores
		query.setParameter(1, categoria);
		
		//para sutituir por nombre
		//query.setParameter("cat", categoria);
		//devuelve lista de resultados
		return query.getResultList();
	}
	
	public void eliminarPorNombre(String nombre) {
		String jpql="delete from Producto p where p.nombre=?1";
		EntityManager em=getEntityManager();
		Query query=em.createQuery(jpql);
		query.setParameter(1, nombre);
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		query.executeUpdate();
		tx.commit();
	}

}
