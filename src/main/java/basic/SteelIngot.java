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
public class SteelIngot {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public SteelIngot(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        if(alternateRecipes.get(3).getSelectedItem().toString() == "Default") {
            defaultSteelIngot();
        } else if(alternateRecipes.get(3).getSelectedItem().toString() == "Coke") {
            cokeSteelIngot();
        } else if(alternateRecipes.get(3).getSelectedItem().toString() == "Compacted") {
            compactedSteelIngot();
        } else if(alternateRecipes.get(3).getSelectedItem().toString() == "Solid") {
            solidSteelIngot();
        }
    }

    public void defaultSteelIngot() {
        double IronOre = num;
        double RawCoal = num;
        output.append(ds.format(num) + " Steel Ingots / Minute:  " + ds.format(IronOre) + " Iron Ore / minute |  " +
                ds.format(RawCoal) +" Raw Coal / minute. Requires  " + ds.format(num/45) + " Foundries\n\n");
    }

    public void compactedSteelIngot() {
        double IronOre = num * (6/10.0);
        double CompactedCoal = num * (3/10.0);
        output.append(ds.format(num) + " Compacted Steel Ingots / Minute:  " + ds.format(IronOre) + " Iron Ore / minute |  " +
                ds.format(CompactedCoal) +" Compacted Coal / minute. Requires  " + ds.format(num/37.5) + " Foundries\n\n");
        new CompactedCoal(CompactedCoal,alternateRecipes,output);

    }

    public void cokeSteelIngot() {
        double PetroleumCoke = num * (15/20.0);
        double IronOre = num * (15/20.0);
        output.append(ds.format(num) + " Coke Steel Ingots / Minute:  " + ds.format(PetroleumCoke) + " Petroleum Coke / minute |  " +
                ds.format(IronOre) +" Iron Ore / minute. Requires  " + ds.format(num/100) + " Foundries\n\n");
        new PetroleumCoke(PetroleumCoke,alternateRecipes,output);
    }

    public void solidSteelIngot() {
        double IronIngot = num * (2/3.0);
        double RawCoal = num * (2/3.0);
        output.append(ds.format(num) + " Solid Steel Ingots / Minute:  " + ds.format(IronIngot) + " Iron Ingots / minute |  " +
                ds.format(RawCoal) +" Raw Coal / minute. Requires  " + ds.format(num/60) + " Foundries\n\n");
        new IronIngot(IronIngot,alternateRecipes,output);

    }









}
