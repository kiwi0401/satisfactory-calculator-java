/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermediate;

import basic.*;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author kiwi0
 */
public class HeatSink {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public HeatSink(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        if(alternateRecipes.get(39).getSelectedItem().toString() == "Default") {
            defaultHeatSink();
        } else if(alternateRecipes.get(39).getSelectedItem().toString() == "Heat Exchanger") {
            heatExchanger();
        }
    }

    public void defaultHeatSink() {
        double alcadSheets = num * 4;
        double rubber = num * 7;
        output.append(ds.format(num) + " Heat Sinks / Minute:  " + ds.format(alcadSheets) + " Alclad Aluminum Sheets / minute |  " +
                ds.format(rubber) +" Rubber / minute. Requires  " + ds.format(num/10) + " Assemblers\n\n");
        new AlcadAluminumSheet(alcadSheets,alternateRecipes,output);
        output.append("-\n\n");
        new Rubber(rubber,alternateRecipes,output);

    }

    public void heatExchanger() {
        double alcadSheets = num * (20/7.0);
        double copperSheets = num * (30/7.0);
        output.append(ds.format(num) + " Heat Sinks / Minute:  " + ds.format(alcadSheets) + " Alclad Aluminum Sheets / minute |  " +
                ds.format(copperSheets) +" Copper Sheets / minute. Requires  " + ds.format(num/13.125) + " Assemblers\n\n");
        new AlcadAluminumSheet(alcadSheets,alternateRecipes,output);
        output.append("-\n\n");
        new CopperSheet(copperSheets,alternateRecipes,output);

    }

}
