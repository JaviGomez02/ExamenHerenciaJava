package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Recomendacion extends Publicacion {

	private int numeroEstrellas;
	
	
	public Recomendacion(String texto, Usuario usuario, int numeroEstrellas) throws PublicacionException {
		super(texto, usuario);
		if (texto.length()<100 || texto.length()>200) { //Controla el tamaño del texto
			throw new PublicacionException("Numero de caracteres incorrecto");
		}
		this.numeroEstrellas = numeroEstrellas;
	}

	

	@Override
	protected void setTexto(String texto) throws PublicacionException {

		if (texto.length()<100 || texto.length()>200) { //Controla el tamaño del texto
			throw new PublicacionException("Numero de caracteres incorrecto");
		}
		this.texto=texto;
		
	}

	public int getNumeroEstrellas() {
		return numeroEstrellas;
	}
	public String toString() {
		StringBuilder resultado=new StringBuilder(); //Añadimos los datos necesarios junto al toString de la clase padre
		resultado.append("Recomendación."+"\n"+super.toString()+"\n"+"Número de estrellas: "+this.getNumeroEstrellas());
		return resultado.toString();
	}

	
	
	
	
}
