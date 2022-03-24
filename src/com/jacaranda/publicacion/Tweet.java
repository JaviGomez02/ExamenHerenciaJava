package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Tweet extends Publicacion {

	
	
	
	public Tweet(String texto, Usuario usuario) throws PublicacionException {
		super(texto, usuario);
		if (texto.length()>50) { //Controla el tamaño del texto
			throw new PublicacionException("El texto solo puede tener 50 caracteres");
		}

	}

	@Override
	protected void setTexto(String texto) throws PublicacionException {
		if (texto.length()>50) { //Controla el tamaño del texto
			throw new PublicacionException("El texto solo puede tener 50 caracteres");
		}
		this.texto=texto;

	}
	public boolean valorar(String valoracion) throws PublicacionException {
		boolean resultado=false;
		try {
			super.valorar(valoracion);
			this.valoracion=this.getValoracion()*2;
			resultado=true;
		} catch (Exception e) {
			throw new PublicacionException("Introduce el valor correcto");
			
		}
		return resultado;
	}
		
		
	public String toString() {
		StringBuilder resultado=new StringBuilder(); //Añade al StringBuilder los datos necesarios junto a los datos del padre
		resultado.append("Tweet."+"\n"+super.toString());
		return resultado.toString();
	}

	
}
