package br.com.helpc.catalogo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GerarSenha {

	public static void main(String[] args) {
		
		
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		
		System.out.println(pe.encode("123"));
		

	}

}
