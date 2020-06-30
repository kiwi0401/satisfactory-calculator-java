package advanced;

import basic.*;
import intermediate.*;
import master.textHighlighter;

import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

public class RadioControlUnit {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public RadioControlUnit(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;


        if (alternateRecipes.get(40).getSelectedItem().toString() == "Default") {
            defaultRadio();
        } else if (alternateRecipes.get(40).getSelectedItem().toString() == "System") {
            systemRadio();
        }
    }

    public void defaultRadio() {
        double heatSink = num * 4;
        double rubber = num * 16;
        double crystalOscillators = num;
        double computers = num;
        output.append(ds.format(num) + " Radio Control Units / Minute:  " + ds.format(heatSink) + " Heat Sinks / minute |  " +
                ds.format(rubber) +" Rubber / minute |  " + ds.format(crystalOscillators) + " Crystal Oscillators / Minute |  " +
                ds.format(computers) + " Computers / minute" +
                ". Requires  " + ds.format(num/2.5) + " Manufacturers\n\n");

        output.append("v-Radio Control Units Start-v\n\n");
        new textHighlighter("v-Radio Control Units Start-v",Color.red,output);

        new HeatSink(heatSink,alternateRecipes,output);
        output.append("-----\n\n");
        new Rubber(rubber,alternateRecipes,output);
        output.append("-----\n\n");
        new CrystalOscillator(crystalOscillators,alternateRecipes,output);
        output.append("-----\n\n");
        new Computer(computers,alternateRecipes,output);

        output.append("^-Radio Control Units End-^\n\n");
        new textHighlighter("^-Radio Control Units End-^",Color.red,output);
    }

    public void systemRadio() {
        double heatSink = num * (10/3.0);
        double supercomputers = num / 3;
        double quartzCrystals = num * 10;
        output.append(ds.format(num) + " Radio Control Systems / Minute:  " + ds.format(heatSink) + " Heat Sinks / minute |  " +
                ds.format(supercomputers) +" Supercomputers / minute |  " + ds.format(quartzCrystals) + " Quartz Crystals / Minute" +
                ". Requires  " + ds.format(num/10) + " Manufacturers\n\n");

        output.append("v-Radio Control Systems Start-v\n\n");
        new textHighlighter("v-Radio Control Systems Start-v",Color.red,output);
        new HeatSink(heatSink,alternateRecipes,output);
        output.append("-----\n\n");
        new Supercomputer(supercomputers,alternateRecipes,output);
        output.append("-----\n\n");
        new QuartzCrystal(quartzCrystals,alternateRecipes,output);
        output.append("^-Radio Control Systems End-^\n\n");
        new textHighlighter("^-Radio Control Systems End-^",Color.red,output);
    }


}
