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
public class Rotor {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public Rotor(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        if(alternateRecipes.get(20).getSelectedItem().toString() == "Default") {
            defaultRotor();
        } else if(alternateRecipes.get(20).getSelectedItem().toString() == "Copper") {
            copperRotor();
        } else if(alternateRecipes.get(3).getSelectedItem().toString() == "Steel") {
            steelRotor();
        }
    }

    public void defaultRotor() {
        double IronRods = num * 5;
        double Screws = num * 25;
        output.append(ds.format(num) + " Rotors / Minute:  " + ds.format(IronRods) + " Iron Rods / minute |  " +
                ds.format(Screws) +" Screws / minute. Requires  " + ds.format(num/4) + " Assemblers\n\n");
        new IronRod(IronRods,alternateRecipes,output);
        output.append("-\n\n");
        new Screw(Screws,alternateRecipes,output);
    }

    public void copperRotor() {
        double CopperSheets = num * (2);
        double Screws = num * (52/3.0);
        output.append(ds.format(num) + " Copper Rotors / Minute:  " + ds.format(CopperSheets) + " Copper Sheets / minute |  " +
                ds.format(Screws) +" Screws / minute. Requires  " + ds.format(num/11.25) + " Assemblers\n\n");
        new CopperSheet(CopperSheets,alternateRecipes,output);
        output.append("-\n\n");
        new Screw(Screws,alternateRecipes,output);

    }

    public void steelRotor() {
        double SteelPipes = num * 2;
        double Wires = num * 6;
        output.append(ds.format(num) + " Steel Rotors / Minute:  " + ds.format(SteelPipes) + " Steel Pipe / minute |  " +
                ds.format(Wires) +" Wire / minute. Requires  " + ds.format(num/5) + " Assemblers\n\n");
        new SteelPipe(SteelPipes,alternateRecipes,output);
        output.append("-\n\n");
        new Wire(Wires,alternateRecipes,output);
    }

}
