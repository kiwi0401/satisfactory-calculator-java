/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermediate;

import basic.*;
import master.textHighlighter;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author kiwi0
 */
public class ModularFrame {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public ModularFrame(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        if(alternateRecipes.get(11).getSelectedItem().toString() == "Default") {
            defaultModularFrames();
        } else if(alternateRecipes.get(11).getSelectedItem().toString() == "Bolted") {
            boltedModularFrames();
        } else if(alternateRecipes.get(11).getSelectedItem().toString() == "Steeled") {
            steeledModularFrames();
        }
    }

    public void defaultModularFrames() {
        double reinforcedIronPlates = num * (3/2.0);
        double ironRod = num * 6;
        output.append(ds.format(num) + " Modular Frames / Minute:  " + ds.format(reinforcedIronPlates) + " R.I.P / minute |  " +
                ds.format(ironRod) +" Iron Rods / minute. Requires  " + ds.format(num/2) + " Assemblers\n\n");

        output.append("v-Modular Frame Start-v\n\n");
        new textHighlighter("v-Modular Frame Start-v", new Color(15,162,169),output);
        new ReinforcedIronPlate(reinforcedIronPlates,alternateRecipes,output);
        output.append("-----\n\n");
        new IronRod(ironRod,alternateRecipes,output);
        output.append("^-Modular Frame End-^\n\n");
        new textHighlighter("^-Modular Frame End-^", new Color(15,162,169),output);




    }

    public void boltedModularFrames() {
        double reinforcedIronPlates = num * (3/2.0);
        double screws = num * 28;
        output.append(ds.format(num) + " Bolted Modular Frames / Minute:  " + ds.format(reinforcedIronPlates) + " R.I.P / minute |  " +
                ds.format(screws) +" Screws / minute. Requires  " + ds.format(num/5) + " Assemblers\n\n");
        output.append("v-Bolted Modular Frame Start-v\n\n");
        new textHighlighter("v-Bolted Modular Frame Start-v", new Color(15,162,169),output);
        new ReinforcedIronPlate(reinforcedIronPlates,alternateRecipes,output);
        output.append("-----\n\n");
        new Screw(screws,alternateRecipes,output);
        output.append("^-Bolted Modular Frame End-^\n\n");
        new textHighlighter("^-Bolted Modular Frame End-^", new Color(15,162,169),output);

    }

    public void steeledModularFrames() {
        double steelPipe = num * (10/3.0);
        double reinforcedIronPlate = num * (2/3.0);
        output.append(ds.format(num) + " Steeled Modular Frames / Minute:  " + ds.format(steelPipe) + " Steel Pipes / minute |  " +
                ds.format(reinforcedIronPlate) +" R.I.P / minute. Requires  " + ds.format(num/3) + " Assemblers\n\n");
        output.append("v-Steeled Modular Frame Start-v\n\n");
        new textHighlighter("v-Steeled Modular Frame Start-v", new Color(15,162,169),output);
        new SteelPipe(steelPipe,alternateRecipes,output);
        output.append("-----\n\n");
        new ReinforcedIronPlate(reinforcedIronPlate,alternateRecipes,output);
        output.append("^-Steeled Modular Frame End-^\n\n");
        new textHighlighter("^-Steeled Modular Frame End-^", new Color(15,162,169),output);
    }

}
