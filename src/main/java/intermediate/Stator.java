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
public class Stator {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public Stator(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        if(alternateRecipes.get(10).getSelectedItem().toString() == "Default") {
            defaultStator();
        } else if(alternateRecipes.get(10).getSelectedItem().toString() == "Quickwire") {
            quickwireStator();
        }
    }

    public void defaultStator() {
        double steelPipe = num * 3;
        double wire = num * 8;
        output.append(ds.format(num) + " Stators / Minute:  " + ds.format(steelPipe) + " Steel Pipes / minute |  " +
                ds.format(wire) +" Wire / minute. Requires  " + ds.format(num/5) + " Assemblers\n\n");
        new SteelPipe(steelPipe,alternateRecipes,output);
        output.append("-\n\n");
        new Wire(wire,alternateRecipes,output);

    }

    public void quickwireStator() {
        double steelPipe = num * 2;
        double quickWire = num * (15/2.0);
        output.append(ds.format(num) + " Quickwire Stators / Minute:  " + ds.format(steelPipe) + " Steel Pipes / minute |  " +
                ds.format(quickWire) +" Quickwire / minute. Requires  " + ds.format(num/8) + " Assemblers\n\n");
        new SteelPipe(steelPipe,alternateRecipes,output);
        output.append("-\n\n");
        new Quickwire(quickWire,alternateRecipes,output);

    }


}
