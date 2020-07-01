package basic;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

public class CopperSheet {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public CopperSheet(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;


        if(alternateRecipes.get(35).getSelectedItem().toString() == "Default") {
            defaultCopperSheet();
        } else if(alternateRecipes.get(35).getSelectedItem().toString() == "Steamed") {
            steamedCopperSheet();
        }
    }

    public void defaultCopperSheet() {
        double CopperIngots = num * 2;
        output.append(ds.format(num) + " Copper Sheets/Minute:  " + ds.format(CopperIngots) + " Copper Ingots / minute.  "
                + "Requires  " + ds.format(num/10) + " Constructors\n\n");
        new CopperIngot(CopperIngots,alternateRecipes,output);
    }

    public void steamedCopperSheet() {
        double CopperIngots = num;
        double water = num;
        output.append(ds.format(num) + " Steamed Copper Sheets / Minute:  " + ds.format(CopperIngots) + " Copper Ingots / minute |  " +
                ds.format(water) +" Water(m3) / minute. Requires  " + ds.format(num/22.5) + " Refineries\n\n");
        new CopperIngot(CopperIngots,alternateRecipes,output);
    }

}
