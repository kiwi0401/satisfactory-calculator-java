/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author kiwi0
 */
public class Quickwire {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public Quickwire(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        if(alternateRecipes.get(26).getSelectedItem().toString() == "Default") {
            defaultWire();
        } else if(alternateRecipes.get(26).getSelectedItem().toString() == "Fused") {
            fusedWire();
        }

    }

    public void defaultWire() {
        double CateriumIngots = num / 5;
        output.append(ds.format(num) + " QuickWire / Minute:  " + ds.format(CateriumIngots) + " Caterium Ingots / minute. "
                + "Requires  " + ds.format(num/60) + " Constructors\n\n");
        new CateriumIngot(CateriumIngots,alternateRecipes,output);
    }

    public void fusedWire() {
        double CopperIngots = num * (5/12.0);
        double CateriumIngots = num * (1/12.0);
        output.append(ds.format(num) + " Fused QuickWire / Minute:  " + ds.format(CopperIngots) + " Copper Ingots / minute |  " +
                ds.format(CateriumIngots) +" Caterium Ingots / minute. Requires  " + ds.format(num/90) + " Assemblers\n\n");
        new CopperIngot(CopperIngots,alternateRecipes,output);
        output.append("-\n\n");
        new CateriumIngot(CateriumIngots,alternateRecipes,output);
    }


}
