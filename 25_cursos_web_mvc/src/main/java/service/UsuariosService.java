package service;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuariosService {
	List<Usuario> usuarios=new ArrayList<>(List.of(
			new Usuario("user1","pwd1"),
			new Usuario("user2","pwd2"),
			new Usuario("user3","pwd3"),
			new Usuario("user4","pwd4")
			));
	
	public boolean autenticar(String usuario, String pwd) {
		for(Usuario u:usuarios) {
			if(u.getUsuario().equals(usuario)&&u.getPassword().equals(pwd)) {
				return true;
			}
		}
		return false;
		
		/*return usuarios.stream()
				.anyMatch(u->u.getUsuario().equals(usuario)&&u.getPassword().equals(pwd));*/
	}
}
