/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import intermediate.Rubber;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author kiwi0
 */
public class ReinforcedIronPlate {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public ReinforcedIronPlate(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        if(alternateRecipes.get(8).getSelectedItem().toString() == "Default") {
            defaultRIP();
        } else if(alternateRecipes.get(8).getSelectedItem().toString() == "Adhered") {
            adheredRIP();
        } else if(alternateRecipes.get(8).getSelectedItem().toString() == "Bolted") {
            boltedRIP();
        } else if(alternateRecipes.get(8).getSelectedItem().toString() == "Stitched") {
            stitchedRIP();
        }
    }

    public void defaultRIP() {
        double IronPlates = num * 6;
        double Screws = num * 12;
        output.append(ds.format(num) + " R.I.P / Minute:  " + ds.format(IronPlates) + " Iron Plates / minute |  " +
                ds.format(Screws) +" Screws / minute. Requires  " + ds.format(num/5) + " Assemblers\n\n");
        new IronPlate(IronPlates,alternateRecipes,output);
        output.append("-\n\n");
        new Screw(Screws,alternateRecipes,output);

    }

    public void adheredRIP() {
        double IronPlates = num * 3;
        double rubber = num;
        output.append(ds.format(num) + " Adhered R.I.P / Minute:  " + ds.format(IronPlates) + " Iron Plates / minute |  " +
                ds.format(rubber) +" Rubber / minute. Requires  " + ds.format(num/3.75) + " Assemblers\n\n");
        new IronPlate(IronPlates,alternateRecipes,output);
        output.append("-\n\n");
        new Rubber(rubber,alternateRecipes,output);

    }

    public void boltedRIP() {
        double IronPlates = num * 6;
        double Screws = num * (50/3.0);
        output.append(ds.format(num) + " Bolted R.I.P / Minute:  " + ds.format(IronPlates) + " Iron Plates / minute |  " +
                ds.format(Screws) +" Screws / minute. Requires  " + ds.format(num/15) + " Assemblers\n\n");
        new IronPlate(IronPlates,alternateRecipes,output);
        output.append("-\n\n");
        new Screw(Screws,alternateRecipes,output);
    }

    public void stitchedRIP() {
        double IronPlates = num * (10/3.0);
        double Wire = num * (20/3.0);
        output.append(ds.format(num) + " Stitched R.I.P / Minute:  " + ds.format(IronPlates) + " Iron Plates / minute |  " +
                ds.format(Wire) +" Wire / minute. Requires  " + ds.format(num/5.625) + " Assemblers\n\n");
        new IronPlate(IronPlates,alternateRecipes,output);
        output.append("-\n\n");
        new Wire(Wire,alternateRecipes,output);
    }









}
