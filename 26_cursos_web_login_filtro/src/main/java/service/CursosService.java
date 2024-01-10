package service;

import java.util.ArrayList;

import model.Curso;

public class CursosService{
	//para que el arraylist no se pierda y todas las intancias
	//lo compartan
	private static ArrayList<Curso> cursos=new ArrayList<>();
	
	//modificar este método para que añada el curso si no hay otro
	//con el mismo nombre, si ya existe no se añade y se devuelve false
	public boolean nuevo(String nombre, int duracion, double precio) {		
		Curso curso=new Curso(nombre,duracion,precio);
		for(Curso c:cursos) {
			if(c.getNombre().equals(nombre)) {
				return false;
			}
		}
		cursos.add(curso);
		return true;
		
	}
	
	public ArrayList<Curso> preciosCursoMax(double precioMax){
		//creamos arraylist auxiliar
		ArrayList<Curso> auxiliar=new ArrayList<>();
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
		/*for(int i=0;i<cursos.size();i++) {
			if(cursos.get(i).getNombre().equals(nombre)) {
				cursos.remove(i);
				break; //nos salimos para no seguir recorriendo
			}
		}*/
		cursos.removeIf(c->c.getNombre().equals(nombre));
		
	}
	
	public void modificarDuracion(String nombre, int nuevaDuracion) {
		for(Curso c:cursos) {
			if(c.getNombre().equals(nombre)) {
				c.setDuracion(nuevaDuracion);
				break;
			}
		}
	}
}
