package formation.m2i.recette.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import formation.m2i.recette.models.Recette;
import formation.m2i.recette.services.CategorieService;
import formation.m2i.recette.services.RecetteService;

@RestController
@RequestMapping("recettes")
public class RecetteController {

	@Autowired private RecetteService recetteService;
	@Autowired private CategorieService categorieService;

	@GetMapping("")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Recette> getRecette() {
		return this.recetteService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Recette findById(@PathVariable String id) {
		return this.recetteService.findById(id);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Recette postRecette(@RequestBody Recette recette) {
		
		return this.recetteService.save(recette);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Recette putRecette(@PathVariable String id, @RequestBody Recette recette) {
		return this.recetteService.save(recette);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteRecette(@PathVariable String id) {
		this.recetteService.deleteById(id);
	}
	
	@GetMapping("/titre/{titre}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Recette> findByTitre(@PathVariable String titre){
		return this.recetteService.findByTitre(titre);
	}
	
	@GetMapping("/categorie/{categorieId}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Recette> findByCategorie(@PathVariable String categorieId){
		Categorie categorie = this.categorieService.findById(categorieId);
		return this.recetteService.findByCategorie(categorie);
	}
	
	@GetMapping("/ingredients/{ingredientNom}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Recette> findByIngredient(@PathVariable String ingredientNom){
		return this.recetteService.findByIngredient(ingredientNom);
	}

}
