package basic;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

public class AlcadAluminumSheet {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public AlcadAluminumSheet(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;
        defaultAlcadSheet();

    }

    public void defaultAlcadSheet() {
        double aluminumIngot = num * 2;
        double copperIngot = num * (3/4.0);
        output.append(ds.format(num) + " Alcad Aluminum Sheets / Minute:  " + ds.format(aluminumIngot) + " Aluminum Ingots / minute |  " +
                ds.format(copperIngot) +" Copper Ingots / minute. Requires  " + ds.format(num/30) + " Assemblers\n\n");
        new AluminumIngot(aluminumIngot,alternateRecipes,output);
        new CopperIngot(copperIngot,alternateRecipes,output);

    }

}
