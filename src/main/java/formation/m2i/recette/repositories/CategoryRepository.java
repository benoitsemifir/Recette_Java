package formation.m2i.recette.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import formation.m2i.recette.models.Categorie;

public interface CategoryRepository extends MongoRepository<Categorie, String>{

	Categorie findByNom(String categorieName);

}
