/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermediate;

import master.textHighlighter;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author kiwi0
 */
public class Plastic {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");
    private boolean isResidual = false;
    private double extraRubber = 0;

    public Plastic(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;


        if(alternateRecipes.get(18).getSelectedItem().toString() == "Default") {
            defaultPlastic();
        } else if(alternateRecipes.get(18).getSelectedItem().toString() == "Residual") {
            residualPlastic(num);
        } else if(alternateRecipes.get(18).getSelectedItem().toString() == "Recycled") {
            recycledPlastic(num);
        } else if(alternateRecipes.get(18).getSelectedItem().toString() == "Most Efficient") {
            efficientPlastic();
        }
    }


    public Plastic(double num, List<JComboBox<String>> alternateRecipes, JTextArea output, boolean isResidual) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;
        this.isResidual = isResidual;

        if(alternateRecipes.get(18).getSelectedItem().toString() == "Default") {
            defaultPlastic();
        } else if(alternateRecipes.get(18).getSelectedItem().toString() == "Residual") {
            residualPlastic(num);
        } else if(alternateRecipes.get(18).getSelectedItem().toString() == "Recycled") {
            recycledPlastic(num);
        } else if(alternateRecipes.get(18).getSelectedItem().toString() == "Most Efficient") {
            efficientPlastic();
        }

    }

    private void efficientPlastic() {

        output.append("> "+ ds.format(num) + " Plastic / Min using the most efficient recipes\n\n");
        alternateRecipes.get(19).setSelectedIndex(3);



        if(!isResidual) {
            String plasticStart = "v-" + num + " Plastic Start-v";
            output.append(plasticStart + "\n\n");
            new textHighlighter(plasticStart, new Color(123, 0, 255),output);
            double plasticCount = 0;
            double fuel = 0;
            if(alternateRecipes.get(36).getSelectedItem().toString() == "Default" || alternateRecipes.get(36).getSelectedItem().toString() == "Residual") {
                plasticCount = num * (1497/1300.0);
                fuel = num * (8/11.0);

            } else if(alternateRecipes.get(36).getSelectedItem().toString() == "Diluted") {
                plasticCount = num * (1200/953.0);
                fuel = num * (120/135.0);
            }
            double rubber = new Fuel(fuel,alternateRecipes,output).getPolymerResin() / 2;
            new Rubber(rubber,alternateRecipes,output,1);
            extraRubber = rubber;
            recycledPlastic(plasticCount);
            String plasticEnd = "^-" + num + " Plastic End-^";
            output.append(plasticEnd + "\n\n");
            new textHighlighter(plasticEnd, new Color(123, 0, 255),output);


        } else {
            recycledPlastic(num);
        }


    }



    public void defaultPlastic() {
        double CrudeOil = num * (3/2.0);
        double HeavyOilResidue = num / 2;
        output.append(ds.format(num) + " Plastic / Minute: with  " + ds.format(HeavyOilResidue) + " Heavy Oil Residue / minute:  " +
                ds.format(CrudeOil) +" Raw Oil(m3) / minute. Requires  " + ds.format(num/20) + " Refineries\n\n");
    }

    public void residualPlastic(double amount) {
        double PolymerResin = amount * (6/2.0);
        double water = amount;
        output.append(ds.format(amount) + " Residual Plastic / Minute:  " + ds.format(PolymerResin) + " Polymer Resin / minute |  " +
                ds.format(water) +" Water(m3) / minute.  Requires " + ds.format(amount/20) + " Refineries\n\n");
    }

    public void recycledPlastic(double amount) {

        if(!isResidual) {
            if(alternateRecipes.get(19).getSelectedItem().toString().equals("Most Efficient") ) {
                double rubber = amount / 2;
                double fuel = amount / 2;
                output.append(ds.format(amount) + " Recycled Plastic / Minute:  " + ds.format(rubber) + " Rubber / minute |  " +
                        ds.format(fuel) +" Fuel(m3) / minute. Requires  " + ds.format(amount/60) + " Refineries\n\n");
                new Rubber(rubber - extraRubber,alternateRecipes,output,true);
            } else if(alternateRecipes.get(19).getSelectedItem().toString().equals("Recycled")) {
                amount += amount / 3;
                double rubber = amount / 2;
                double plasticFuel = amount / 2;
                double totalFuel = plasticFuel + rubber / 2;
                output.append(ds.format(amount) + " Recycled Plastic / Minute:  " + ds.format(rubber) + " Rubber / minute |  " +
                        ds.format(plasticFuel) +" Fuel(m3) / minute. Requires  " + ds.format(amount/60) + " Refineries\n\n");
                new Rubber(rubber,alternateRecipes,output,true);
                new Fuel(totalFuel,alternateRecipes,output);
            } else {
                double rubber = amount / 2;
                double fuel = amount / 2;
                output.append(ds.format(amount) + " Recycled Plastic / Minute:  " + ds.format(rubber) + " Rubber / minute |  " +
                        ds.format(fuel) +" Fuel(m3) / minute. Requires  " + ds.format(amount/60) + " Refineries\n\n");
                new Rubber(rubber,alternateRecipes,output);
                new Fuel(fuel,alternateRecipes,output);
            }
        } else {
            double rubber = amount / 2;
            double fuel = amount / 2;
            output.append(ds.format(amount) + " Recycled Plastic / Minute:  " + ds.format(rubber) + " Rubber (from previous production) / minute |  " +
                    ds.format(fuel) +" Fuel(m3) / minute. Requires  " + ds.format(amount/60) + " Refineries\n\n");
        }

    }

}
