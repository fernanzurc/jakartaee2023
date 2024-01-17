package service;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.Curso;
import model.Usuario;

public class UsuariosService {
	private EntityManager getEntityManager() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("cursosPU");
		return factory.createEntityManager();
	}
	
	public boolean autenticar(String usuario, String pwd) {
		String jpql="select u from Usuario u where u.usuario=?1 and u.password=?2";
		TypedQuery<Usuario> query=getEntityManager().createQuery(jpql,Usuario.class);
		query.setParameter(1, usuario);
		query.setParameter(2, pwd);
		
		return query.getResultList().size()>0;
	}
}
