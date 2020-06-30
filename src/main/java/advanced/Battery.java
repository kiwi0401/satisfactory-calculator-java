package advanced;

import basic.AlcadAluminumSheet;
import basic.Wire;
import intermediate.Plastic;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

public class Battery {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public Battery(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        defaultBattery();
    }

    public void defaultBattery() {
        double alcadSheets = num * (8/3.0);
        double wire = num * (16/3.0);
        double rawSulfur = num * (20/3.0);
        double plastic = num * (8/3.0);
        output.append(ds.format(num) + " Batteries / Minute:  " + ds.format(alcadSheets) + " Alcad Sheets / minute |  " +
                ds.format(wire) +" Wire / minute |  " + ds.format(rawSulfur) + " Sulfur / Minute |  " +
                ds.format(plastic) + " Plastic / minute" +
                ". Requires  " + ds.format(num/5.625) + " Manufacturers\n\n");
        new AlcadAluminumSheet(alcadSheets,alternateRecipes,output);
        new Wire(wire,alternateRecipes,output);
        new Plastic(plastic,alternateRecipes,output);
    }

}
