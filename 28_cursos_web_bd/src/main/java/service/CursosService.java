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
		//creamos arraylist auxiliar
		List<Curso> auxiliar=new ArrayList<>();
		EntityManager em=getEntityManager();
		String jpql="select c from Curso c";
		TypedQuery<Curso> qr=em.createQuery(jpql, Curso.class);
		List<Curso> cursos = qr.getResultList();
		//recorremos arraylist principal y cada curso con precio
		//igual o inferior al max será guardado en el auxiliar
		for(Curso c:cursos) {
			if(c.getPrecio()<=precioMax) {
				auxiliar.add(c);
			}
		}
		//devolvemos el arraylist auxiliar
		return auxiliar;
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
		EntityManager em=getEntityManager();
		Curso c=em.find(Curso.class, nombre);
		c.setDuracion(nuevaDuracion);
		em.merge(c);
	}
}
