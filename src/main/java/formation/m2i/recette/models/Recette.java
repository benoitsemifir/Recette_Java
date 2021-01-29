package formation.m2i.recette.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Recette {

	@Id
	private String id;
	private String titre;
	private String description;
	private List<Ingredient> ingredients;
	@DBRef
	private List<Categorie> categories;
}
