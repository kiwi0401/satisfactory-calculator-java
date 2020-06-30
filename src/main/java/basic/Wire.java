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
public class Wire {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public Wire(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        if(alternateRecipes.get(6).getSelectedItem().toString() == "Default") {
            defaultWire();
        } else if(alternateRecipes.get(6).getSelectedItem().toString() == "Fused") {
            fusedWire();
        } else if(alternateRecipes.get(6).getSelectedItem().toString() == "Iron") {
            ironWire();
        } else if(alternateRecipes.get(6).getSelectedItem().toString() == "Caterium") {
            cateriumWire();
        }
    }

    public void defaultWire() {
        double CopperIngots = num / 2;
        output.append(ds.format(num) + " Wire / Minute:  " + ds.format(CopperIngots) + " Copper Ingots / minute. "
                + "Requires  " + ds.format(num/30) + " Constructors\n\n");
        new CopperIngot(CopperIngots,alternateRecipes,output);
    }

    public void fusedWire() {
        double CopperIngots = num * (4/30.0);
        double CateriumIngots = num * (1/30.0);
        output.append(ds.format(num) + " Fused Wire / Minute:  " + ds.format(CopperIngots) + " Copper Ingots / minute |  " +
                ds.format(CateriumIngots) +" Caterium Ingots / minute. Requires  " + ds.format(num/90) + " Assemblers\n\n");
        new CopperIngot(CopperIngots,alternateRecipes,output);
        new CateriumIngot(CateriumIngots,alternateRecipes,output);
    }

    public void ironWire() {
        double IronIngots = num * (5/9.0);
        output.append(ds.format(num) + " Iron Wire / Minute:  " + ds.format(IronIngots) + " Iron Ingots / minute. "
                + "Requires  " + ds.format(num/22.5) + " Constructors\n\n");
        new IronIngot(IronIngots,alternateRecipes,output);
    }

    public void cateriumWire() {
        double CateriumIngots = num * (1/8.0);
        output.append(ds.format(num) + " Caterium Wire / Minute:  " + ds.format(CateriumIngots) + " Caterium Ingots / minute. "
                + "Requires  " + ds.format(num/120) + " Constructors\n\n");
        new CateriumIngot(CateriumIngots,alternateRecipes,output);
    }

}
