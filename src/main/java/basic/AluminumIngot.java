package basic;

import intermediate.AluminumScrap;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

public class AluminumIngot {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public AluminumIngot(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;


        if(alternateRecipes.get(31).getSelectedItem().toString() == "Default") {
            defaultAluminum();
        } else if(alternateRecipes.get(31).getSelectedItem().toString() == "Pure") {
            pureAluminum();
        }

    }

    public void pureAluminum() {
        double aluminumScrap = num * 4;
        output.append(ds.format(num) + "  Pure Aluminum Ingots / Minute: " + ds.format(aluminumScrap) + "  Aluminum Scrap" +
                " / minute. Requires  " + ds.format(num/36) + " Smelters\n\n");
        new AluminumScrap(aluminumScrap,alternateRecipes,output);

    }

    public void defaultAluminum() {
        double aluminumScrap = num * 3;
        double silica = num * (7/4.0);
        output.append(ds.format(num) + " Aluminum Ingots / Minute:  " + ds.format(aluminumScrap) + " Aluminum Scrap / minute |  " +
                ds.format(silica) +" Silica / minute. Requires  " + ds.format(num/80) + " Foundries\n\n");
        new AluminumScrap(aluminumScrap,alternateRecipes,output);
    }

}
