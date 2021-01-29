package formation.m2i.recette.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import formation.m2i.recette.models.Categorie;
import formation.m2i.recette.services.CategorieService;

@RestController
@RequestMapping("categories")
public class CategorieController {

	
	private CategorieService service;
	
	public CategorieController(CategorieService service) {
		this.service = service;
	}

	@GetMapping("")
	public List<Categorie> getCategorie() {
		return this.service.findAll();
	}
	
	@GetMapping("{id}")
	public Categorie findById(@PathVariable String id) {
		return this.service.findById(id);
	}

	@PostMapping("")
	public Categorie postCategorie(@RequestBody Categorie categorie) {
		return this.service.save(categorie);
	}
	
	@PutMapping("{id}")
	public Categorie putCategorie(@PathVariable String id, @RequestBody Categorie categorie) {
		return this.service.update(id, categorie );
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void deleteCategorie(@PathVariable String id) {
		this.service.deleteById(id);
	}
	
}
