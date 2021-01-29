package formation.m2i.recette.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import formation.m2i.recette.models.Categorie;
import formation.m2i.recette.models.Ingredient;
import formation.m2i.recette.models.Recette;

public interface RecetteRepository extends MongoRepository<Recette, String>{

	List<Recette> findByTitre(String titre);
	
	List<Recette> findByCategories(Categorie categorie);
	
	List<Recette> findByIngredients(Ingredient ingredient);

}
