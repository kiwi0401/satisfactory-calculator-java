package basic;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

public class CopperIngot {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public CopperIngot(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;


        if(alternateRecipes.get(1).getSelectedItem().toString() == "Default") {
            defaultIngot();
        } else if(alternateRecipes.get(1).getSelectedItem().toString() == "Pure") {
            pureIngot();
        } else if(alternateRecipes.get(1).getSelectedItem().toString() == "Alloy") {
            alloy();
        }
    }

    public void defaultIngot() {
        double CopperOre = num;
        output.append(ds.format(num) + " Copper Ingots / Minute:  " + ds.format(CopperOre) + " Copper Ore / minute.  " +
                "Requires " + ds.format(num/30) + " Smelters\n\n");
    }

    public void pureIngot() {
        double CopperOre = num * (6/15.0);
        double water = num * (4/15.0);
        output.append(ds.format(num) + " Pure Copper Ingots / Minute:  " + ds.format(CopperOre) + " Copper Ore / minute |  " +
                ds.format(water) +" Water(m3) / minute. Requires  " + ds.format(num/37.5) + " Refineries\n\n");
    }

    public void alloy() {
        double IronOre = num * (1/4.0);
        double CopperOre = num * (1/2.0);
        output.append(ds.format(num) + " Alloy Copper Ingots / Minute:  " + ds.format(IronOre) + " Iron Ore / minute |  " +
                ds.format(CopperOre) +" Copper Ore / minute. Requires  " + ds.format(num/100) + " Foundries\n\n");
    }


}
