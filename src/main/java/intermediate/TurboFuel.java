package intermediate;

import basic.CompactedCoal;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

public class TurboFuel {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public TurboFuel(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;


        if(alternateRecipes.get(17).getSelectedItem().toString() == "Turbofuel") {
            turbofuel();
        } else if(alternateRecipes.get(17).getSelectedItem().toString() == "Heavy Turbofuel") {
            heavyTurbofuel();
        }
    }

    public void turbofuel() {
        double fuel = num * (6/5.0);
        double compactedCoal = num * (4/5.0);
        output.append(ds.format(num) + " TurboFuel(m3) / Minute:  "+ ds.format(fuel) + " Fuel(m3)" +
                " / minute |  " + ds.format(compactedCoal) + " Compacted Coal / minute. Requires  " + ds.format(num/18.75) + " Refineries\n\n");
        new Fuel(fuel,alternateRecipes,output);
        new CompactedCoal(compactedCoal,alternateRecipes,output);
    }

    public void heavyTurbofuel() {
        double heavyOilResidue = num * (5/4.0);
        double compactedCoal = num;
        output.append(ds.format(num) + " TurboFuel(m3) / Minute:  "+ ds.format(heavyOilResidue) + " Heavy Oil Residue(m3)" +
                " / minute |  " + ds.format(compactedCoal) + " Compacted Coal / minute. Requires  " + ds.format(num/30) + " Refineries\n\n");
        new HeavyOilResidue(heavyOilResidue,alternateRecipes,output);
        new CompactedCoal(compactedCoal,alternateRecipes,output);
    }


}
