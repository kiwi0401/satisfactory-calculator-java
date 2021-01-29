package master;

import java.util.ArrayList;

public class item {

    private ArrayList<recipe> recipes = new ArrayList<>();
    private String name;

    public item(String name) {
        this.name = name;
    }

    public void addRecipe(String recipe) {
        recipes.add(new recipe(recipe));
    }

    public ArrayList<recipe> getRecipes() {
        return recipes;
    }


    public String getName() {
        return name;
    }

}
