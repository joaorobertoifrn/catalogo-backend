package br.com.helpc.catalogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.helpc.catalogo.domain.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	@Transactional(readOnly=true)
	Movie findById(Integer id);

	@Transactional(readOnly=true)
	Movie findByTitle(String title);
}
