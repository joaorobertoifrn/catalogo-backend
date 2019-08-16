package br.com.helpc.catalogo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.helpc.catalogo.domain.Genre;
import br.com.helpc.catalogo.dto.GenreDTO;
import br.com.helpc.catalogo.repositories.GenreRepository;
import br.com.helpc.catalogo.services.exceptions.DataIntegrityException;
import br.com.helpc.catalogo.services.exceptions.ObjectNotFoundException;

@Service
public class GenreService {
	
	@Autowired
	private GenreRepository repo;
	
	public Genre find(Integer id) {
		Genre obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Genre.class.getName());
		}
		return obj;
	}

	public Genre findByName(String name) {
		Genre obj = repo.findByName(name);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Name: " + name
					+ ", Tipo: " + Genre.class.getName());
		}
		return obj;
	}
	
	public Genre insert(Genre obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Genre update(Genre obj) {
		Genre newObj = find(obj.getId());
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
	
	public List<Genre> findAll() {
		return repo.findAll();
	}
	
	public Page<Genre> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Genre fromDTO(GenreDTO objDto) {
		return new Genre(objDto.getId(), objDto.getName());
	}

	private void updateData(Genre newObj, Genre obj) {
		newObj.setName(obj.getName());
	}
}
