package br.com.helpc.catalogo.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.helpc.catalogo.domain.Usuario;
import br.com.helpc.catalogo.domain.enums.Perfil;
import br.com.helpc.catalogo.repositories.UsuarioRepository;

@Service
public class DBService {
	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private UsuarioRepository clienteRepository;
	
	public void instantiateTestDatabase() throws ParseException {

		Usuario usuario1 = new Usuario(null, "João Roberto", "joao_roberto@msn.com", pe.encode("123"));
		usuario1.addPerfil(Perfil.ADMIN);
		
		Usuario usuario2 = new Usuario(null, "Rodrigo", "rodrigo@gmail.com", pe.encode("456"));
		usuario2.addPerfil(Perfil.ADMIN);

		Usuario usuario3 = new Usuario(null, "Marcus", "marcus@gmail.com", pe.encode("789"));
		usuario3.addPerfil(Perfil.ADMIN);
		
		clienteRepository.save(Arrays.asList(usuario1, usuario2, usuario3));
		
	}
}
