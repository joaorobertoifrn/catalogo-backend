package br.com.helpc.catalogo.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.helpc.catalogo.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
