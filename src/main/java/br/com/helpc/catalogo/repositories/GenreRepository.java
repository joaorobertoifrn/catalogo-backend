package br.com.helpc.catalogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.helpc.catalogo.domain.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
	
	@Transactional(readOnly=true)
	Genre findByName(String name);
	
}
