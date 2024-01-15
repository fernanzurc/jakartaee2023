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
		/*
		Usuario user = getEntityManager().find(Usuario.class, usuario);
		if(user!=null&&user.getUsuario().equals(usuario)&&user.getPassword().equals(pwd)) {
			return true;
		}
		return false;
		*/
		EntityManager em=getEntityManager();
		String jpql="select u from Usuario u where u.usuario=?1 and u.password=?2";
		TypedQuery<Usuario> tq=em.createQuery(jpql, Usuario.class);
		tq.setParameter(1, usuario);
		tq.setParameter(2, pwd);
		List<Usuario> usuarios=tq.getResultList();
		if(usuarios!=null&&usuarios.size()>0) {
			return true;
		}
		return false;
		
		/*return usuarios.stream()
				.anyMatch(u->u.getUsuario().equals(usuario)&&u.getPassword().equals(pwd));*/
	}
}
