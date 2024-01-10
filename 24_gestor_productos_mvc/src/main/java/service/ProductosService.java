package service;

import java.util.ArrayList;
import java.util.List;

import model.Producto;

public class ProductosService {
	private static List<Producto> productos=new ArrayList<>();
	public void agregarProducto(String nombre, double precio, String categoria) {
		productos.add(new Producto(nombre,precio,categoria));
	}
	public List<Producto> buscarPorCategoria(String categoria){
		return productos.stream()
				.filter(p->p.getCategoria().equals(categoria))
				.toList();
		
		/*List<Producto> aux=new ArrayList<Producto>();
		for(Producto p:productos) {
			if(p.getCategoria().equals(categoria)) {
				aux.add(p);
			}
		}
		return aux;*/
	}
	public void eliminarProducto(String nombre) {
		productos.removeIf(p->p.getNombre().equals(nombre));
	}
}
