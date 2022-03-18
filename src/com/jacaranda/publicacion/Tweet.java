package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Tweet extends Publicacion {

	
	
	
	public Tweet(String texto, Usuario usuario) {
		super(texto, usuario);

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
		if (valoracion.equals("SUPERBUENA") || valoracion.equals("MUYBUENA") || valoracion.equals("BUENA") || valoracion.equals("NORMAL") || valoracion.equals("REGULAR") || valoracion.equals("MUYMALA")) {
			this.valoracion=this.valoracion+Valoraciones.valueOf(valoracion).getValoracion()*2; //Este metodo cuenta el doble de puntos, por lo que se multiplica por 2 el valor de la valoracion
			resultado=true;
		}
		else {
			throw new PublicacionException("Introduce una valoracion válida");//Controla que la valoracion introducida es valida
		}
		
		return resultado;
		
		
	}
	public String toString() {
		StringBuilder resultado=new StringBuilder(); //Añade al StringBuilder los datos necesarios junto a los datos del padre
		resultado.append("Tweet."+"\n"+super.toString());
		return resultado.toString();
	}

	
}
