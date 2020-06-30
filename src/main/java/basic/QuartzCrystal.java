package basic;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

public class QuartzCrystal {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public QuartzCrystal(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;


        if(alternateRecipes.get(7).getSelectedItem().toString() == "Default") {
            defaultQuartzCrystal();
        } else if(alternateRecipes.get(7).getSelectedItem().toString() == "Pure") {
            pureQuartzCrystal();
        }
    }

    public void defaultQuartzCrystal() {
        double RawQuartz = num * (5/3.0);
        output.append(ds.format(num) + " Quartz Crystal / Minute:  " + ds.format(RawQuartz) + " Raw Quartz / minute. Requires  " + ds.format(num/22.5) + " Constructors\n\n");
    }

    public void pureQuartzCrystal() {
        double RawQuartz = num * (9/7.0);
        double water = num * (5/7.0);
        output.append(ds.format(num) + " Pure Quartz Crystal / Minute: " + ds.format(RawQuartz) + " Raw Quartz / minute |  " +
                ds.format(water) +" water(m3) / minute. Requires  " + ds.format(num/52.5) + " Refineries\n\n");
    }

}
