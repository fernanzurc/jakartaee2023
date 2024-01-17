package service;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.Curso;
import model.Usuario;

public class CursosService{
	private EntityManager getEntityManager() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("cursosPU");
		return factory.createEntityManager();
	}
	
	//modificar este método para que añada el curso si no hay otro
	//con el mismo nombre, si ya existe no se añade y se devuelve false
	public boolean nuevo(String nombre, int duracion, double precio) {	
		Curso curso=new Curso(0,nombre,duracion,precio);
		EntityManager em=getEntityManager();
		String jpql="select c from Curso c";
		TypedQuery<Curso> qr=em.createQuery(jpql, Curso.class);
		List<Curso> cursos = qr.getResultList();
		for(Curso c:cursos) {
			if(c.getNombre().equals(nombre)) {
				return false;
			}
		}
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(curso);
		tx.commit();
		return true;
		
	}
	
	public List<Curso> preciosCursoMax(double precioMax){
		String jpql="select c from Curso c where c.precio<=?1";
		TypedQuery<Curso> query=getEntityManager().createQuery(jpql,Curso.class);
		query.setParameter(1, precioMax);
		return query.getResultList();
	}
	
	public void eliminarCurso(String nombre) {
		String jpql="delete from Curso p where p.nombre=?1";
		EntityManager em=getEntityManager();
		Query query=em.createQuery(jpql);
		query.setParameter(1, nombre);
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		query.executeUpdate();
		tx.commit();
		
	}
	
	public void modificarDuracion(String nombre, int nuevaDuracion) {
		String jpql="update Curso c set c.duracion=?1 where c.nombre=?2";
		EntityManager em=getEntityManager();
		Query query=em.createQuery(jpql);
		query.setParameter(1, nuevaDuracion);
		query.setParameter(2, nombre);
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		query.executeUpdate();
		tx.commit();
	}
}
