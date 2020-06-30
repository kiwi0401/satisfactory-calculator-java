package basic;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

public class CateriumIngot {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public CateriumIngot(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;


        if (alternateRecipes.get(2).getSelectedItem().toString() == "Default") {
            defaultCaterium();
        } else if (alternateRecipes.get(2).getSelectedItem().toString() == "Pure") {
            pureCaterium();
        }
    }

    public void defaultCaterium() {
        double CateriumOre = num * 3;
        output.append(ds.format(num) + " Caterium Ingots/Minute:  " + ds.format(CateriumOre) + " Caterium Ore / minute. Requires  " + ds.format(num/15) + " Smelters\n\n");
    }

    public void pureCaterium() {
        double CateriumOre = num * 2;
        double water = num * 2;
        output.append(ds.format(num) + " Pure Caterium Ingots/Minute:  " + ds.format(CateriumOre) + " Caterium Ore / minute |  " +
                ds.format(water) +" Water(m3) / minute. Requires  " + ds.format(num/12) + " Refineries\n\n");
    }


}
