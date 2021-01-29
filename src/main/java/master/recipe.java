package master;

import java.util.HashMap;

public class recipe {

    private HashMap<String, Double> Output = new HashMap<>();
    private HashMap<String, Double> Ingredients = new HashMap<>();
    private String recipeName;
    private String recipeType;

    public recipe(String recipe) {
        String[] components = recipe.split(",");
        StringBuilder sb = new StringBuilder();
        recipeType = "Default";
        if(components.length == 4) {
            sb.append(" Alternate: ");
            sb.append(components[3].split(":")[1].trim());
            this.recipeType = components[3].split(":")[1].trim();
        }
        sb.append(" ");
        sb.append(components[0].trim());
        this.recipeName = sb.toString();

        parseOutput(components[1]);
        parseInput(components[2]);
    }

    private void parseOutput(String recipeOutput) {
        try {
            recipeOutput = recipeOutput.replace('}', ' ');
            for(String s : recipeOutput.split("\\{")) {
                if (s.contains("Output")) {
                    continue;
                }
                String[] r = s.trim().split(":");
                Output.put(r[0], Double.parseDouble(r[1]));
            }
        }  catch (Exception e) {
            System.out.println("Error with" + getRecipeName());
        }
    }

    private void parseInput(String recipeInput) {
        try {
            recipeInput = recipeInput.replace('}', ' ');
            for(String s : recipeInput.split("\\{")) {
                if(s.contains("Ingredients")) {
                    continue;
                }
                String [] r = s.trim().split(":");
                Output.put(r[0], Double.parseDouble(r[1]));
            }
        } catch (Exception e) {
            System.out.println("Error with" + getRecipeName());
        }

    }


    public String getRecipeName() {
        return recipeName;
    }

    public String getRecipeType() {
        return recipeType;
    }

    public HashMap<String, Double> getOutput() {
        return Output;
    }

    public HashMap<String, Double> getIngredients() {
        return Ingredients;
    }
}
