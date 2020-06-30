/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intermediate;

import basic.CopperSheet;
import basic.PetroleumCoke;
import basic.Quickwire;
import basic.Silica;
import master.textHighlighter;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author kiwi0
 */
public class CircuitBoard {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public CircuitBoard(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        if(alternateRecipes.get(22).getSelectedItem().toString() == "Default") {
            defaultCircuit();
        } else if(alternateRecipes.get(22).getSelectedItem().toString() == "Electrode") {
            electrodeCircuit();
        } else if(alternateRecipes.get(22).getSelectedItem().toString() == "Silicone") {
            siliconeCircuit();
        } else if(alternateRecipes.get(22).getSelectedItem().toString() == "Caterium") {
            cateriumCircuit();
        }
    }

    public void defaultCircuit() {
        double CopperSheets = num * 2;
        double Plastic = num * 4;
        output.append(ds.format(num) + " Circuits / Minute:  " + ds.format(CopperSheets) + " Copper Sheets / minute |  " +
                ds.format(Plastic) +" Plastic / minute. Requires  " + ds.format(num/7.5) + " Assemblers\n\n");
        output.append("v-Circuits Start-v\n\n");
        new textHighlighter("v-Circuits Start-v", new Color(246, 103, 189),output);
        new CopperSheet(CopperSheets,alternateRecipes,output);
        output.append("-----\n\n");
        new Plastic(Plastic,alternateRecipes,output);
        output.append("^-Circuits End-^\n\n");
        new textHighlighter("^-Circuits End-^", new Color(246, 103, 189),output);

    }

    public void electrodeCircuit() {
        double Rubber = num * 6;
        double PetroleumCoke = num * 9;
        output.append(ds.format(num) + " Electrode Circuits / Minute:  " + ds.format(Rubber) + " Rubber / minute |  " +
                ds.format(PetroleumCoke) +" Petroleum Coke / minute. Requires  " + ds.format(num/5) + " Assemblers\n\n");
        output.append("v-Electrode Circuits Start-v\n\n");
        new textHighlighter("v-Electrode Circuits Start-v", new Color(246, 103, 189),output);
        new Rubber(Rubber,alternateRecipes,output);
        output.append("-----\n\n");
        new PetroleumCoke(PetroleumCoke,alternateRecipes,output);
        output.append("^-Electrode Circuits End-^\n\n");
        new textHighlighter("^-Electrode Circuits End-^", new Color(246, 103, 189),output);

    }

    public void siliconeCircuit() {
        double CopperSheets = num * (11/5.0);
        double silica = num * (11/5.0);
        output.append(ds.format(num) + " Silicone Circuits / Minute:  " + ds.format(CopperSheets) + " Copper Sheets / minute |  " +
                ds.format(silica) +" Silica / minute. Requires  " + ds.format(num/12.5) + " Assemblers\n\n");
        output.append("v-Silicone Circuits Start-v\n\n");
        new textHighlighter("v-Silicone Circuits Start-v", new Color(246, 103, 189),output);
        new CopperSheet(CopperSheets,alternateRecipes,output);
        output.append("-----\n\n");
        new Silica(silica,alternateRecipes,output);
        output.append("^-Silicone Circuits End-^\n\n");
        new textHighlighter("^-Silicone Circuits End-^", new Color(246, 103, 189),output);
    }

    public void cateriumCircuit() {
        double plastic = num * (10/7.0);
        double quickWire = num * (30/7.0);
        output.append(ds.format(num) + " Caterium Circuits / Minute:  " + ds.format(plastic) + " plastic / minute |  " +
                ds.format(quickWire) +" Quickwire / minute. Requires  " + ds.format(num/8.75) + " Assemblers\n\n");
        output.append("v-Caterium Circuits Start-v\n\n");
        new textHighlighter("v-Caterium Circuits Start-v", new Color(246, 103, 189),output);
        new Plastic(plastic,alternateRecipes,output);
        output.append("-----\n\n");
        new Quickwire(quickWire,alternateRecipes,output);
        output.append("^-Caterium Circuits End-^\n\n");
        new textHighlighter("^-Caterium Circuits End-^", new Color(246, 103, 189),output);

    }

}
