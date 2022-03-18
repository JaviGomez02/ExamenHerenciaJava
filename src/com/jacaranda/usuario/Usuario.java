package com.jacaranda.usuario;

import java.util.Objects;

public class Usuario {

	private String login;
	private String pass;
	
	
	public Usuario(String login, String pass) {
		super();
		this.login = login;
		this.pass = pass;
	}


	public String getLogin() {
		return login;
	}
	public boolean setPass(String passAntigua, String passNueva) { 
		boolean resultado=false;
		if (passAntigua.equals(this.pass)) { //Si la contraseña introducida coincida con la antigua, se cambia la contraseña
			resultado=true;
			this.pass=passNueva;
		}
		
		return resultado;
	}
	
	public boolean checkPass(String pass) {
		boolean resultado=false;
		if (pass.equals(this.pass)) { //Comprueba que la contraseña introducida coincide con la nuestra contraseña 
			resultado=true;
		}
		
		return resultado;
	}


	@Override
	public int hashCode() {
		return Objects.hash(login);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(login, other.login);
	}
	
	
	
}
