package br.com.helpc.catalogo.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.helpc.catalogo.domain.Genre;
import br.com.helpc.catalogo.domain.Usuario;
import br.com.helpc.catalogo.domain.enums.Perfil;
import br.com.helpc.catalogo.repositories.GenreRepository;
import br.com.helpc.catalogo.repositories.UsuarioRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private UsuarioRepository clienteRepository;
	
	@Autowired
	private GenreRepository genreRepository;

	public void instantiateTestDatabase() throws ParseException {

		Usuario usuario1 = new Usuario(null, "João Roberto", "joao_roberto@msn.com", pe.encode("123"));
		usuario1.addPerfil(Perfil.ADMIN);
		
		Usuario usuario2 = new Usuario(null, "Rodrigo", "rodrigo@gmail.com", pe.encode("456"));
		usuario2.addPerfil(Perfil.ADMIN);

		Usuario usuario3 = new Usuario(null, "Marcus", "marcus@gmail.com", pe.encode("789"));
		usuario3.addPerfil(Perfil.ADMIN);
		
		Usuario usuario4 = new Usuario(null, "Usuario Padrão", "user@gmail.com", pe.encode("222"));
		usuario4.addPerfil(Perfil.USUARIO);
		
		clienteRepository.save(Arrays.asList(usuario1, usuario2, usuario3, usuario4));
		
		Genre genre1 = new Genre(28, "Ação");
		Genre genre2 = new Genre(12, "Aventura");
		Genre genre3 = new Genre(16, "Animação");
		Genre genre4 = new Genre(35, "Comédia");
		Genre genre5 = new Genre(80, "Crime");
		Genre genre6 = new Genre(99, "Documentário");
		Genre genre7 = new Genre(18, "Drama");
		Genre genre8 = new Genre(10751, "Família");
		Genre genre9 = new Genre(14, "Fantasia");
		Genre genre10 = new Genre(36, "História");
		Genre genre11 = new Genre(27, "Terror");
		Genre genre12 = new Genre(10402, "Música");
		Genre genre13 = new Genre(9648, "Mistério");
		Genre genre14 = new Genre(10749, "Romance");
		Genre genre15 = new Genre(878, "Ficção científica");
		Genre genre16 = new Genre(53, "Cinema TV");
		Genre genre17 = new Genre(10770, "Thriller");
		Genre genre18 = new Genre(10752, "Guerra");
		Genre genre19 = new Genre(37, "Faroeste");
		
		genreRepository.save(Arrays.asList(genre1,genre2,genre3,genre4,genre5,genre6,genre7,genre8,genre9,genre10,genre11,genre12,genre13,genre14,genre15,genre16,genre17,genre18,genre19));
		
	}
}
