package basic;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

public class IronRod {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public IronRod(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        if(alternateRecipes.get(33).getSelectedItem().toString() == "Default") {
            defaultRod();
        } else if(alternateRecipes.get(33).getSelectedItem().toString() == "Steel") {
            steelRod();
        }
    }

    public void defaultRod() {
        double IronIngot = num;
        output.append(ds.format(num) + " Iron Rods/Minute:  " + ds.format(IronIngot) + " Iron Ingots / minute. Requires  " + ds.format(num/15) + " Constructors\n\n");
        new IronIngot(num,alternateRecipes,output);
    }

    public void steelRod() {
        double steelIngot = num / 4;
        output.append(ds.format(num) + " Steel Iron Rods/Minute:  " + ds.format(steelIngot) + " Steel Ingots / minute. Requires  " + ds.format(num/48) + " Constructors\n\n");
        new SteelIngot(steelIngot,alternateRecipes,output);
    }


}
