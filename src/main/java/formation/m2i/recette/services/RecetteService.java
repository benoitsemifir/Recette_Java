package formation.m2i.recette.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import formation.m2i.recette.models.Categorie;
import formation.m2i.recette.models.Ingredient;
import formation.m2i.recette.models.Recette;
import formation.m2i.recette.repositories.RecetteRepository;

@Service
public class RecetteService {

	@Autowired private RecetteRepository recetteRepository;
	
	public List<Recette> findAll(){
		return recetteRepository.findAll();
	}
	
	public Recette save(Recette recette) {
		return this.recetteRepository.save(recette);
	}
	
	public Recette update(String id, Recette recette) {
		Recette oldRecette = this.findById(id);
		recette.setId(oldRecette.getId());
		return this.recetteRepository.save(recette);
		
	}

	public Recette findById(String id) {
		return this.recetteRepository.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public void deleteById(String id) {
		this.recetteRepository.deleteById(id);
	}
	
	public List<Recette> findByTitre(String titre){
		return this.recetteRepository.findByTitre(titre);
	}

	public List<Recette> findByCategorie(Categorie categorie) {
		return this.recetteRepository.findByCategories(categorie);
	}

	
	public List<Recette> findByIngredient(String nomIngredient){
		Ingredient ingredient = new Ingredient();
		ingredient.setNom(nomIngredient);
		return this.recetteRepository.findByIngredients(ingredient);
	}
	
}
