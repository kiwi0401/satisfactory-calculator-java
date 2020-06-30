/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import intermediate.HeavyOilResidue;
import intermediate.Rubber;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author kiwi0
 */
public class Cable {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public Cable(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        if(alternateRecipes.get(37).getSelectedItem().toString() == "Default") {
            defaultCable();
        } else if(alternateRecipes.get(37).getSelectedItem().toString() == "Coated") {
            coatedCable();
        } else if(alternateRecipes.get(37).getSelectedItem().toString() == "Insulated") {
            insulatedCable();
        } else if(alternateRecipes.get(37).getSelectedItem().toString() == "Quickwire") {
            quickwireCable();
        }
    }

    public void defaultCable() {
        double wire = num * 2;
        output.append(ds.format(num) + " Cable / Minute: " + ds.format(wire) + "  Wire / minute. Requires  " + ds.format(num/30) + " Constructors\n\n");
        new Wire(wire,alternateRecipes,output);
    }

    public void coatedCable() {
        double wire = num * (5/9.0);
        double heavyOilResidue = num * (2/9.0);
        output.append(ds.format(num) + "  Coated Cable / Minute: " + ds.format(wire) + " Wire / minute |  " +
                ds.format(heavyOilResidue) +" Heavy Oil Residue(m3) / minute. Requires  " + ds.format(num/67.5) + " Refineries\n\n");
        new Wire(wire,alternateRecipes,output);
        output.append("-\n\n");
        new HeavyOilResidue(heavyOilResidue,alternateRecipes,output);

    }

    public void insulatedCable() {
        double wire = num * (9/20.0);
        double rubber = num * (6/20.0);
        output.append(ds.format(num) + " Insulated Cable / Minute:  " + ds.format(wire) + " Wire / minute |  " +
                ds.format(rubber) +" Rubber / minute. Requires  " + ds.format(num/100) + " Assemblers\n\n");
        new Wire(wire,alternateRecipes,output);
        output.append("-\n\n");
        new Rubber(rubber,alternateRecipes,output);
    }

    public void quickwireCable() {
        double quickWire = num * (3/11.0);
        double rubber = num * (2/11.0);
        output.append(ds.format(num) + " Quickwire Cable / Minute:  " + ds.format(quickWire) + " Quickwire / minute |  " +
                ds.format(rubber) +" Rubber / minute. Requires  " + ds.format(num/27.5) + " Assemblers\n\n");
        new Quickwire(quickWire,alternateRecipes,output);
        output.append("-\n\n");
        new Rubber(rubber,alternateRecipes,output);
    }









}
