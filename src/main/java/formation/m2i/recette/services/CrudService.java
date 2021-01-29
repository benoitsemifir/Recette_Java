package formation.m2i.recette.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CrudService<T> {
	
	@Autowired
	protected MongoRepository<T, String> repository;

	public List<T> findAll(){
		return this.repository.findAll(); 
	}
	
	public T save(T elem) {
		return this.repository.save(elem);
	}

	public void deleteById(String id) {
		this.repository.deleteById(id);
		
	}

	public T findById(String id) {
		return this.repository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
