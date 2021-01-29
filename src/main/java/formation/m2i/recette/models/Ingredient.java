package formation.m2i.recette.models;
import lombok.Data;

@Data
public class Ingredient {
	
	private String nom;
	private String unite;
	private double quantite;
}
