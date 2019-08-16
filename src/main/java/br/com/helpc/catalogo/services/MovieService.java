package br.com.helpc.catalogo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.helpc.catalogo.domain.Movie;
import br.com.helpc.catalogo.dto.MovieDTO;
import br.com.helpc.catalogo.repositories.MovieRepository;
import br.com.helpc.catalogo.services.exceptions.DataIntegrityException;
import br.com.helpc.catalogo.services.exceptions.ObjectNotFoundException;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repo;
	
	public Movie find(Integer id) {
		Movie obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Movie.class.getName());
		}
		return obj;
	}

	public Movie findByName(String title) {
		Movie obj = repo.findByTitle(title);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Title: " + title
					+ ", Tipo: " + Movie.class.getName());
		}
		return obj;
	}
	
	public Movie insert(Movie obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Movie update(Movie obj) {
		Movie newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
	
	public List<Movie> findAll() {
		return repo.findAll();
	}
	
	public Page<Movie> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Movie fromDTO(MovieDTO objDto) {
		return new Movie(
				null,
				objDto.getOverview(),
				objDto.getPopularity(),
				objDto.getVote_count(),
				objDto.getVideo(),
				objDto.getPoster_path(),
				objDto.getAdult(),
				objDto.getBackdrop_path(),
				objDto.getOriginal_language(),
				objDto.getOriginal_title(),
				objDto.getTitle(),
				objDto.getVote_average(),
				objDto.getRelease_date());
	}

	private void updateData(Movie newObj, Movie obj) {
		newObj.setTitle(obj.getTitle());
	}
}
