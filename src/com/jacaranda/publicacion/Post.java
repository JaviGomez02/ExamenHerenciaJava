package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Post extends Publicacion {

	private int numeroLecturas;
	private String tema;
	
	
	public Post(String texto, Usuario usuario, String tema) {
		super(texto, usuario);
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
		if (valoracion.equals("SUPERBUENA") || valoracion.equals("MUYBUENA") || valoracion.equals("BUENA") || valoracion.equals("NORMAL") || valoracion.equals("REGULAR") || valoracion.equals("MUYMALA")) {
			this.valoracion=this.valoracion+Valoraciones.valueOf(valoracion).getValoracion();
			resultado=true;
		}
		else {
			throw new PublicacionException("Introduce una valoracion válida");
		}
		this.numeroLecturas++; //Cada vez que se valore un post se incrementa el numero de lecturas
		
		return resultado;
		
		
	}
	public String toString() {
		StringBuilder resultado=new StringBuilder(); //Añadimos los datos necesarios junto con el StringBuilder de la clase Publicacion
		resultado.append("Post."+"\n"+super.toString());
		return resultado.toString();
	}

}
