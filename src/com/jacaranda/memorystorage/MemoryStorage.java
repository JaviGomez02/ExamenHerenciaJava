package com.jacaranda.memorystorage;


import com.jacaranda.publicacion.Post;
import com.jacaranda.publicacion.Publicacion;
import com.jacaranda.publicacion.PublicacionException;
import com.jacaranda.publicacion.Recomendacion;
import com.jacaranda.publicacion.Tweet;
import com.jacaranda.usuario.Usuario;

public class MemoryStorage {

	private static final int NUM_MAXIMO_USUARIOS=15;
	private static final int NUM_MAXIMO_MENSAJES=50;
	private int numUsuariosActuales;
	private int numPublicacionesActuales;
	private Publicacion[] publicaciones;
	private Usuario[] usuarios;
	public MemoryStorage() {
		super();
		this.numUsuariosActuales=0;
		this.numPublicacionesActuales=0;
		this.publicaciones=new Publicacion[NUM_MAXIMO_MENSAJES];
		this.usuarios=new Usuario[NUM_MAXIMO_USUARIOS];
	}
	
	private int posicionUsuario(String texto) {
		int posicion=-1;
		boolean encontrado=false;
		for (int i = 0; i < this.numUsuariosActuales && encontrado==false; i++) {
			if (usuarios[i].getLogin().equals(texto)) { //Si encuentra un usuario con el mismo login, devuelve true
				posicion=i; 
				encontrado=true;
			}
		}
		return posicion;
			
	}
	public void addUsuario(String login, String contrasena) throws MemoryStorageException { //Añade un usuario e incrementa el numero de usuarios
		if (this.numUsuariosActuales==this.NUM_MAXIMO_USUARIOS) {
			throw new MemoryStorageException("No queda espacio para añadir más usuarios");
		}
		this.usuarios[this.numUsuariosActuales]=new Usuario(login,contrasena);
		this.numUsuariosActuales++;
	}
	
	public void addPublicacion(String texto, String login) throws MemoryStorageException, PublicacionException {
		if (this.numPublicacionesActuales==this.NUM_MAXIMO_MENSAJES) {
			throw new MemoryStorageException("No queda espacio para añadir más publicaciones");
		}
		if (posicionUsuario(login)>=0) {
			publicaciones[this.numPublicacionesActuales]=new Tweet(texto,usuarios[posicionUsuario(login)]); //Si el usuario existe, se crea la publicacion y se mete en el array
			this.numPublicacionesActuales++;
		}
		else {
			throw new MemoryStorageException("Usuario no encontrado");
		}
		
	}
	public void addPublicacion(String texto, String login, String tema) throws MemoryStorageException, PublicacionException {
		if (this.numPublicacionesActuales==this.NUM_MAXIMO_MENSAJES) {
			throw new MemoryStorageException("No queda espacio para añadir más publicaciones");
		}
		if (posicionUsuario(login)>=0) {
			publicaciones[this.numPublicacionesActuales]=new Post(texto,usuarios[posicionUsuario(login)],tema); //Si el usuario existe, se crea la publicacion y se mete en el array
			this.numPublicacionesActuales++;
		}
		else {
			throw new MemoryStorageException("Usuario no encontrado");
		}
		
	}
	public void addPublicacion(String texto, String login, int estrellas) throws MemoryStorageException, PublicacionException {
		if (this.numPublicacionesActuales==this.NUM_MAXIMO_MENSAJES) {
			throw new MemoryStorageException("No queda espacio para añadir más publicaciones");
		}
		if (posicionUsuario(login)>=0) {
			publicaciones[this.numPublicacionesActuales]=new Recomendacion(texto,usuarios[posicionUsuario(login)],estrellas); //Si el usuario existe, se crea la publicacion y se mete en el array
			this.numPublicacionesActuales++;
		}
		else {
			throw new MemoryStorageException("Usuario no encontrado");
		}
		
	}
	
	public String mostrarListaPublicaciones() {
		StringBuilder resultado=new StringBuilder(); //Creamos un StringBuilder para añadir los datos
		for (int i = 0; i < this.numPublicacionesActuales; i++) { //Vamos añadiendo todos los elementos del array al stringbuilder
			resultado.append(publicaciones[i].toString()+"\n"+"\n");
		}
		return resultado.toString();
		
	}
	public String mostrarTweets() {
		StringBuilder resultado=new StringBuilder();
		for (int i = 0; i < this.numPublicacionesActuales; i++) {
			if (publicaciones[i] instanceof Tweet) { //Solo añadimos en el StringBuilder los elementos que son instancias de la clase Tweet
				resultado.append(publicaciones[i].toString()+"\n"+"\n");
			}
		}
		return resultado.toString();
		
	}
	public String mostrarPosts() {
		StringBuilder resultado=new StringBuilder();
		for (int i = 0; i < this.numPublicacionesActuales; i++) {
			if (publicaciones[i] instanceof Post) { //Añadimos en el array los elementos que son instancias de Post
			resultado.append(publicaciones[i].toString()+"\n"+"\n");
			}
		}
		return resultado.toString();
		
	}
	public String mostrarRecomendacion() {
		StringBuilder resultado=new StringBuilder();
		for (int i = 0; i < this.numPublicacionesActuales; i++) {
			if (publicaciones[i] instanceof Recomendacion) { ////Añadimos en el array los elementos que son instancias de Recomendacion
				resultado.append(publicaciones[i].toString()+"\n"+"\n");
			}
		}
		return resultado.toString();
		
	}
	
	
	
}
