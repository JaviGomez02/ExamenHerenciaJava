package com.jacaranda.main;

import com.jacaranda.memorystorage.MemoryStorage;
import com.jacaranda.memorystorage.MemoryStorageException;
import com.jacaranda.publicacion.Post;
import com.jacaranda.publicacion.PublicacionException;
import com.jacaranda.publicacion.Recomendacion;
import com.jacaranda.publicacion.Tweet;
import com.jacaranda.usuario.Usuario;

public class Main {

	public static void main(String[] args) throws PublicacionException, MemoryStorageException {

		
		Usuario u1=new Usuario("Yo","hola");
		System.out.println(u1.setPass("hola", "a"));
		System.out.println(u1.getLogin());
		
		
		Recomendacion r1=new Recomendacion("Hola",u1,4);
		System.out.println(r1.toString());
		r1.valorar("MUYBUENA");
		System.out.println(r1.toString());
		
		Tweet t1=new Tweet("Que tal",u1);
		t1.valorar("BUENA");
		t1.valorar("MUYMALA");
		System.out.println(t1.toString());
		
		Post p1=new Post("Eyy",u1,"Actualidad");
		p1.valorar("REGULAR");
		
		System.out.println(p1.toString());
		
		
		MemoryStorage m1=new MemoryStorage();
		m1.addUsuario("Javi", "yepa");
		m1.addPublicacion("holaaaa que taaaaaaaaal", "Javi");
		m1.addPublicacion("yoyoiyoiytoyoyoiyoiytoyoyoiyoiytoyoyoiyoiytoyoyoiyoiytoyoyoiyoiytoyoyoiyoiytoyoyoiyoiytoyoyoiyoiytoyoyoiyoiytoyoyoiyoiytoyoyoiyoiytoyoyoiyoiytoyoyoiyoiytoyoyoiyoiyto", "Javi", 12);
		m1.addPublicacion("eionjonfowodnfdoaijfiefioandfodjasoineoinaofnodsfjeoiejso", "Javi", "Hola");
		m1.addPublicacion("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "Javi", "Adios");
		m1.addPublicacion("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "Javi", 23);
		System.out.println(m1.mostrarListaPublicaciones());
		System.out.println(m1.mostrarTweets());
		System.out.println("____________________________________________________________________");
		System.out.println(m1.mostrarPosts());
		System.out.println("____________________________________________________________________");
		System.out.println(m1.mostrarRecomendacion());
		


	}

}
