package advanced;

import basic.Cable;
import basic.Quickwire;
import basic.Screw;
import intermediate.CircuitBoard;
import intermediate.Plastic;
import intermediate.Rubber;
import master.textHighlighter;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

public class Computer {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public Computer(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;


        if (alternateRecipes.get(13).getSelectedItem().toString() == "Default") {
            defaultComputer();
        } else if (alternateRecipes.get(13).getSelectedItem().toString() == "Crystal") {
            crystalComputer();
        } else if (alternateRecipes.get(13).getSelectedItem().toString() == "Caterium") {
            cateriumComputer();
        }
    }

    public void defaultComputer() {
        double circuits = num * 10;
        double cable = num * 9;
        double plastic = num * 18;
        double screw = num * 52;
        output.append(ds.format(num) + " Computers / Minute:  " + ds.format(circuits) + " Circuit Boards / minute |  " +
                ds.format(cable) +" Cable / minute |  " + ds.format(plastic) + " Plastic / Minute |  " +
                ds.format(screw) + " Screws / minute" +
                ". Requires  " + ds.format(num/2.5) + " Manufacturers\n\n");

        output.append("v-Computer Start-v\n\n");
        new textHighlighter("v-Computer Start-v", Color.cyan,output);

        new CircuitBoard(circuits,alternateRecipes,output);
        output.append("-----\n\n");
        new Cable(cable,alternateRecipes,output);
        output.append("-----\n\n");
        new Plastic(screw,alternateRecipes,output);
        output.append("-----\n\n");
        new Screw(screw,alternateRecipes,output);

        output.append("^-Computer End-^\n\n");
        new textHighlighter("^-Computer End-^", Color.cyan,output);

    }

    public void crystalComputer() {
        double circuits = num * (8/3.0);
        double CrystalOscillators = num;
        output.append(ds.format(num) + " Crystal Computers / Minute:  " + ds.format(circuits) + " Circuit Boards / minute |  " +
                ds.format(CrystalOscillators) +" Crystal Oscillators / minute. Requires  " + ds.format(num/2.8125) + " Assemblers\n\n");

        output.append("v-Computer Start-v\n\n");
        new textHighlighter("v-Computer Start-v", Color.cyan,output);
        new CircuitBoard(circuits,alternateRecipes,output);
        output.append("-----\n\n");
        new CrystalOscillator(CrystalOscillators,alternateRecipes,output);
        output.append("^-Computer End-^\n\n");
        new textHighlighter("^-Computer End-^", Color.cyan,output);

    }

    public void cateriumComputer() {
        double circuits = num * 7;
        double quickWire = num * 28;
        double rubber = num * 12;
        output.append(ds.format(num) + " Caterium Computers / Minute:  " + ds.format(circuits) + " Circuit Boards / minute |  " +
                ds.format(quickWire) +" Quickwire / minute |  " + ds.format(rubber) + " Rubber / Minute" +
                ". Requires  " + ds.format(num/3.75) + " Manufacturers\n\n");

        output.append("v-Computer Start-v\n\n");
        new textHighlighter("v-Computer Start-v", Color.cyan,output);
        new CircuitBoard(circuits,alternateRecipes,output);
        output.append("-----\n\n");
        new Rubber(rubber,alternateRecipes,output);
        output.append("-----\n\n");
        new Quickwire(quickWire,alternateRecipes,output);
        output.append("^-Computer End-^\n\n");
        new textHighlighter("^-Computer End-^", Color.cyan,output);
    }


}
