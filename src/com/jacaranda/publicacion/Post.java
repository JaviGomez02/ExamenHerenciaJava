package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Post extends Publicacion {

	private int numeroLecturas;
	private String tema;
	
	
	public Post(String texto, Usuario usuario, String tema) throws PublicacionException {
		super(texto, usuario);
		if (texto.equals("")) { //Controla que el texto no esté vaciío
			throw new PublicacionException("El Post no puede estar vacío");
		}
		this.tema = tema;
		this.numeroLecturas=0;
		
	}


	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if (texto.equals("")) { //Controla que el texto no esté vaciío
			throw new PublicacionException("El Post no puede estar vacío");
		}
		this.texto=texto;

	}
	public boolean valorar(String valoracion) throws PublicacionException {
		boolean resultado=false;
		try {
			this.valoracion=this.valoracion+Valoraciones.valueOf(valoracion).getValoracion();
			resultado=true;
			this.numeroLecturas++;
		} catch (Exception e) {
			throw new PublicacionException("Introduce el valor correcto");

		}
		
		return resultado;
		
		
	}
	public String toString() {
		StringBuilder resultado=new StringBuilder(); //Añadimos los datos necesarios junto con el StringBuilder de la clase Publicacion
		resultado.append("Post."+"\n"+super.toString());
		return resultado.toString();
	}

}
