package basic;

import intermediate.HeavyOilResidue;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

public class PetroleumCoke {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public PetroleumCoke(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;
        defaultCoke();
    }

    public void defaultCoke() {
        double HeavyOilResidue = num / 3;
        output.append(ds.format(num) + " Petroleum Coke / Minute:  " + ds.format(HeavyOilResidue) + " Heavy Oil Residue(m3)" +
                " / minute. Requires  " + ds.format(num/120) + " Refineries\n\n");
        new HeavyOilResidue(HeavyOilResidue,alternateRecipes,output);
    }
}
