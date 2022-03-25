package com.jacaranda.publicacion;

import java.time.LocalDateTime;
import java.util.Objects;

import com.jacaranda.usuario.Usuario;

public abstract class Publicacion implements Valorable{

	protected String texto;
	private LocalDateTime fechaCreacion;
	protected int valoracion;
	private int codigo=0;
	private static int codigoSiguiente=1;
	protected Usuario usuario;
	
	public Publicacion(String texto, Usuario usuario) throws PublicacionException {
		super();
		this.setTexto(texto);
		this.usuario = usuario;
		this.codigo=codigoSiguiente++;
		this.valoracion=0;
		this.fechaCreacion=LocalDateTime.now();
				
	}

	protected String getTexto() {
		return this.texto;
	}
	

	protected abstract void setTexto(String texto) throws PublicacionException;

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public int getValoracion() {
		return valoracion;
	}

	public int getCodigo() {
		return codigo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaCreacion, texto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicacion other = (Publicacion) obj;
		return Objects.equals(fechaCreacion, other.fechaCreacion) && Objects.equals(texto, other.texto);
	}
	
	public String getLoginUsuario() {
		return this.usuario.getLogin();
	}
	public boolean valorar(String valoracion) throws PublicacionException {
		boolean resultado=false; 
		try {
			this.valoracion=this.valoracion+Valoraciones.valueOf(valoracion).getValoracion(); //Recibe el valor del enumerado correspondiente y se lo suma a valoraciones
			resultado=true;
		} catch (Exception e) {
			throw new PublicacionException("Introduce una valoracion válida");
		}
		
		return resultado;
	}

	@Override
	public String toString() {
		StringBuilder resultado=new StringBuilder();
		resultado.append("Publicación: "+this.getTexto()+"\n"+"Realizada por: "+this.getLoginUsuario()+"\n"+"Valoración: "+this.getValoracion()+"\n"+"Fecha de publicacion: "+this.getFechaCreacion());
		return resultado.toString();
	}
	
	public boolean isAnterior(Publicacion p) {
		boolean resultado=false; //Devuelve true si la fecha de nuestra publicacion es anterior a la fecha de la publicacion introducida como argumento
		if (this.getFechaCreacion().isBefore(p.getFechaCreacion())) {
			resultado=true;
		}
		return resultado;
		
	}
	public int compareTo(Publicacion p) { //Comparamos primero por la valoracion, y si son iguales comparamos por la fecha
		int resultado=this.getValoracion()-p.getValoracion();
		if (resultado==0) {
			resultado=this.getFechaCreacion().compareTo(p.getFechaCreacion());
		}
		return resultado;
		
		
		
	}
	
	
}
