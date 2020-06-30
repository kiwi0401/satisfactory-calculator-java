package basic;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

public class IronIngot {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public IronIngot(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;


        if(alternateRecipes.get(0).getSelectedItem().toString() == "Default") {
            defaultIngot();
        } else if(alternateRecipes.get(0).getSelectedItem().toString() == "Pure") {
            pureIngot();
        } else if(alternateRecipes.get(0).getSelectedItem().toString() == "Alloy") {
            alloy();
        }
    }

    public void defaultIngot() {
        double IronOre = num;
        output.append(ds.format(num) + " Iron Ingots / Minute:  " + ds.format(IronOre) + " Iron Ore / minute. Requires  " + ds.format(num/30) + " Smelters\n\n");
    }

    public void pureIngot() {
        double IronOre = num * (7/13.0);
        double water = num * (4/13.0);
        output.append(ds.format(num) + " Pure Iron Ingots / Minute:  " + ds.format(IronOre) + " Iron Ore / minute:  " +
                ds.format(water) +" Water(m3) / minute. Requires  "  + ds.format(num/65) + " Refineries\n\n");
    }

    public void alloy() {
        double IronOre = num * (2/5.0);
        double CopperOre = num * (2/5.0);
        output.append(ds.format(num) + " Alloy Iron Ingots / Minute:  " + ds.format(IronOre) + " Iron Ore / minute |  " +
                ds.format(CopperOre) +" Copper Ore / minute. Requires  " + ds.format(num/50) + " Foundries\n\n");
    }


}
