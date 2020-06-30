package basic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import intermediate.Plastic;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author kiwi0
 */
public class IronPlate {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public IronPlate(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        if(alternateRecipes.get(34).getSelectedItem().toString() == "Default") {
            defaultIronPlate();
        } else if(alternateRecipes.get(34).getSelectedItem().toString() == "Coated") {
            coatedPlate();
        } else if(alternateRecipes.get(34).getSelectedItem().toString() == "Steel Coated") {
            steelCoatedPlate();
        }
    }

    public void defaultIronPlate() {
        double IronIngots = num*(3/2.0);
        output.append(ds.format(num) + " Iron Plates / Minute:  " + ds.format(IronIngots) + " Iron Ingots / minute. Requires  " + ds.format(num/20) + " Constructors\n\n");
        new IronIngot(IronIngots, alternateRecipes, output);
    }

    public void coatedPlate() {
        double IronIngots = num * (10/15.0);
        double Plastic = num * (2/15.0);
        output.append(ds.format(num) + " Coated Iron Plates / Minute:  " + ds.format(IronIngots) + " Iron Ingots / minute |  " +
                ds.format(Plastic) +" Plastic / minute. Requires  " + ds.format(num/75) + " Assemblers\n\n");
        new IronIngot(IronIngots, alternateRecipes, output);
        output.append("-\n\n");
        new Plastic(Plastic,alternateRecipes,output);
    }

    public void steelCoatedPlate() {
        double SteelIngots = num * (3/18.0);
        double Plastic = num * (2/18.0);
        output.append(ds.format(num) + " Steel Coated Iron Plates / Minute:  " + ds.format(SteelIngots) + " Steel Ingots / minute |  " +
                ds.format(Plastic) +" Plastic / minute. Requires  " + ds.format(num/45) + " Assemblers\n\n");
        new SteelIngot(SteelIngots,alternateRecipes,output);
        output.append("-\n\n");
        new Plastic(Plastic,alternateRecipes,output);
    }
}
