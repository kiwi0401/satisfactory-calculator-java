/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermediate;

import basic.PetroleumCoke;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author kiwi0
 */
public class AluminumScrap {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public AluminumScrap(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        if(alternateRecipes.get(3).getSelectedItem().toString() == "Default") {
            defaultAluminumScrap();
        } else if(alternateRecipes.get(3).getSelectedItem().toString() == "Electrode") {
            electrodeAluminumScrap();
        }
    }

    public void defaultAluminumScrap() {
        double aluminaSolution = num * (4/6.0);
        double petroleumCoke = num * (1/6.0);
        double water = num * (1/6.0);
        output.append(ds.format(num) + " Aluminum Scrap / Minute: and " + ds.format(water) + " water(m3) / Minute" +
                ":  " + ds.format(aluminaSolution) + " Alumina Solution / minute |  " +
                ds.format(petroleumCoke) +" Petroleum Coke / minute. Requires  " + ds.format(num/360) + " Refineries\n\n");
        new AluminaSolution(aluminaSolution,alternateRecipes,output);
        new PetroleumCoke(petroleumCoke,alternateRecipes,output);
    }

    public void electrodeAluminumScrap() {
        double aluminaSolution = num * (3/5.0);
        double coal = num * (1/5.0);
        double water = num * (1/5.0);
        output.append(ds.format(num) + " Aluminum Scrap / Minute: and " + ds.format(water) + " water(m3) / Minute" +
                ":  " + ds.format(aluminaSolution) + " Alumina Solution / minute |  " +
                ds.format(coal) +" Raw Coal / minute. Requires  " + ds.format(num/360) + " Refineries\n\n");
        new AluminaSolution(aluminaSolution,alternateRecipes,output);
    }

}
