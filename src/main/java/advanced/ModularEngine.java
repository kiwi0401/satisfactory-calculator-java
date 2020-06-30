package advanced;

import intermediate.*;
import master.textHighlighter;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.List;

public class ModularEngine {

    private double num;
    private List<JComboBox<String>> alternateRecipes;
    private JTextArea output;
    private DecimalFormat ds = new DecimalFormat("#.##");

    public ModularEngine(double num, List<JComboBox<String>> alternateRecipes, JTextArea output) {
        this.num = num;
        this.output = output;
        this.alternateRecipes = alternateRecipes;

        defaultModularEngine();
    }

    public void defaultModularEngine() {
        double motors = num * 2;
        double rubber = num * 15;
        double smartPlating = num * 2;
        output.append(ds.format(num) + " Modular Engines / Minute:  " + ds.format(motors) + " Motors / minute |  " +
                ds.format(rubber) +" Rubber / minute |  " + ds.format(smartPlating) + " Smart Plating / Minute" +
                ". Requires  " + ds.format(num/1) + " Manufacturers\n\n");

        output.append("v-Modular Engine Start-v\n\n");
        new textHighlighter("v-Modular Engine Start-v", Color.ORANGE,output);
        new Motor(motors,alternateRecipes,output);
        output.append("-----\n\n");
        new Rubber(rubber,alternateRecipes,output);
        output.append("-----\n\n");
        new SmartPlating(smartPlating,alternateRecipes,output);
        output.append("^-Modular Engine End-^\n\n");
        new textHighlighter("^-Modular Engine End-^", Color.ORANGE,output);

    }

}
