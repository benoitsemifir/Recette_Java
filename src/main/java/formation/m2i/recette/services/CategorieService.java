package formation.m2i.recette.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.m2i.recette.models.Categorie;
import formation.m2i.recette.repositories.CategoryRepository;

@Service
public class CategorieService extends CrudService<Categorie>{
	@Autowired CategoryRepository repository;
	
	public Categorie findByNom(String categorieName) {
		
		return this.repository.findByNom(categorieName);
	}

	public Categorie update(String id, Categorie categorie) {
		Categorie oldCategorie = this.findById(id);
		categorie.setId(oldCategorie.getId());
		return this.repository.save(categorie);
	}
}
