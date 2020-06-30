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
public class Screw {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");
    
    public Screw(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        if(alternateRecipes.get(14).getSelectedItem().toString() == "Default") {
            defaultScrew();
        } else if(alternateRecipes.get(14).getSelectedItem().toString() == "Casted") {
            castedScrew();
        } else if(alternateRecipes.get(14).getSelectedItem().toString() == "Steel") {
            steelScrew();
        }
    }
    
    public void defaultScrew() {
        double IronRod = num / 4;
        output.append(ds.format(num) + " Screws/Minute:  " + ds.format(IronRod) + " Iron Rods / minute. Requires  " + ds.format(num/40) + " Constructors\n\n");
        new IronRod(IronRod,alternateRecipes,output);
    }

    public void castedScrew() {
        double IronIngot = num / 4;
        output.append(ds.format(num) + " Casted Screws/Minute:  " + ds.format(IronIngot) + " Iron Ingots / minute. Requires  " + ds.format(num/50) + " Constructors\n\n");
        new IronIngot(IronIngot,alternateRecipes,output);
    }

    public void steelScrew() {
        double SteelBeam = num / 52;
        output.append(ds.format(num) + " Steel Screws/Minute:  " + ds.format(SteelBeam) + " Steel Beams / minute. Requires  " + ds.format(num/260) + " Constructors\n\n");
        new SteelBeam(SteelBeam,alternateRecipes,output);
    }


    
    
    
    
}
